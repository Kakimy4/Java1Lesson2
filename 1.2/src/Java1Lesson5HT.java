
/**
 * Java Level 1. Lesson 5. Home Task
 *
 * @version dated sept 26 09 2018
 * @autor Durasov Maxim
 */

/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* */
public class Java1Lesson5HT {
    static final int AGE = 40;

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Max", "driver", "driver@gmail.com", "01", 50, 39);
        persArray[1] = new Person("Andy", "headmaster", "driver@gmail.com", "02", 70, 33);
        persArray[2] = new Person("Boris", "security", "Boris@gmail.com", "03", 44, 73);
        persArray[3] = new Person("Ilya", "accountant", "Ilya@gmail.com", "04", 60, 42);
        persArray[4] = new Person("Yana", "beauty", "Yana@gmail.com", "05", 32, 25);

        printOldestPerson(persArray);
    }

    private static void printOldestPerson(Person[] persArray) {
        //System.out.println(persArray.toString());

        System.out.println("These people older then usually people");
        for (int i = 0; i < persArray.length; i++) {

            if (persArray[i].age >= AGE) {
                System.out.println("Name - " + persArray[i].name + "\nPosition - " + persArray[i].position + "\nemail - " +
                        persArray[i].email + "\nphone - " + persArray[i].phone + "\nSalary - " +
                        persArray[i].salary + "\nAge - " + persArray[i].age + "\n");
            }
        }
    }

    static class Person {
        /*Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;*/
        String name = "Vasya";
        String position = "watchman";
        String email = "anonym@gmail.com";
        String phone = "00";
        int salary = 99;
        int age = 18;

        Person(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }
/*
        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }*/
    }
}
