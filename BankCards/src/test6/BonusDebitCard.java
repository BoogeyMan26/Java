package test6;

public class BonusDebitCard extends DebitCard{
    private String bonusProgram;
    public BonusDebitCard(String bonusProgram){
        this.bonusProgram = bonusProgram;
    }
public void getBonusProgram(){
    System.out.println("Бонусная программа" + bonusProgram);
}
}
