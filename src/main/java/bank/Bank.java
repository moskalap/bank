package bank;


import bank.gen.grpc.Currencies;
import bank.gen.grpc.ExchangeRate;
import bank.gen.grpc.ExchangeServiceGrpc;
import bank.gen.grpc.Currency;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Bank {
    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private final String hostname;
    private final Integer port;
    private final List<Currency> currencies;
    private ManagedChannel channel;
    private final ConcurrentHashMap<Currency, Float> currencyExchange = new ConcurrentHashMap<>();


    Bank(String hostname, Integer port, List<Currency> currencies){
        this.hostname = hostname;
        this.port = port;
        this.currencies = currencies;
    }
    public static void main(String[] args){
        if(args.length < 3){
            logger.warning(String.format("Wrong args! use bank hostAdress port currencies\n\twhere currencies in %s", Arrays.toString(Currency.values())));
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
        //initBankService();
    }

    private void initExchangeRateClient() {
        channel = ManagedChannelBuilder
                .forAddress(hostname, port)
                .usePlaintext()
                .build();
        ExchangeServiceGrpc.newBlockingStub(channel);

        Iterator<ExchangeRate> iterator = ExchangeServiceGrpc.newBlockingStub(channel)
                .exchange(
                        Currencies
                                .newBuilder()
                                .addAllCurrencies(currencies)
                                .build()
                );

       new Thread(() -> {
           while(iterator.hasNext()){
               ExchangeRate er = iterator.next();
               logger.info(er.toString());
               currencyExchange.put(er.getCurrency(), er.getRatio());
           }
       }).run();





    }
}
