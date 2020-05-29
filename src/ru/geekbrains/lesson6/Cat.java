package ru.geekbrains.lesson6;

public class Cat extends Animal {

    Cat (String name) { // Так как у супер-класса есть поле final, то его необходимо инициализировать
        super(name, 200, 0, 2);    // Вызовим конструктор Animal
    }

    // Создадим еще один конструктор с возможность задать лимит бега
    Cat (String name, int runningLimit) {
        super(name, runningLimit, 0, 2);
    }

    // Так как кот не умеет плавать, переопределим ему метод
    @Override
    void swim(int distance) {
        System.out.println(this.name + " swim false");
    }


}
