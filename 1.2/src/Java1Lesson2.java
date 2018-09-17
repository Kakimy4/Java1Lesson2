/**
 * Java Level 1. Lesson 2. Home Task
 *
 * @version dated sept 17 2018
 * @autor Durasov Maxim
 */

public class Java1Lesson2 {
    public static void main(String[] args) {
        // Задание 1
        int[] arr1 = {0, 0, 1, 1, 1, 0};
        System.out.println("Длинна массива в епрвом зании - " + arr1.length);
        task1(arr1);
        // Задание 2
        int[] arr2 = new int[8];
        task2(arr2);
        // Задание 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task3(arr3);
        // Задание 4
        int[][] arr4 = new int[6][6];
        task4(arr4);
        // Задание 5
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task5(arr5);
        // Задание 6
        int[] arr6 = {1, 5, 3, 2, 1, 4, 5, 2, 4, 8, 9, 2};
        task6(arr6);
        // Задание 7
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 2;
        task7(arr7, n);
    }

    private static void task7(int[] arr, int n) {
        System.out.println("\n" + "Вывод результатов задания 7" + "\n" + "  Вывод входного массива");
        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + ", ");
        }
        if (n > 0) task7positive(arr, n);
        else task7negative(arr, n);
        System.out.println("\n" + "  Вывод результирующего массива");
        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + ", ");
        }
    }

    private static int[] task7positive(int[] arr, int n) {
        int temp, targetPosition;
        n = n % arr.length;
        for (int a = arr.length - 1; a >= n; a--) {
            targetPosition = (a + n) % arr.length;
            if (targetPosition >= arr.length) targetPosition -= arr.length;
            temp = arr[targetPosition];
            arr[targetPosition] = arr[a];
            arr[a] = temp;
        }
        return arr;
    }

    private static int[] task7negative(int[] arr, int n) {
        int temp, targetPosition;
        n = n % arr.length;
        for (int a = -n; a < arr.length; a++) {
            targetPosition = a + n;
            if (targetPosition >= arr.length) targetPosition -= arr.length;
            temp = arr[targetPosition];
            arr[targetPosition] = arr[a];
            arr[a] = temp;
        }
        return arr;
    }


    private static boolean task6(int[] arr) {
        System.out.println("\n" + "Вывод результатов задания 6");
        int leftSum = 0;
        int rightSum = 0;
        if (arr.length < 2) return false;
        for (int b = 1; b < arr.length; b++) {
            for (int a = 0; a < arr.length; a++) {
                if (a < b) leftSum += arr[a];
                else rightSum += arr[a];
            }
            if (leftSum == rightSum) {
                System.out.println("Найдена комбинация, где левая и правая части равны");
                System.out.println("i = " + b + "/" + arr.length + "  leftSum = " + leftSum + "  rightSum = " + rightSum);
                return true;
            }
            leftSum = rightSum = 0;
        }
        System.out.println("Не найдена комбинация, где левая и правая части равны");
        return false;
    }

    private static void task5(int[] arr) {
        System.out.println("\n" + "Вывод результатов задания 5");
        int min = arr[0];
        int max = arr[0];
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] < min) min = arr[a];
            if (arr[a] > max) max = arr[a];
        }
        System.out.println("min = " + min + "\n" + "max = " + max);
    }

    private static void task4(int[][] arr) {
        System.out.println("\n" + "Вывод результатов задания 4");
        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr.length; b++) {
                if (a == b || a == arr.length - b - 1) arr[a][b] = 1;
                else arr[a][b] = 0;
                System.out.print(arr[a][b] + " ");
            }
            System.out.println();
        }
    }

    private static void task3(int[] arr) {
        System.out.println("\n" + "Вывод результатов задания 3");
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] < 6) arr[a] *= 2;
            System.out.println(arr[a]);
        }
    }

    private static void task2(int[] arr) {
        System.out.println("\n" + "Вывод результатов задания 2");
        for (int a = 0; a < arr.length; a++) {
            arr[a] = a * 3;
            System.out.println(arr[a]);
        }
    }

    private static void task1(int[] arr) {
        System.out.println("\n" + "Вывод результатов задания 1");
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == 0)
                arr[a] = 1;
            else
                arr[a] = 0;
            System.out.println(arr[a]);
        }
    }
}
