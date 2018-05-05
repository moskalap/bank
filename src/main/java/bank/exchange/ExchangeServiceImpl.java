package bank.exchange;

import bank.gen.grpc.Currencies;
import bank.gen.grpc.Currency;
import bank.gen.grpc.ExchangeRate;
import bank.gen.grpc.ExchangeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Random;

import static bank.gen.grpc.Currency.*;

public class ExchangeServiceImpl extends ExchangeServiceGrpc.ExchangeServiceImplBase {
    Logger logger = Logger.getLogger(ExchangeServiceImpl.class.getName());
    private static long NAP_TIME = 5000;
    private Map<Currency, Float> currentExchangesRates = new HashMap<>();
    private Random random = new Random();

    public ExchangeServiceImpl() {
        currentExchangesRates.put(USD, 3.55f);
        currentExchangesRates.put(PLN, 1.0f);
        currentExchangesRates.put(EUR, 4.26f);
        currentExchangesRates.put(CHF, 3.55f);
        currentExchangesRates.put(GBP, 4.81f);
    }

    @Override
    public void exchange(Currencies currencies, StreamObserver<ExchangeRate> responseObserver) {
        while (true) {
            currencies.getCurrenciesList()
                    .stream()
                    .filter(c -> !c.equals(PLN))
                    .map(c ->
                            ExchangeRate
                                    .newBuilder()
                                    .setCurrency(c)
                                    .setRatio(currentExchangesRates.get(c) + (random.nextBoolean() ? -0.1f * random.nextFloat() : 0.1f * random.nextFloat()))
                                    .build())
                    .forEach(responseObserver::onNext);

            try {
                Thread.sleep(NAP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


