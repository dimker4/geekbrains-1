package ru.geekbrains.lesson6;

public class Lesson6 {
    public static void main(String[] args) {

        Cat cat = new Cat("Barsik");
        // Создадим объект с новым конструктором и зададим лимит бега
        Cat cat1 = new Cat("Murka", 50);

        Dog dog = new Dog("Bobik");
        Dog dog1 = new Dog("Sharik", 500);

        cat.jump(200);
        cat.swim(100);
        cat.run(200);

        dog.jump(200);
        dog.swim(100);
        dog.run(200);

        cat1.run(20);
        dog1.run(600);

    }
}
