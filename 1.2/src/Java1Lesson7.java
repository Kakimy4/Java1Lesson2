import java.util.Random;

/**
 * Java Level 1. Lesson 7. Home Task
 *
 * @version dated sept 01 10 2018
 * @autor Durasov Maxim
 */

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая
    или длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/

public class Java1Lesson7 {
    public static void main(String[] args) {
        Cat cat = new Cat("cat", "Murzik");
        Dog dog = new Dog("dog", "Drujok");
        Dog dog2 = new Dog("dog", "Puschok");

        System.out.println(cat.toString()); // Print property of cat
        System.out.println(dog.toString()); // Print property of dog
        System.out.println(dog2.toString()); // Print property of dog

        dog2.run(100);
        cat.run(100);
        cat.run(100);
        cat.run(100);
        cat.run(100);
        cat.run(100);
        cat.run(100);
        cat.run(100);
        cat.swim(10);
        cat.jump(1);
    }
}

abstract class Animal {
    private String type;
    private String name;
    int totalRun;
    int totalSwim;
    int totalJump;

    public Animal(String type, String name, int totalRun, int totalSwim, int totalJump) {
        this.type = type;
        this.name = name;
        this.totalRun = totalRun;
        this.totalSwim = totalSwim;
        this.totalJump = totalJump;
    }

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    boolean run(int runDistance) {
        if (!checkDistance(runDistance)) {
            return false;
        }
        if (totalRun - runDistance >= 0) {
            totalRun = totalRun - runDistance;
            System.out.println("Animal " + type + " " + name + " is running " + runDistance + "m");
            return true;
        } else {
            System.out.println("Animal " + type + " " + name + " was tired and can't run");
            return false;
        }
    }

    boolean jump(int jumpDistance) {
        if (!checkDistance(jumpDistance)) {
            return false;
        }
        if (totalJump - jumpDistance >= 0) {
            totalJump = totalJump - jumpDistance;
            System.out.println("Animal " + type + " " + name + " is jumping " + jumpDistance + "m");
            return true;
        } else {
            System.out.println("Animal " + type + " " + name + " was tired and can't jump");
            return false;
        }
    }

    boolean swim(int swimDistance) {
        if (!checkDistance(swimDistance)) {
            return false;
        }
        if (totalSwim - swimDistance >= 0) {
            System.out.println("Animal " + type + " " + name + " is swiming " + swimDistance + "m");
            return true;
        } else {
            System.out.println("Animal " + type + " " + name + " was tired and can't swim");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Animal: " + "\t\tType " + type + "\t\tName - " + name + "\t\tLimit run - " + totalRun + "\t\tLimit swim - " + totalSwim + "\t\tLimit jump - " + totalJump;
    }

    private boolean checkDistance(int Distance) {
        if (Distance < 0) {
            System.out.println("Distance can't be < 0");
            return false;
        }
        return true;
    }
}

class Cat extends Animal {
    Random rand = new Random();

    public Cat(String cat, String name) {
        super(cat, name);
        totalRun = 200 + rand.nextInt(6) * 100;// Cat can jump from 200 to 700 meters
        totalSwim = 0;
        totalJump = 2 + rand.nextInt(4);        // Cat can jump from 2 to 5 meters
    }


    @Override
    boolean swim(int swimDistance) {
        if (swimDistance > 0) {
            System.out.println("Cats do not swim!");
            return false;
        }
        return true;
    }

}

class Dog extends Animal {
    Random rand = new Random();

    public Dog(String cat, String name) {
        super(cat, name);
        totalRun = 400 + rand.nextInt(10) * 100; // Dog can run from 400 to 1300 meters
        totalSwim = 10 + rand.nextInt(10) * 10; // Dog can swim from 10 to 100 meters
        totalJump = 5 + rand.nextInt(6);        // Dog can jump from 5 to 10 meters
    }
}