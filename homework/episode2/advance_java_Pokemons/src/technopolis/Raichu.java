package technopolis;

/**
 * Created by Anton on 23.12.2016.
 */
public class Raichu extends Pokemon implements FireAttack, LeftHook {
    private double strengthHook = 1.05;
    private double strengthFire = 0.55;

    Raichu(String str, int h) {
        name = str;
        health = h;
    }

    public void block(double force) {
        super.block(force);
    }

    @Override
    public void training(int num) {
        double r = 1.0;
        while (r > 0.05) {
            r = generateNum();
        }
        switch (num) {
            case 1:
                strengthHook = round2( r + strengthHook);
                break;
            case 2:
                if (r >= 0.04)
                    r = 0.03;
                strengthFire = round2(strengthFire + r);
                break;
        }
    }

    @Override
    public double attack(int num) {
        switch (num) {
            case 1:
                return leftHook();
            case 2:
                return fireAttack();
        }
        return 0.0;
    }

    @Override
    public double leftHook() {
        System.out.println(name + " attacks with left hook: " + strengthHook);
        return strengthHook;
    }

    @Override
    public double fireAttack() {
        System.out.println(name + " attacks with fire: " + strengthFire);
        return strengthFire;
    }

    @Override
    public String toString() {
        return name + " health is " + health;
    }
}
