package ru.geekbrains.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false; // При создании кошки, она голодная

    public boolean getSatiety () {
        return this.satiety;
    }

    public int getAppetite () {
        return this.appetite;
    }

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= this.appetite) { // Если еды в миске больше чем аппетит, то будем кушать
            plate.decreaseFood(this.appetite);
            this.satiety = true; // Сделем кота сытым
            System.out.println(this.name + " скушал " + this.appetite);

        } else {
            this.satiety = false; // Оставим кота голодным
            System.out.println(this.name + " хотел скушать " + this.appetite + ", но в тарелке осталось " + plate.getFood());
        }
    }

    public void printSatiety() {  // Печать сытости котика
        System.out.println( (this.satiety) ? this.name + " сытый": this.name + " остался голодный :(");
    }

}
