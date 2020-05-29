package ru.geekbrains.lesson6;

public abstract class Animal { // Абстракрый класс, так как есть абрстрактные методы
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

    // Абстракный метод, так как его необходимо обязательно переопредилть
    abstract void run(int distance);
    abstract void swim(int distance);
    abstract void jump(int distance);
}
