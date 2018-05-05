#ifndef BANK_ICE
#define BANK_ICE

module Bank
{

    enum Currency {PLN, USD, EUR, GBP, CHF};
    enum AccountCategory {STANDARD, PREMIUM}

    struct Money {
        long value;
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
        Money getMoneyAmount();
        CreditInfo getLocalCurrencyCreditInfo(long amount, Date endOfContract);

    }

    interface PremiumAccount extends Account{
         CreditInfo getForeignCurrencyCreditInfo(Money amount, Date endOfContract);
    }

    interface BankService{
        Account* createAccount(Person person, Money declaredIncome);
        Account* getAccount(long accountId);
    }




};

#endif