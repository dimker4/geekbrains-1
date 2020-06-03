package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 25);
        Cat cat1 = new Cat("Murka", 15);
        Cat cat2 = new Cat("Tima", 10);
        Cat cat3 = new Cat("Fidel", 5);
        Cat cat4 = new Cat("Kolya", 50);

        Plate plate = new Plate(100);
        plate.info();

        Cat[] cats = {cat, cat1, cat2, cat3, cat4};

        for (Cat c: cats) {
            c.eat(plate); // Котик пробует кушать
            c.printSatiety(); // Выведем в консоль инфу про сытость котика
            if (!c.getSatiety()) { // Нельзя оставлять котика голодным
                plate.addFood(c.getAppetite() - plate.getFood()); // Доложим столько еды, сколько не хватает для опусташения тарелки
                c.eat(plate); // Еще раз пробуем покормить голодного котика
            }
            plate.info();
        }
    }
}
