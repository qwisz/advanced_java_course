package technopolis;


import java.util.Random;

/**
 * Created by Anton on 10.11.2016.
 */
public class Pikachu extends Pokemon implements  TailAttack, ElectricAttack{

    private double strengthElec = 1;
    private double strengthTail = 0.5;

    Pikachu(String str, int h) {
        name = str;
        health = h;
    }

    @Override
    public double attack(int num) {
        switch (num) {
            case 1:
                return attackWithTail();
            case 2:
                return electroAttack();
        }
        return 0.0;
    }

    public double attackWithTail() {
        System.out.println(name + " attacks with tail: " + strengthTail);
        return strengthTail;
    }
    
    public double electroAttack() {
        System.out.println(name + " attacks with electricity: " + strengthElec);
        return strengthElec;
    }

    public void block(double force) {
        super.block(force);
    }

    @Override
    public void training(int num) {
        double r = 1.0;
        while (r > 0.03) {
            r = generateNum();
        }
        switch (num) {
            case 1:
                strengthElec = round2(strengthElec + r);
                break;
            case 2:
                strengthTail = round2(strengthTail + r);
                break;
        }
    }

    @Override
    public String toString() {
        return name + " health is " + health;
    }
}
