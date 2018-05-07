#ifndef BANK_ICE
#define BANK_ICE

module Bank
{

    enum Currency {PLN, USD, EUR, GBP, CHF};
    enum AccountCategory {STANDARD, PREMIUM}

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

    interface Account{
        string getAccountId();
        Money getMoneyAmount();
        CreditInfo getLocalCurrencyCreditInfo(float amount, Date endOfContract);
    }

    interface PremiumAccount extends Account{
         CreditInfo getForeignCurrencyCreditInfo(Money amount, Date endOfContract);
    }

    interface BankService{
        Account* createAccount(Person person, Money declaredIncome, Money amount);
        Account* getAccount(string accountId);
    }

};

#endif