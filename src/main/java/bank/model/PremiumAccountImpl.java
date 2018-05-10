package bank.model;

import bank.gen.ice.Bank.*;
import com.zeroc.Ice.Current;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PremiumAccountImpl extends AccountImpl implements PremiumAccount  {
    private final ConcurrentHashMap<Currency, Double> currencyExchange;
    private final Random random = new Random();
    public PremiumAccountImpl(String accountId, Person person, ConcurrentHashMap<Currency, Double> currencyExchange, Money amount) {
        super(accountId,person, amount);
        this.currencyExchange = currencyExchange;
        this.moneyAmount = amount;
    }

    @Override
    public CreditInfo getForeignCurrencyCreditInfo(Money amount, Date endOfContract, Current current) throws CreditInfoException {
        if(amount.value < 0.0)
            throw new CreditInfoException("Amount negative", CreditInfoError.AMOUNTNEGATIVE);
        float foreignCost = amount.value * (1.0f + random.nextFloat()*0.01f*getMonthsDiff(endOfContract));
        float localCost = (float) (foreignCost * this.currencyExchange.get(amount.currency));
        return new CreditInfo(new Money(localCost, currency), new Money(foreignCost, amount.currency));
    }

}
