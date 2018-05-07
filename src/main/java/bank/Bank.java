package bank;


import bank.gen.grpc.*;
import bank.services.BankServiceImpl;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.zeroc.Ice.Util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Bank {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }
    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private final String hostname;
    private final Integer port;
    private final List<Currency> currencies;
    private ManagedChannel channel;
    private final ConcurrentHashMap<bank.gen.ice.Bank.Currency, Double> currencyExchange = new ConcurrentHashMap<>();
    private Communicator communicator;


    Bank(String hostname, Integer port, List<Currency> currencies){
        this.hostname = hostname;
        this.port = port;
        this.currencies = currencies;
    }
    public static void main(String[] args){
        if(args.length < 3){
            logger.warning(String.format("Wrong args! \n" +
                    "use bank currencyExchangehostAdress currencyExchangeport currencies\n\twhere currencies in %s", Arrays.toString(Currency.values())));
        }else{
            String hostname = args[0];
            String port = args[1];
            List<Currency> currencies = new LinkedList<>();
            for(int i = 2; i< args.length ; i++){
                currencies.add(Currency.valueOf(args[i].toUpperCase()));
            }
            logger.info(String.format("Starting Bank for host:%s, port:%s, currencies:%s", hostname, port, Arrays.toString(currencies.toArray())));
            Bank bank = new Bank(hostname, Integer.parseInt(port), currencies);
            bank.start();
        }
    }

    private void start() {
        initExchangeRateClient();
        initBankService();
    }



    private void initExchangeRateClient() {
        channel = ManagedChannelBuilder
                .forAddress(hostname, port)
                .usePlaintext()
                .build();
        Currencies currenciesGRPC = Currencies
                .newBuilder()
                .addAllCurrencies(currencies)
                .build();



        ExchangeServiceGrpc.ExchangeServiceBlockingStub bs = ExchangeServiceGrpc.newBlockingStub(channel);
        //retrieve all
        ExchangeContainer x = bs.getAll(currenciesGRPC);
                x.getRatesList()
                .forEach( er -> {
                    logger.info(String.format("Retrieved currency ratio %s = %s", er.getCurrency().name(), er.getRatio()));
                    currencyExchange.put(bank.gen.ice.Bank.Currency.valueOf(er.getCurrency().getNumber()), er.getRatio());
                }
               );


        //wait for changes for each

        Iterator<ExchangeRate> iterator =
                bs.exchange(currenciesGRPC);

       new Thread(){
           @Override
           public void run() {
               while (iterator.hasNext()) {
                   ExchangeRate er = iterator.next();
                   logger.info(String.format("Updated currency ratio %s = %s", er.getCurrency().name(), er.getRatio()));
                   currencyExchange.put(bank.gen.ice.Bank.Currency.valueOf(er.getCurrency().getNumber()), er.getRatio());
               }
           }
       }.start();

       logger.info("Exchange Rate Updater Started...");

    }


    private void initBankService() {
        communicator = Util.initialize(new String[] {"--Ice.Config=" +ClassLoader.getSystemClassLoader().getResource("config.server").getFile()});
        ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

        //Stworzenie serwanta/serwantów
        BankServiceImpl bankServiceServant = new BankServiceImpl(currencyExchange);

        //Dodanie wpisów do tablicy ASM
        adapter.add(bankServiceServant, new Identity("bank1", "bank"));

        //Aktywacja adaptera i przejcie w pêtlê przetwarzania ¿¹dañ
        adapter.activate();

        logger.info("Initialized Bank Service...");

        communicator.waitForShutdown();
    }
}
