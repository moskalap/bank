import sys
import Ice
import Bank

from Bank import Person, Money, Currency, Date, Account, PremiumAccountPrx, AccountCategory
from Bank import BankServicePrx
curr_map = {
        'PLN': Currency.PLN,
        'EUR': Currency.EUR,
        'USD': Currency.USD,
        'CHF': Currency.CHF,
        'GBP': Currency.GBP
}
if __name__ == '__main__':
    communicator = Ice.initialize(sys.argv)
    base = communicator.stringToProxy('bank/bank1:tcp -h localhost -p 10002:udp -h localhost -p 10002')
    bankService = BankServicePrx.checkedCast(base)
    if not bankService:
        exit(-1)
    account = None
    line = None
    while line != 'x':
        try:
            print("==> ")
            line = sys.stdin.readline().strip().split()
            cmd = line[0]
            if cmd == 'create':
                if len(line) != 6:
                    print("create name surname pesel income amount")
                else:
                    account = bankService.createAccount(Person(line[1], line[2], line[3]),Money(float(line[4]), Currency.PLN), Money(float(line[5]), Currency.PLN))
                    print("created account" + account.getAccountId())
            if cmd == 'state':
                print(account.getMoneyAmount().value)

            if cmd == 'credit':
                if len(line) != 5:
                    print('credit day month year amount');
                elif account is not None:
                    creditInfo = account.getLocalCurrencyCreditInfo(float(line[4]), Date(int(line[1]),int(line[2]),int(line[3])))
                    print('{} {}'.format(creditInfo.localCurrency.value, creditInfo.localCurrency.currency))

            if cmd == 'creditPrem':
                if len(line) != 6:
                    print('creditPrem day month year amount currency');
                else:
                    if PremiumAccountPrx.checkedCast(account) is not None:
                        date = Date(int(line[1]),int(line[2]),int(line[3]))
                        creditInfo = PremiumAccountPrx.checkedCast(account).getForeignCurrencyCreditInfo(Money(float(line[4]), curr_map[line[5]]), date)
                        print('Total cost for credit({} {}, {}/{}/{}) is \n local: {} {}\n foreign: {} {}'.format(
                            line[4], line[5], date.day, date.month, date.year,
                            creditInfo.localCurrency.value, creditInfo.localCurrency.currency,
                            creditInfo.foreignCurrency.value, creditInfo.foreignCurrency.currency
                        ))
                    else:
                        print("not premium")

            if cmd == 'find':
                if len(line) != 2:
                    print('find id')
                else:
                    account = bankService.getAccount(line[1])
                    if account is not None:
                        print('logged into account '+account.getAccountId())

        except Exception as e:
            print(e)

