package technopolis;


import java.util.Random;

/**
 * Created by Anton on 10.11.2016.
 */
public class Pikachu extends Pokemon {

    private double strengthFirst = 1;
    private double strengthSecond = 0.5;
    private Random random = new Random();

    Pikachu(String str, int h) {
        name = str;
        health = h;
    }

    @Override
    public double attack(int num) {
        switch (num) {
            case 1:
                return firstAttack();
            case 2:
                return secondAttack();
        }
        return 0.0;
    }

    private double firstAttack() {
        System.out.println("Attack " + name + " = " + strengthFirst);
        return strengthFirst;
    }

    private double secondAttack() {
        System.out.println("Attack " + name + " = " + strengthSecond);
        return strengthSecond;
    }

    @Override
    public void block(double force) {
        double r = generateNum();
        if (r > 0.55) {
            double d = generateNum();
            r = Math.abs(r - d);
        }
        r = force * (1 - r);
        r = round2(r);
        System.out.println(name + "'s block= " + r);
        health -= r;
        health = round2(health);
    }

    private double round2(double numb) {
        int a;
        double b = numb;
        a = (int) (b * 100);
        b = (double) a / 100;
        return b;
    }

    private double generateNum() {
        return round2(random.nextDouble());
    }

    @Override
    public void training(int num) {
        double r = 1.0;
        while (r > 0.03) {
            r = generateNum();
        }
        switch (num) {
            case 1:
                strengthFirst = round2(strengthFirst + r);
                break;
            case 2:
                strengthSecond = round2(strengthSecond + r);
                break;
        }
    }

    public double getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return name + " health is " + health;
    }
}
