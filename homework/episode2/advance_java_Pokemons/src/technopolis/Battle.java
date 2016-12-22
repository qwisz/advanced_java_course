package technopolis;

import java.util.Random;

/**
 * Created by Anton on 23.12.2016.
 */
public class Battle {

    private Pokemon pokemonOne;
    private Pokemon pokemonSec;
    private Pokemon pokemonThr;
    private Random rand = new Random();

    Battle(Pokemon pokemonO, Pokemon pokemonS, Pokemon pokemonT) {
        pokemonOne = pokemonO;
        pokemonSec = pokemonS;
        pokemonThr = pokemonT;
    }

    public void startBattle() {
        int n;
        while (true) {
            n = Math.round(rand.nextFloat()) + 1;
            double a = pokemonOne.attack(n);
            pokemonSec.block(a);
            System.out.println(pokemonSec.toString());
            if (pokemonSec.getHealth() <= 0) {
                System.out.println(pokemonOne.name + " IS CHAMPIOOOOOON!!!");
                break;
            }
            n = Math.round(rand.nextFloat()) + 1;
            double b = pokemonSec.attack(n);
            pokemonOne.block(b);
            System.out.println(pokemonOne.toString());
            if (pokemonOne.getHealth() <= 0) {
                System.out.println(pokemonSec.name + " IS CHAMPIOOOOOON!!!");
                break;
            }
            n = (int)(rand.nextDouble()) + 1;
            pokemonThr.training(n);

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
