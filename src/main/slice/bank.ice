#ifndef BANK_ICE
#define BANK_ICE

module Bank
{

    enum Currency {PLN, USD, EUR, GBP, CHF};
    enum AccountStructureError {AMOUNTNEGATIVE, PESELNOTNUMERIC, PESELLENGTH};
    enum CreditInfoError { AMOUNTNEGATIVE, DATEPAST};
    enum AccountCategory {STANDARD, PREMIUM};

    struct Money {
        float value;
        Currency currency;
    }

    struct Date {
        byte day;
        byte month;
        short year;
    }

    struct Person {
        string name;
        string surname;
        string pesel;
    }

    struct CreditInfo{
        Money localCurrency;
        Money foreignCurrency;
    }
    exception BankException{
        string msg;
    }

    exception AccountCreationException extends BankException {
        AccountStructureError errorType;
    }

    exception CreditInfoException extends BankException{
        CreditInfoError error;
    }

    interface Account{
        string getAccountId();
        Money getMoneyAmount();
        CreditInfo getLocalCurrencyCreditInfo(float amount, Date endOfContract) throws CreditInfoException;
    }

    interface PremiumAccount extends Account{
         CreditInfo getForeignCurrencyCreditInfo(Money amount, Date endOfContract) throws CreditInfoException;
    }

    interface BankService{
        Account* createAccount(Person person, Money declaredIncome, Money amount) throws AccountCreationException;
        Account* getAccount(string pesel, AccountCategory category);
    }

};

#endif