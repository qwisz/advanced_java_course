package technopolis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pikachu pika1 = new Pikachu("Anton", 10);
        Pikachu pika2 = new Pikachu("Mikhail", 10);
        Pikachu pika3 = new Pikachu("Alexey", 10);
        Random rand = new Random();
        int i = 0;
        while (i < 10) {
            pika1.training(1);
            pika2.training(1);
            i++;
        }
        int n = 0;
        while (true) {
            n = (int)(rand.nextDouble()) + 1;
            double a = pika1.attack(n);
            pika2.block(a);
            System.out.println(pika2.toString());
            if (pika2.getHealth() <= 0) {
                System.out.println(pika1.name + " IS CHAMPIOOOOOON!!!");
                break;
            }
            n = (int)(rand.nextDouble()) + 1;
            double b = pika2.attack(n);
            pika1.block(b);
            System.out.println(pika1.toString());
            if (pika1.getHealth() <= 0) {
                System.out.println(pika2.name + " IS CHAMPIOOOOOON!!!");
                break;
            }
            n = (int)(rand.nextDouble()) + 1;
            pika3.training(n);

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
