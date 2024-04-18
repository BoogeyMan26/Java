package test6;

class DebitCard extends BankCard {
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Карта успешно пополнена на " + amount + " рублей");
    }

    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Оплата прошла успешно");
            return true;
        } else {
            System.out.println("Недостаточно средств на карте");
            return false;
        }
    }

    public void getAvailableFunds() {
        System.out.println("Доступные средства на карте: " + balance + " рублей");
    }
}