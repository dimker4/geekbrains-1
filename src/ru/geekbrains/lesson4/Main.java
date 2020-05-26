package ru.geekbrains.lesson4;

public class Main {
    public static void main(String[] args) {
        String fio = "Кирк Хэмметт";
        String position = "Гитарист";
        String email = "kirk@gmail.com";
        String phoneNumber = "+70000000000";
        double salary = 10;
        int age = 58;

        // Создаю новый экземпляр класса
//        Employee emp1 = new Employee(fio, position, email, phoneNumber, salary, age);
//        emp1.getInfo();

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Джеймс Хетлфилд", "Вокалист", "jam@gmail.com", "+70000000001", 10, 56);
        empArray[1] = new Employee("Кирк Хэмметт", "Гитарист", "kirk@gmail.com", "+70000000002", 10, 57);
        empArray[2] = new Employee("Клифф Бёртон", "Басс-гитарист", "kliff@gmail.com", "+70000000003", 10, 24);
        empArray[3] = new Employee("Ларс Ульрих", "Ударник", "lars@gmail.com", "+70000000004", 10, 56);
        empArray[4] = new Employee("Роберт Трухильо", "Бэк вокалист", "robert@gmail.com", "+70000000001", 10, 55);

        for (int i = 0; i < empArray.length; i ++) {
            if (empArray[i].getAge() > 40) {
                empArray[i].getInfo();
            }
        }

    }
}
