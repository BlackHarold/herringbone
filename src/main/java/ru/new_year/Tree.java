package ru.new_year;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tree {
    private static final int LENGTH = 25; // Длина дерева
    private String[] tab;

    public Tree() {
        tab = new String[LENGTH];
        tab[0] = "                        ";
        tab[1] = "                  |     ";
        tab[2] = "                 / \\";
        int spaceOutside = 16;
        int spaceInside = 3;
        for (int i = 0; i < 21; i += 3, spaceOutside -= 2, spaceInside += 4) {
            tab[i + 3] = " ".repeat(spaceOutside) + '/' + " ".repeat(spaceInside) + '\\';
            tab[i + 4] = " ".repeat(spaceOutside - 1) + '/' + " ".repeat(spaceInside + 2) + '\\';
            tab[i + 5] = " ".repeat(spaceOutside - 2) + "/_" + " ".repeat(spaceInside + 2) + "_\\";
        }
        tab[23] = "  /" + ":".repeat(31) + '\\';
        tab[24] = "               \\" + "_".repeat(6) + '/';
    }

    public void displayTree() {
        System.out.println();
        for (String line : tab) {
            System.out.printf("%10s%s%n", "", line);
        }
    }

    public String exportTree() {
        Scanner scanner = new Scanner(System.in, "Cp866");
        System.out.println("Экспорт в текстовый файл...");
        System.out.print("Название новогодней открытки: ");
        String card = scanner.nextLine() + ".txt";
        System.out.println("Помните о моноширинном шрифте когда будете отправлять открытку... [ВВОД]");
        scanner.nextLine(); // Ожидание ввода

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(card))) {
            for (String line : tab) {
                writer.write("          " + line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
        }

        return card;
    }

    public void addChains() {
        System.out.println("На какой высоте (1-7) вы хотите повесить гирлянды: ");
        Scanner scanner = new Scanner(System.in);
        int level;


        do {
            level = scanner.nextInt();
        } while (level < 1 || level > 7);

        switch (level) {
            case 1:
                tab[4] = replaceCharAt(tab[4], 20, '~');
                tab[5] = replaceCharAt(tab[5], 17, '~');
                tab[4] = replaceCharAt(tab[4], 19, '.');
                tab[5] = replaceCharAt(tab[5], 16, '.');
                tab[5] = replaceCharAt(tab[5], 18, '"');
                break;
            case 2:
                tab[7] = replaceCharAt(tab[7], 18, '~');
                tab[8] = replaceCharAt(tab[8], 21, '~');
                tab[6] = replaceCharAt(tab[6], 16, '.');
                tab[7] = replaceCharAt(tab[7], 19, '.');
                tab[8] = replaceCharAt(tab[8], 22, '.');
                tab[6] = replaceCharAt(tab[6], 15, '"');
                tab[7] = replaceCharAt(tab[7], 17, '"');
                tab[8] = replaceCharAt(tab[8], 20, '"');
                break;
            case 3:
                tab[10] = replaceCharAt(tab[10], 18, '"');
                tab[11] = replaceCharAt(tab[11], 21, '"');

                tab[9] = replaceCharAt(tab[9], 16, '.');
                tab[10] = replaceCharAt(tab[10], 19, '.');
                tab[11] = replaceCharAt(tab[11], 22, '.');

                tab[9] = replaceCharAt(tab[9], 15, '~');
                tab[10] = replaceCharAt(tab[10], 17, '~');
                tab[11] = replaceCharAt(tab[11], 20, '~');
                break;
            case 4:
                tab[11] = replaceCharAt(tab[11], 14, '~');
                tab[11] = replaceCharAt(tab[11], 15, '~');
                tab[10] = replaceCharAt(tab[10], 19, '~');
                tab[10] = replaceCharAt(tab[10], 20, '~');
                tab[9] = replaceCharAt(tab[9], 22, '~');
                tab[11] = replaceCharAt(tab[11], 12, '.');
                tab[11] = replaceCharAt(tab[11], 13, '.');
                tab[10] = replaceCharAt(tab[10], 18, '.');
                tab[11] = replaceCharAt(tab[11], 16, '"');
                tab[11] = replaceCharAt(tab[11], 17, '"');
                tab[10] = replaceCharAt(tab[10], 21, '"');
                tab[9] = replaceCharAt(tab[9], 23, '"');

                tab[13] = replaceCharAt(tab[13], 17, '~');
                tab[13] = replaceCharAt(tab[13], 18, '~');
                tab[14] = replaceCharAt(tab[14], 23, '~');
                tab[14] = replaceCharAt(tab[14], 24, '~');
                tab[12] = replaceCharAt(tab[12], 13, '.');
                tab[12] = replaceCharAt(tab[12], 14, '.');
                tab[13] = replaceCharAt(tab[13], 19, '.');
                tab[13] = replaceCharAt(tab[13], 20, '.');
                tab[14] = replaceCharAt(tab[14], 25, '.');
                tab[14] = replaceCharAt(tab[14], 26, '.');
                break;
            case 5:
                tab[17] = replaceCharAt(tab[17], 10, '~');
                tab[17] = replaceCharAt(tab[17], 11, '~');
                tab[16] = replaceCharAt(tab[16], 16, '~');
                tab[16] = replaceCharAt(tab[16], 17, '~');
                tab[16] = replaceCharAt(tab[16], 18, '~');
                tab[15] = replaceCharAt(tab[15], 24, '~');
                tab[15] = replaceCharAt(tab[15], 25, '~');

                tab[17] = replaceCharAt(tab[17], 8, '.');
                tab[17] = replaceCharAt(tab[17], 9, '.');
                tab[16] = replaceCharAt(tab[16], 14, '.');
                tab[16] = replaceCharAt(tab[16], 15, '.');
                tab[15] = replaceCharAt(tab[15], 22, '.');
                tab[15] = replaceCharAt(tab[15], 23, '.');

                tab[17] = replaceCharAt(tab[17], 12, '"');
                tab[17] = replaceCharAt(tab[17], 13, '"');
                tab[16] = replaceCharAt(tab[16], 19, '"');
                tab[16] = replaceCharAt(tab[16], 20, '"');
                tab[16] = replaceCharAt(tab[16], 21, '"');
                tab[15] = replaceCharAt(tab[15], 26, '"');
                tab[15] = replaceCharAt(tab[15], 27, '"');
                break;
            case 6:
                tab[18] = replaceCharAt(tab[18], 10, '~');
                tab[18] = replaceCharAt(tab[18], 11, '~');
                tab[18] = replaceCharAt(tab[18], 12, '~');
                tab[19] = replaceCharAt(tab[19], 18, '~');
                tab[19] = replaceCharAt(tab[19], 19, '~');
                tab[20] = replaceCharAt(tab[20], 26, '~');
                tab[20] = replaceCharAt(tab[20], 27, '~');

                tab[18] = replaceCharAt(tab[18], 13, '.');
                tab[18] = replaceCharAt(tab[18], 14, '.');
                tab[19] = replaceCharAt(tab[19], 20, '.');
                tab[19] = replaceCharAt(tab[19], 21, '.');
                tab[19] = replaceCharAt(tab[19], 22, '.');
                tab[20] = replaceCharAt(tab[20], 28, '.');
                tab[20] = replaceCharAt(tab[20], 29, '.');
                tab[20] = replaceCharAt(tab[20], 30, '.');

                tab[18] = replaceCharAt(tab[18], 8, '"');
                tab[18] = replaceCharAt(tab[18], 9, '"');
                tab[19] = replaceCharAt(tab[19], 15, '"');
                tab[19] = replaceCharAt(tab[19], 16, '"');
                tab[19] = replaceCharAt(tab[19], 17, '"');
                tab[20] = replaceCharAt(tab[20], 23, '"');
                tab[20] = replaceCharAt(tab[20], 24, '"');
                tab[20] = replaceCharAt(tab[20], 25, '"');
                break;
            case 7:
                tab[23] = replaceCharAt(tab[23], 7, '~');
                tab[23] = replaceCharAt(tab[23], 8, '~');
                tab[23] = replaceCharAt(tab[23], 9, '~');
                tab[22] = replaceCharAt(tab[22], 16, '~');
                tab[22] = replaceCharAt(tab[22], 17, '~');
                tab[22] = replaceCharAt(tab[22], 18, '~');
                tab[21] = replaceCharAt(tab[21], 25, '~');
                tab[21] = replaceCharAt(tab[21], 26, '~');
                tab[21] = replaceCharAt(tab[21], 27, '~');

                tab[23] = replaceCharAt(tab[23], 4, '.');
                tab[23] = replaceCharAt(tab[23], 5, '.');
                tab[23] = replaceCharAt(tab[23], 6, '.');
                tab[22] = replaceCharAt(tab[22], 13, '.');
                tab[22] = replaceCharAt(tab[22], 14, '.');
                tab[22] = replaceCharAt(tab[22], 15, '.');
                tab[21] = replaceCharAt(tab[21], 22, '.');
                tab[21] = replaceCharAt(tab[21], 23, '.');
                tab[21] = replaceCharAt(tab[21], 24, '.');

                tab[23] = replaceCharAt(tab[23], 10, '"');
                tab[23] = replaceCharAt(tab[23], 11, '"');
                tab[23] = replaceCharAt(tab[23], 12, '"');
                tab[22] = replaceCharAt(tab[22], 19, '"');
                tab[22] = replaceCharAt(tab[22], 20, '"');
                tab[22] = replaceCharAt(tab[22], 21, '"');
                tab[21] = replaceCharAt(tab[21], 28, '"');
                tab[21] = replaceCharAt(tab[21], 29, '"');
                tab[21] = replaceCharAt(tab[21], 30, '"');
        }
    }

    public void addStar() {
        tab[0] = replaceStringAt(tab[0], 16, "_.|._");
        tab[1] = replaceStringAt(tab[1], 16, " '|' ");
    }

    public void addGlassBalls() {
        tab[21] = replaceCharAt(tab[21], 11, 'o');
        tab[15] = replaceCharAt(tab[15], 11, 'o');
        tab[9] = replaceCharAt(tab[9], 16, 'o');
        tab[4] = replaceCharAt(tab[4], 18, 'o');
        tab[20] = replaceCharAt(tab[20], 18, 'o');
        tab[6] = replaceCharAt(tab[6], 21, 'o');
        tab[11] = replaceCharAt(tab[11], 23, 'o');
        tab[19] = replaceCharAt(tab[19], 27, 'o');
    }

    public void addSweets() {
        tab[22] = replaceCharAt(tab[22], 7, 'J');
        tab[19] = replaceCharAt(tab[19], 9, 'J');
        tab[10] = replaceCharAt(tab[10], 14, 'J');
        tab[7] = replaceCharAt(tab[7], 15, 'J');
        tab[12] = replaceCharAt(tab[12], 22, 'J');
        tab[14] = replaceCharAt(tab[14], 16, 'J');
        tab[17] = replaceCharAt(tab[17], 23, 'J');
        tab[22] = replaceCharAt(tab[22], 28, 'J');
    }

    public void addLamps() {
        tab[5] = replaceCharAt(tab[5], 14, '!');
        tab[8] = replaceCharAt(tab[8], 12, '!');
        tab[11] = replaceCharAt(tab[11], 10, '!');
        tab[14] = replaceCharAt(tab[14], 8, '!');
        tab[17] = replaceCharAt(tab[17], 6, '!');
        tab[20] = replaceCharAt(tab[20], 4, '!');

        tab[5] = replaceCharAt(tab[5], 22, '!');
        tab[8] = replaceCharAt(tab[8], 24, '!');
        tab[11] = replaceCharAt(tab[11], 26, '!');
        tab[14] = replaceCharAt(tab[14], 28, '!');
        tab[17] = replaceCharAt(tab[17], 30, '!');
        tab[20] = replaceCharAt(tab[20], 32, '!');
    }

    public void displayMenu() {
        System.out.println("\n\n[1] -> Украсить елку звездой");
        System.out.println("[2] -> Украсить елку гирляндами");
        System.out.println("[3] -> Положить подарок с любовью под елку");
        System.out.println("[4] -> Развесить шары");
        System.out.println("[5] -> Развесить сладости");
        System.out.println("[6] -> Зажечь свечи");
        System.out.println("[9] -> Экспорт в файл");
        System.out.println("[0] -> Выход");
        System.out.print("Выбор: ");
    }

    public void clearScreen() {
        System.out.flush();
    }

    private String replaceCharAt(String str, int index, char replacement) {
        return str.substring(0, index) + replacement + str.substring(index + 1);
    }

    private String replaceStringAt(String str, int index, String replacement) {
        if (index < 0 || index + replacement.length() > str.length()) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return str.substring(0, index) + replacement + str.substring(index + replacement.length());
    }
}
