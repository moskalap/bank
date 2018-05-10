package bank;

import bank.gen.ice.Bank.*;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

public class Client {
    public static void main(String[] args) {
        int status = 0;
        Communicator communicator = null;

        try {
            communicator = Util.initialize(new String[]{"--Ice.Config=" + ClassLoader.getSystemClassLoader().getResource("config.client").getFile()});
            ObjectPrx base = communicator.propertyToProxy("Bank1.Proxy");
            BankServicePrx obj = BankServicePrx.checkedCast(base);
            if (obj == null) throw new Error("Invalid proxy");

            String[] line = null;
            AccountPrx account = null;
            Date date = null;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            do {
                try {
                    System.out.print("==> ");
                    System.out.flush();
                    line = in.readLine().split(" ");
                    if (line.length > 0) {
                        switch (line[0].toLowerCase()) {
                            case "create":
                                if (line.length != 6) {
                                    System.out.println("create name surname pesel income amount");
                                } else {
                                    account = obj.createAccount(new Person(line[1], line[2], line[3]), new Money(Float.parseFloat(line[4]), Currency.PLN), new Money(Float.parseFloat(line[5]), Currency.PLN));
                                    System.out.println("Creted account: id="+account.getAccountId());
                                }

                                break;
                            case "state":
                                if (account == null)
                                    System.out.println("Log to account or create new!");
                                else {
                                    System.out.println(account.getMoneyAmount().value);
                                }

                                break;
                            case "credit":
                                if (line.length != 5) {
                                    System.out.println("credit day month year amount");
                                    break;
                                }
                                if (account == null) {
                                    System.out.println("Log to account or create new!");
                                    break;
                                }
                                date = new Date(Short.parseShort(line[1]), Short.parseShort(line[2]), Integer.parseInt(line[3]));
                                CreditInfo info = account.getLocalCurrencyCreditInfo(Float.parseFloat(line[4]), date);
                                System.out.println(String.format("Total cost for credit(%s, %s/%s/%s) is %s %s", line[4], date.day, date.month, date.year, info.localCurrency.value, info.localCurrency.currency.name()));

                                break;
                            case "creditprem":
                                if (PremiumAccountPrx.checkedCast(account) == null) {
                                    System.out.println("Cannot obtaing foreign currency load in standard account");
                                    break;
                                }
                                account = PremiumAccountPrx.checkedCast(account);
                                if (line.length != 6) {
                                    System.out.println("credit day month year amount currency");
                                    break;
                                }
                                if (account == null) {
                                    System.out.println("Log to account or create new!");
                                    break;
                                }

                                date = new Date(Short.parseShort(line[1]), Short.parseShort(line[2]), Integer.parseInt(line[3]));
                                CreditInfo infoTotal = ((PremiumAccountPrx) account).getForeignCurrencyCreditInfo(new Money(Float.parseFloat(line[4]), Currency.valueOf(line[5])), date);
                                System.out.println(String.format("Total cost for credit(%s %s, %s/%s/%s) is " +
                                                "\n local: %s %s" +
                                                "\n foreign: %s %s", line[4], line[5], date.day, date.month, date.year,
                                        infoTotal.localCurrency.value, infoTotal.localCurrency.currency.name(),
                                        infoTotal.foreignCurrency.value, infoTotal.foreignCurrency.currency.name()
                                ));

                                break;
                            case "find":
                                if (line.length != 2) {
                                    System.out.println("find id");
                                    break;
                                }
                                account = obj.getAccount(line[1]);
                                System.out.println("Logged into account: id="+account.getAccountId());
                                break;
                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (!line[0].equals("x"));


        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }
}
