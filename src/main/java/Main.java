import ru.new_year.Floor;
import ru.new_year.Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose = 0;
        Tree tree = new Tree();
        Floor floor = new Floor();
        Scanner scanner = new Scanner(System.in);

        while (choose < 10) {
            tree.clearScreen();
            tree.displayTree();
            floor.displayFloor();
            tree.displayMenu();

            // Проверка ввода
            while (!scanner.hasNextInt()) {
                scanner.next(); // Игнорируем некорректный ввод
            }
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    tree.addStar();
                    break;
                case 2:
                    tree.addChains();
                    break;
                case 3:
                    floor.addGift();
                    break;
                case 4:
                    tree.addGlassBalls();
                    break;
                case 5:
                    tree.addSweets();
                    break;
                case 6:
                    tree.addLamps();
                    break;
                case 9:
                    floor.exportFloor(tree.exportTree());
                    break;
                case 0:// Завершение программы
                    return;
                default:
                    break;
            }
        }

        scanner.close(); // Закрываем сканер
    }
}