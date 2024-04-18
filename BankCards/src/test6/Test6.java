package test6;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankCard card;

        System.out.println("Выберите тип карты:");
        System.out.println("1. DebitCard");
        System.out.println("2. CreditCard");
        int cardType = scanner.nextInt();

        if (cardType == 1)
            card = new DebitCard();
        else
            card = new CreditCard(10000);

        System.out.println("Введите начальный баланс карты:");
        double initialBalance = scanner.nextDouble();
        card.deposit(initialBalance);

        boolean flag = true;

        while (flag) {
            System.out.println("Выберите действие:");
            System.out.println("1. Пополнить карту");
            System.out.println("2. Оплатить");
            System.out.println("3. Получить информацию о балансе");
            System.out.println("4. Получить информацию о доступных средствах");
            System.out.println("0. Выйти из программы");

            int choice = scanner.nextInt();
               switch (choice) {
                case 1:
                    System.out.println("Введите сумму для пополнения:");
                    double amountToTopUp = scanner.nextDouble();
                    card.deposit(amountToTopUp);
                    break;
                case 2:
                    System.out.println("Введите сумму для оплаты:");
                    double amountToPay = scanner.nextDouble();
                    card.pay(amountToPay);
                    break;
                case 3:
                    System.out.println("Баланс карты: " + card.getBalance() + " рублей");
                    break;
                case 4:
                    if (card instanceof CreditCard) {
                        ((CreditCard) card).getAvailableFunds();
                    } else {
                        card.getAvailableFunds();
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }

        //scanner.close();
    }
}

