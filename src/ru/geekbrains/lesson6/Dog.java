package ru.geekbrains.lesson6;

public class Dog extends Animal {

    Dog (String name) { // Так как у супер-класса есть поле final, то его необходимо инициализировать
        super(name, 500, 10, 0.5);    // Вызовим конструктор Animal
    }

    // Создадим еще один конструктор с возможность задать лимит бега
    Dog (String name, int runningLimit) {
        super(name, runningLimit, 0, 2);
    }
}
