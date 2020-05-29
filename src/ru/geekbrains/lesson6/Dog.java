package ru.geekbrains.lesson6;

public class Dog extends Animal {

    Dog (String name) { // Так как у супер-класса есть поле final, то его необходимо инициализировать
        super(name, 500, 10, 0.5);    // Вызовим конструктор Animal
    }

    // Создадим еще один конструктор с возможность задать лимит бега
    Dog (String name, int runningLimit) {
        super(name, runningLimit, 0, 2);
    }

    @Override
    void run (int distance) {
        if (distance > this.runningLimit) {
            System.out.println(this.name + " run false");
        }
        else {
            System.out.println(this.name + " run true");
        }

    }

    @Override
    void swim(int distance) {
        if (distance > this.swimLimit) {
            // Обращаюсь к наследованному полю текущего класса, теперь это и его поле то же
            System.out.println(this.name + " swim false");
        } else {
            System.out.println(this.name + " swim true");
        }

    }

    @Override
    void jump (int distance) {
        if (distance > this.jumpLimit) {
            // Обращаюсь к наследованному полю текущего класса, теперь это и его поле то же
            System.out.println(this.name + " jump false");
        } else {
            System.out.println(this.name + " jump true");
        }
    }

}
