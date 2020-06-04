package ru.geekbrains.lesson7;

public class Plate {
    private int food;

    public int getFood() // Добавим геттер для обращения к приватному полю
    {
        return food;
    }

    public Plate (int food) {
        this.food = food;
    }

    public void info () {
        System.out.println("В тарелке осталось " + this.food);
    }

    public void decreaseFood (int animalAppetite) {
        if (this.food >= animalAppetite && animalAppetite > 0) { // Запретим отрицательное количество еды в миске
            this.food -= animalAppetite;
        } else {
            System.out.println("Покушать не получилось");
        }
    }

    public void addFood (int food) {
        if (food > 0) {
            this.food += food;
            System.out.println("В тарелку добавили " + food + " еды");
        } else {
            System.out.println("Нельзя положить в тарелку значение меньше 1");
        }
    }
}
