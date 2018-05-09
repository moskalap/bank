package bank.services;

import bank.Bank;
import bank.gen.ice.Bank.*;
import bank.model.AccountImpl;
import bank.model.PremiumAccountImpl;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectPrx;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class BankServiceImpl implements BankService {
    private static final Logger logger = Logger.getLogger(BankServiceImpl.class.getName());
    public static long ids = 0;
    private final ConcurrentHashMap<Currency, Double> currencyExchange;

    public BankServiceImpl(ConcurrentHashMap<Currency, Double> currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    @Override
    public AccountPrx createAccount(Person person, Money declaredIncome, Money amount, Current current) throws AccountCreationException {
        validate(person, declaredIncome, amount);

        if(declaredIncome.value > 100000){
            ObjectPrx account = current.adapter.add(new PremiumAccountImpl(person.pesel, currencyExchange, amount), new Identity(person.pesel, AccountCategory.PREMIUM.name()));
            logger.info(String.format("Created an premium account for user {%s,%s,%s} with declared income = %s and money amount = %s", person.name, person.surname, person.pesel, declaredIncome, amount));
            return PremiumAccountPrx.checkedCast(account);
        }else{
            ObjectPrx account = current.adapter.add(new AccountImpl(person.pesel, amount), new Identity(person.pesel, AccountCategory.STANDARD.name()));
            logger.info(String.format("Created an standard account for user {%s,%s,%s} with declared income = %s and money amount = %s", person.name, person.surname, person.pesel, declaredIncome, amount));
            return AccountPrx.checkedCast(account);
        }
    }

    private void validate(Person person, Money income, Money amount) throws AccountCreationException{
        if(person.pesel.length() != 11)
            throw new AccountCreationException("Pesel length should be 11", AccountStructureError.PESELLENGTH);
        for (char c : person.pesel.toCharArray()) {
            if (!Character.isDigit(c)) throw new AccountCreationException("Pesel should be numeric", AccountStructureError.PESELNOTNUMERIC);
        }
        if(income.value < 0.0f || amount.value < 0.0f )
            throw new AccountCreationException("Income/amount should be non negative", AccountStructureError.AMOUNTNEGATIVE);

    }

    @Override
    public AccountPrx getAccount(String pesel, AccountCategory category, Current current) {
        return AccountPrx.uncheckedCast(current.adapter.createProxy(new Identity(pesel, category.name())));
    }
}
