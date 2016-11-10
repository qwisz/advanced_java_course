package technopolis;

/**
 * Created by Anton on 10.11.2016.
 */
public abstract class Pokemon
{
    protected double health;
    protected String name;
//    protected static int mana = 20;

    public abstract double attack(int num);

    public abstract void block(double force);

    public abstract void training(int num);
}
