/**
 * Java Level 1. Lesson 3. Home Task
 *
 * @version dated sept 18 2018
 * @autor Durasov Maxim
 */

/*
* Делать только одну задачу
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class Java1Lesson3 {
    public static void main(String[] args) throws FileNotFoundException {
        //task1guessNumber(); // Задача с отгадыванием чисел
        task2guessWord(); // Задача с отгадыванием слова
    }

    private static void task2guessWord() throws FileNotFoundException {
        /* Не самый удачный код. Начитываем файл в массив char. Массив превращаем в строку. Строку нарезаем на массив строк, по пробелу*/
        ArrayList wordsList = new ArrayList();
        String[] words = null;
        ;
        try (FileReader fwords = new FileReader("in.txt")) {
            char[] a = new char[2000];
            fwords.read(a);   // Чтение содержимого в массив
            StringBuilder builder = new StringBuilder();
            for (char s : a) {
                builder.append(s);
            }
            String arr = builder.toString();
            words = arr.split(" ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Если слова хотим из массива*/
        //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int random = rand.nextInt(words.length);
        String guessWord;
        String word = words[random];
        System.out.println("Загаданное слово - " + word);
        System.out.println("Попробуйте угадать загаданное слово )).");
        boolean gameOver = false;
        Scanner scan = new Scanner(in);
        while (gameOver == false) {
            guessWord = scan.nextLine();
            System.out.println("Вы ввели слово - " + guessWord);
            System.out.println("\n Найдено сопадений с загаданным словом: ");
            for (int a = 0; a < guessWord.length(); a++) {
                if (guessWord.charAt(a) == (words[random]).charAt(a))
                    System.out.print(guessWord.charAt(a));
                else System.out.print("#");
            }
            gameOver = comparisonWords(word, guessWord, gameOver);
            if (gameOver == false) {
                for (int a = word.length(); a < 15; a++) {
                    System.out.print("#");
                }
                System.out.println("\n Попробуйте еще раз\n");
            }
        }
    }

    private static boolean comparisonWords(String word, String guessWord, boolean gameOver) {
        if (word.equals(guessWord)) {
            System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!! СЛОВО УГАДАНО !!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        }
        return word.equals(guessWord);
    }

    private static void task1guessNumber() {
        Random rand = new Random();
        Scanner scan = new Scanner(in);
        int random = rand.nextInt(10);
        int bingo;
        for (int a = 0; a < 3; a++) {
            System.out.println("Попробуйте угадать загадонное число от 0 до 9");
            bingo = scan.nextInt();
            if (bingo == random) {
                System.out.println("   !!!BINGO!!!   Вы угадали.   Загадонное число - " + random);
                break;
            } else {
                if (bingo > random) {
                    System.out.println("Промах. Попробуйте число поменьше. Осталось попыток " + (2 - a) + "\n\n");
                    a = task1continue(a);
                } else {
                    System.out.println("Промах. Попробуйте число побольше. Осталось попыток " + (2 - a) + "\n\n");
                    a = task1continue(a);
                }
            }
        }
        System.out.println("Game over");
    }

    private static int task1continue(int a) {
        System.out.println("Нажмите: \n  1 - чтобы продолжть. \n  0 - чтобы прекратить. ");
        Scanner scan = new Scanner(in);
        int cont = scan.nextInt();
        switch (cont) {
            case 0:
                System.out.println("Вы выбрали ЗАКОНЧИТЬ");
                return a = 5;
            //  break;
            case 1:

                System.out.println("Вы выбрали ПРОДОЛЖИТЬ");
                return a;
            //break;
            default:
                System.out.println("Вы выбрали что-то иное \n");
                task1continue(a);
        }
        return a;
    }
}
