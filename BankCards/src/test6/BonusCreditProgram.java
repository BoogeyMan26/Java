package test6;

public class BonusCreditProgram extends CreditCard{
    private String bonusProgram;
    
    public BonusCreditProgram(double creditLimit, String bonusProgram){
    super(creditLimit);
            this.bonusProgram = bonusProgram;
            
    }
        public void getBonusProgram(){
            System.out.println("Бонусная программа:" + bonusProgram);
        }
}
