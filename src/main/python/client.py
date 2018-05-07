import sys
import Ice
import Bank
from Bank import Person, Money, Currency, Date, Account
from Bank import BankServicePrx

if __name__ == '__main__':
    communicator = Ice.initialize(sys.argv)
    base = communicator.stringToProxy('bank/bank1:tcp -h localhost -p 10001:udp -h localhost -p 10001')
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
                    account = bankService.createAccount(Person(line[1], line[2], line[3]),
                                                        Money(float(line[4]), Currency.PLN),
                                                        Money(float(line[5]), Currency.PLN))

            if cmd == 'state':
                print(account.getMoneyAmount().value)



        except Exception as e:
            print(e)

