package ru.geekbrains.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame { // Наследуем от JFrame

    public MyWindow() {
        setSize(170, 270);
        setLocation(900, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); // Запретим менять размер окна

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnAsterisk = new JButton("*");
        JButton btn0 = new JButton("0");
        JButton btnHash = new JButton("#");
        JButton btnCall = new JButton("Call"); // Имитируем вызов
        JButton btnCancel = new JButton("Cancel"); // Очистит поле ввода
        JButton[] btnArray = new JButton[] {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAsterisk, btnHash};

        JTextArea text = new JTextArea("", 3, 14);

        for (JButton b: btnArray) { // Пробегусь по массиву кнопок для указания события
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    text.append(b.getText());
                }
            });
        }

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                text.setText(null);
            }
        });

        btnCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                text.setText((text.getText() == null) ? "Enter phone number " : "Calling " + text.getText() + " ...");
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout());
        JPanel callPanel = new JPanel(new GridLayout(1, 2));
        JPanel textPanel = new JPanel(new GridLayout(1, 1));

        textPanel.add(text);
        callPanel.add(btnCall);
        callPanel.add(btnCancel);

        btnPanel.add(textPanel);
        btnPanel.add(callPanel);
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.add(btn4);
        btnPanel.add(btn5);
        btnPanel.add(btn6);
        btnPanel.add(btn7);
        btnPanel.add(btn8);
        btnPanel.add(btn9);
        btnPanel.add(btnAsterisk);
        btnPanel.add(btn0);
        btnPanel.add(btnHash);
        add(btnPanel);

        setVisible(true);
    }
}
