package technopolis;

import java.util.Random;

/**
 * Created by Anton on 10.11.2016.
 */
public abstract class Pokemon
{
    double health;
    String name;
    private Random random = new Random();


    public abstract double attack(int num);

    public void block(double force) {
        double r = generateNum();
        if (r > 0.55) {
            double d = generateNum();
            r = Math.abs(r - d);
        }
        r = force * (1 - r);
        r = round2(r);
        System.out.println(this.name + "'s block= " + r);
        health -= r;
        health = round2(health);
    }

    public abstract void training(int num);

    public double generateNum() {
        return round2(random.nextDouble());
    }

    public double round2(double numb) {
        int a;
        double b = numb;
        a = (int) (b * 100);
        b = (double) a / 100;
        return b;
    }

    public double getHealth() {
        return this.health;
    }
}
