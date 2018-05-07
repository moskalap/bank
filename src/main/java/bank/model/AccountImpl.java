package bank.model;

import bank.gen.ice.Bank.*;
import bank.services.BankServiceImpl;
import com.zeroc.Ice.Current;

import java.util.Random;
import java.util.logging.Logger;

public class AccountImpl implements Account {
    private static final Logger logger = Logger.getLogger(BankServiceImpl.class.getName());
    private Random random = new Random();
    private final String accountId;
    protected Currency currency;
    protected Money moneyAmount;
    public AccountImpl(String accountId, Money amount){
        this.accountId = accountId;
        this.currency = Currency.PLN;
        this.moneyAmount =amount;
    }
    @Override
    public String getAccountId(Current current) {
                return this.accountId;
    }

    @Override
    public Money getMoneyAmount(Current current) {
        logger.info("Checked an account balance for accountId: " + accountId.toString());
        return moneyAmount;
    }

    @Override
    public CreditInfo getLocalCurrencyCreditInfo(float amount, Date endOfContract, Current current) {
        logger.info(String.format("Got credit info for amount: %s %s", amount, currency.name()));
        CreditInfo ci = new CreditInfo();
        ci.localCurrency = new Money(amount * (1.0f + random.nextFloat()*0.1f), currency);
        return ci;
    }
}
