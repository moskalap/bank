package bank.exchange;

import bank.gen.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Random;
import java.util.stream.Collectors;

import static bank.gen.grpc.Currency.*;

public class ExchangeServiceImpl extends ExchangeServiceGrpc.ExchangeServiceImplBase {
    Logger logger = Logger.getLogger(ExchangeServiceImpl.class.getName());
    private static long NAP_TIME = 25000;
    private Map<Currency, Double> currentExchangesRates = new HashMap<>();
    private Random random = new Random();

    public ExchangeServiceImpl() {
        currentExchangesRates.put(USD, 3.55d);
        currentExchangesRates.put(PLN, 1.0d);
        currentExchangesRates.put(EUR, 4.26d);
        currentExchangesRates.put(CHF, 3.55d);
        currentExchangesRates.put(GBP, 4.81d);
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
                    .forEach(e -> {
                        currentExchangesRates.put(e.getCurrency(), e.getRatio());
                        logger.info("\n" + e.toString());
                        responseObserver.onNext(e);
                    });

            try {
                Thread.sleep(NAP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void getAll(Currencies currencies, StreamObserver<ExchangeContainer> observer) {
        observer.onNext(ExchangeContainer
                .newBuilder()
                .addAllRates(
                        currencies
                                .getCurrenciesList()
                                .stream()
                                .map(cur ->
                                        ExchangeRate
                                                .newBuilder()
                                                .setCurrency(cur)
                                                .setRatio(currentExchangesRates.get(cur)).build())
                                .collect(Collectors.toList())
                )

                .build());
        observer.onCompleted();


    }

}


