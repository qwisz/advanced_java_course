import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Start");
        Scanner scanner = new Scanner(System.in);
        LFUCache cache = new LFUCache();
        while (true) {
            int ques = scanner.nextInt();
            System.out.println(cache.calculate(ques));
        }
    }

}
