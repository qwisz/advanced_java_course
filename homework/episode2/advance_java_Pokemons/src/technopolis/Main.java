package technopolis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Raichu pika1 = new Raichu("Anton", 10);
        Pikachu pika2 = new Pikachu("Mikhail", 10);
        Pikachu pika3 = new Pikachu("Alexey", 10);
        Battle b = new Battle(pika1, pika2, pika3);
        b.startBattle();
    }
}
