import javax.swing.*;
import java.util.Random;

/**
 * Java Level 1. Lesson 7. Home Task
 *
 * @version dated 04 10 2018
 * @autor Durasov Maxim
 */

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
7. ***** Решить задачу с котами в Swing, самостоятельно изучив методичку №8
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

class Java1Lesson7CatAndPlate {
    public static void main(String[] args) {
        CatNew[] cats = {new CatNew("Barsik", 1), new CatNew("Murzik", 6), new CatNew("Sherhan", 3)};
        Plate plate = new Plate(1);
        plate.addFood(9);
        System.out.println("\nТаблица сыточти котов");
        for (int a = 0; a < cats.length; a++) {
            cats[a].eat(plate);
        }
        System.out.println("\nТаблица сытости котов");
        for (int a = 0; a < cats.length; a++) {
            System.out.println(cats[a].getName() + " голоден? - " + cats[a].getHunger());
        }
    }
}

class CatNew {
    private String name;
    private boolean hunger;
    private int appetite;

    public boolean getHunger() {
        return hunger;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    CatNew(String name, int appetite, boolean hunger) {
        this.name = name;
        this.appetite = appetite;
        this.hunger = hunger;
    }

    CatNew(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hunger = true;
    }

    void eat(Plate plate) {
        hunger = plate.dicreaseFood(CatNew.this);
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public boolean dicreaseFood(CatNew catNew) {
        boolean hunger = catNew.getHunger();
        String name = catNew.getName();
        int appetite = catNew.getAppetite();

        if (hunger) {
            //System.out.println("Кот " + name + " голоден");
            if (appetite > food) {
                //System.out.println("В тарелке еды меньше, чем хочет кот " + name);
            } else {
                //System.out.println("Кот ест " + name + " " + appetite + " еды");
                this.food -= appetite;
                //System.out.println("Остаток в тарелке после еды - " + food);
                hunger = false;
                return hunger;
            }
        }
        //System.out.println(name + " уже сыт");
        return hunger;
    }

    public void addFood(int i) {
        this.food += i;
        System.out.println("В тарелеке " + food + " еды");
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}