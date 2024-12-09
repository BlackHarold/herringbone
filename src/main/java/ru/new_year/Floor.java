package ru.new_year;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Floor {
    private static final int LENGTH = 6; // Замените на нужное значение
    private String[] tab; // Массив строк для представления пола
    private int gifts; // Количество подарков

    public Floor() {
        tab = new String[LENGTH];
        Arrays.fill(tab, " "); // Заполнение пробелами
        gifts = 0; // Инициализация количества подарков
    }

    // Метод для размещения подарков под елку
    public void displayFloor() {
        for (String line : tab) {
            System.out.println(line); // Вывод каждой строки
        }
    }

    // Метод для добавления подарка
    public void addGift() {
        if (gifts == 3) {
            System.out.println("Вы можете разместить не более трех подарков под этой елочкой... [ВВОД]");
            new Scanner(System.in, "Cp866").nextLine(); // Ожидание ввода
        } else {
            tab[0] += "                  "; // Добавление подарка в строку
            tab[1] += "      ((\\o/))     ";
            tab[2] += ".------//^\\-----. ";
            tab[3] += "|Для: / | | \\   | ";
            tab[4] += "|       | |     | ";
            tab[5] += "'-----=---------' ";

            Scanner scanner = new Scanner(System.in, "Cp866");
            System.out.print("Этот подарочек будет для: ");
            String name = scanner.nextLine();

            while (name.length() > 6) {
                System.out.print("Сократите имя до 6 символов и попробуйте снова: ");
                name = scanner.nextLine();
            }
            while (name.length() < 6) {
                name += ' ';
            }

            tab[4] = replaceStringAt(tab[4], 2 + gifts * 20, name); // Замена имени на нужной позиции
            gifts++; // Увеличение количества подарков
        }
    }

    // Метод для экспорта рисунка в файл
    public void exportFloor(String card) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(card, true))) {
            for (String line : tab) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи строк в файл: " + e.getMessage());
        }
    }

    // Вспомогательный метод для замены подстроки в строке
    private String replaceStringAt(String str, int index, String replacement) {
        return str.substring(0, index) + replacement + str.substring(index + replacement.length());
    }
}