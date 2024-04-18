package test6;

class CreditCard extends BankCard {
    private double creditLimit;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void deposit(double amount) {
        if (balance + amount > creditLimit) {
            double remainingAmount = creditLimit - balance;
            balance = creditLimit;
            System.out.println("Карта пополнена на " + remainingAmount + " рублей, кредитный лимит исчерпан");
        } else {
            balance += amount;
            System.out.println("Карта успешно пополнена на " + amount + " рублей");
        }
    }

    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Оплата прошла успешно");
            return true;
        } else if (balance + (creditLimit - balance) >= amount) {
            double remainingAmount = amount - balance;
            balance = creditLimit;
            System.out.println("Оплата прошла успешно. Перевышен кредитный лимит, сумма " + remainingAmount + " рублей списана с кредитной части");
            return true;
        } else {
            System.out.println("Недостаточно средств на карте");
            return false;
        }
    }

    public void getAvailableFunds() {
        System.out.println("Доступные средства на карте: " + balance + " рублей");
        System.out.println("Кредитный лимит: " + creditLimit + " рублей");
    }
}