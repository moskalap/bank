package bank.model;

import bank.gen.ice.Bank.*;
import com.zeroc.Ice.Current;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PremiumAccountImpl extends AccountImpl implements PremiumAccount  {
    private final ConcurrentHashMap<Currency, Double> currencyExchange;
    private final Random random = new Random();
    public PremiumAccountImpl(String accountId, ConcurrentHashMap<Currency, Double> currencyExchange, Money amount) {
        super(accountId, amount);
        this.currencyExchange = currencyExchange;
        this.moneyAmount = amount;
    }

    @Override
    public CreditInfo getForeignCurrencyCreditInfo(Money amount, Date endOfContract, Current current) {
        float foreignCost = amount.value * (1.0f + random.nextFloat()*0.1f);
        float localCost = (float) (foreignCost * this.currencyExchange.get(amount.currency));
        return new CreditInfo(new Money(localCost, currency), new Money(foreignCost, amount.currency));
    }

}
