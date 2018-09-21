import java.util.Random;
import java.util.Scanner;

public class Java1Lesson3 {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scaner = new Scanner(System.in);
        for (
                int i = 0;
                i < 50; i++) {
            //System.out.println(Math.random());
            System.out.println(random.nextInt(101));
            //s=s+
            int a = scaner.nextInt();
            int b = scaner.nextInt();
            String s = new scaner.nextInt(10);
            switch (operator) {
                case 1:
                    System.out.println("= " + (a + b));
                    break;
                case 2:
                    System.out.println("= " + (a - b));
                    break;
            }

        }
    }
}
