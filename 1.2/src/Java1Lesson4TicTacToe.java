/**
 * Java Level 1. Lesson 4. Java1Lesson4TicTacToe
 *
 * @version dated sept 24 09 2018
 * @autor Durasov Maxim
 */

import java.util.Random;
import java.util.Scanner;

public class Java1Lesson4TicTacToe {
    final int SIZE = 4;
    final char DOT_X = 'X';
    final char DOT_O = 'O';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new Java1Lesson4TicTacToe().game();
    }

    void game() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWinShort(DOT_X)) {
                System.out.println("\nYOU WON \n");
                printMap();
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW ... ");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinShort(DOT_O)) {
                System.out.println("\nPC WON\n");
                printMap();
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW ... ");
                break;
            }
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X & Y (1.." + SIZE + ")");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y) || isCellFree(x, y));
        map[x][y] = DOT_X;
    }

    private boolean isCellFree(int x, int y) {
        if (map[x][y] != DOT_EMPTY) ;
        {
            System.out.println("This cell is use. Enter other cell.\n");
            return false;
        }
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;
    }

    boolean checkWinShort(char dot) {
        // check horizont
        int dl = 0, dr = 0, hor = 0, vert = 0;
        for (int a = 0; a < SIZE; a++) {
            for (int b = 0; b < SIZE; b++) {
                if (map[b][b] == dot && a == b) dl++;             // Проверка основной диагонали
                if (map[b][SIZE - b - 1] == dot && a == b) dr++;  // Проверка обратной диагонали
                if (map[a][b] == dot) hor++;                      // Проверка горизонталей
                if (map[b][a] == dot) vert++;                     // Проверка вертикалей
                if (SIZE > 3) if (dl >= SIZE - 1 || dr >= SIZE - 1 || hor >= SIZE - 1 || vert >= SIZE - 1) return true;
                if (SIZE == 3) if (dl == SIZE || dr == SIZE || hor == SIZE || vert == SIZE) return true;
            }
            hor = vert = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) ;
                return false;
            }
        }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            System.out.println("Check other cell from valid range");
            return false;
        }
        return true;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}