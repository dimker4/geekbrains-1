package ru.geekbrains.lesson6;

public abstract class Animal { // Абстракрый класс, так как нам не надо создавать объекты Animal, это только шаблон
    // Видимость в пределах пакета и у наследников и обязательная к инициализации
    protected final String name;
    protected int runningLimit;
    protected int swimLimit;
    protected double jumpLimit;

    // Создадим единственный конструктор, который обязывает при его вызове задать лимиты для действий
    Animal(String name, int runningLimit, int swimLimit, double jumpLimit) {
        this.name = name;
        this.runningLimit = runningLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    // Опишем общую логику для всех дочерних классов
    void run (int distance) {
        if (distance > this.runningLimit) {
            System.out.println(this.name + " run false");
        } else {
            System.out.println(this.name + " run true");
        }
    }

    void jump (int distance) {
        if (distance > this.jumpLimit) {
            System.out.println(this.name + " jump false");
        } else {
            System.out.println(this.name + " jump true");
        }
    }

    void swim(int distance) {
        if (distance > this.swimLimit) {
            System.out.println(this.name + " swim false");
        } else {
            System.out.println(this.name + " swim true");
        }
    }
}
