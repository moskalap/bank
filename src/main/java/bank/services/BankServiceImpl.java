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
    private  final ConcurrentHashMap<String, Identity> accountMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Currency, Double> currencyExchange;

    public BankServiceImpl(ConcurrentHashMap<Currency, Double> currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    @Override
    public AccountPrx createAccount(Person person, Money declaredIncome, Money amount, Current current) throws AccountException {
        validate(person, declaredIncome, amount);

        if(declaredIncome.value > 100000){
            Identity id = new Identity(person.pesel, AccountCategory.PREMIUM.name());
            String accountId = new String(person.surname).concat(String.valueOf(ids++));
            accountMap.put(accountId, id);
            ObjectPrx account = current.adapter.add(new PremiumAccountImpl(accountId, person, currencyExchange, amount), id);
            logger.info(String.format("Created an premium account for user {%s,%s,%s} with declared income = %s and money amount = %s", person.name, person.surname, person.pesel, declaredIncome, amount));
            return PremiumAccountPrx.checkedCast(account);
        }else{
            Identity id = new Identity(person.pesel, AccountCategory.STANDARD.name());
            String accountId = new String(person.surname).concat(String.valueOf(ids++));
            accountMap.put(accountId, id);
            ObjectPrx account = current.adapter.add(new AccountImpl(accountId, person, amount),id );
            logger.info(String.format("Created an standard account for user {%s,%s,%s} with declared income = %s and money amount = %s", person.name, person.surname, person.pesel, declaredIncome, amount));
            return AccountPrx.checkedCast(account);
        }
    }

    private void validate(Person person, Money income, Money amount) throws AccountException{
        if(person.pesel.length() != 11)
            throw new AccountException("Pesel length should be 11", AccountError.PESELLENGTH);
        for (char c : person.pesel.toCharArray()) {
            if (!Character.isDigit(c)) throw new AccountException("Pesel should be numeric", AccountError.PESELNOTNUMERIC);
        }
        if(income.value < 0.0f || amount.value < 0.0f )
            throw new AccountException("Income/amount should be non negative", AccountError.AMOUNTNEGATIVE);

    }

    @Override
    public AccountPrx getAccount(String id, Current current) throws AccountException {
        if(accountMap.containsKey(id))
            return AccountPrx.uncheckedCast(current.adapter.createProxy(accountMap.get(id)));
        else throw new AccountException("Account dont exist", AccountError.ACCNTDONTEXIST);
    }
}
