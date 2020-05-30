package ru.geekbrains.lesson6;

public abstract class Animal { // Абстракрый класс, так как нам не надо создавать объекты Animal, это только шаблон
    // Видимость в пределах пакета и у наследников и обязательная к инициализации
    protected final String name;
    protected final int runningLimit;
    protected final int swimLimit;
    protected final double jumpLimit;

    // Создадим единственный конструктор, который обязывает при его вызове задать лимиты для действий
    Animal(String name, int runningLimit, int swimLimit, double jumpLimit) {
        this.name = name;
        this.runningLimit = runningLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    // Опишем общую логику для всех дочерних классов
    void run (int distance) {
        System.out.println(this.name + " run: "+ (distance < this.runningLimit));
    }

    void jump (int distance) {
        System.out.println(this.name + " jump: "+ (distance < this.jumpLimit));
    }

    void swim(int distance) {
        System.out.println(this.name + " swim: "+ (distance < this.swimLimit));
    }
}
