package ru.geekbrains.lesson4;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    // Создаю геттер для обращения к приватному полю
    public int getAge()
    {
        return age;
    }

    // Создаю новый конструктор
    Employee(String fio, String position, String email, String phoneNumber, double salary, int age) {
        // Указываю this, что бы обозначить, что значения присваиваем полям класса
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.print(this.fio + " " + this.position + " " + email + " " + phoneNumber + " " + salary + " " + age + "\n");
    }
}
