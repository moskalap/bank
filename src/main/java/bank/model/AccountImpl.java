package bank.model;

import bank.gen.ice.Bank.*;
import bank.services.BankServiceImpl;
import com.zeroc.Ice.Current;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Logger;

public class AccountImpl implements Account {
    private static final Logger logger = Logger.getLogger(BankServiceImpl.class.getName());
    protected final Person person;
    private Random random = new Random();
    private final String accountId;
    protected Currency currency;
    protected Money moneyAmount;
    public AccountImpl(String accountId, Person person, Money amount){
        this.accountId = accountId;
        this.person = person;
        this.currency = Currency.PLN;
        this.moneyAmount =amount;
    }
    protected int getMonthsDiff(Date date) throws CreditInfoException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(new java.util.Date());

        Calendar endCalendar = new GregorianCalendar();
        try {
            endCalendar.setTime(dateFormat.parse(date.month+"/"+date.day+"/"+date.year));
        } catch (ParseException e) {
            return 1;
        }
        if(endCalendar.getTime().before(startCalendar.getTime()))
            throw new CreditInfoException("Date before today", CreditInfoError.DATEPAST);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
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
    public CreditInfo getLocalCurrencyCreditInfo(float amount, Date endOfContract, Current current) throws CreditInfoException {
        if(amount < 0.0)
            throw new CreditInfoException("Amount negative", CreditInfoError.AMOUNTNEGATIVE);
        logger.info(String.format("Got credit info for amount: %s %s", amount, currency.name()));
        CreditInfo ci = new CreditInfo();
        ci.localCurrency = new Money(amount * (1.0f + random.nextFloat()*0.01f*getMonthsDiff(endOfContract)), currency);
        return ci;
    }
}
