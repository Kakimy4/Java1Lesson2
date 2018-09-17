public class Main {



    public static void main(String[] args) {

        double l3_a = 1;

        double l3_b = 2;

        double l3_c = 3;

        double l3_d = 4;

        System.out.println("Результат задания 3 - " + task3(l3_a, l3_b, l3_c, l3_d));

        System.out.println("Результат задания 4 - " + task4(l3_a, l3_b));

        int m = -10;

        task5(m);

        System.out.println("Результат задания 6 - " + task6(m));

        String name = "Max";

        task7(name);

        int year = 2000;

        task8(year);

    }



    public static void l2() {

// Задание 2. Ининциализация всех типов переменных

        byte b = 1;

        short s = 2;

        long l = 3;

        int i = 4;

        double d = 5.0;

        float f = 6.0f;

        char c = 'c';

        boolean bo = true;

    }



    public static double task3(double a, double b, double c, double d) {

        return a * (b + (c / d));

    }



    public static boolean task4(double a, double b) {

        if ((a + b) > 10 && (a + b) < 20) return true;

        return false;

    }



    public static void task5(int a) {

        System.out.println("Результат задания 5 - " + (a >= 0 ? "Число положительное" : "Число отрицателное"));

    }



    public static boolean task6(int a) {

        return (a < 0 ? true : false);

    }



    public static void task7(String a) {

        System.out.println("Результат задания 7 - " + "Привет, " + a + "!");

    }



    public static void task8(int a) {

        System.out.println("Результат задания 8 - " + (a % 4 == 0 & (a % 100 != 0 | a % 400 == 0) ? "Год " + a + " - високосный" : "Год " + a + " - НЕ високосный"));

    }

}

　



　


　
