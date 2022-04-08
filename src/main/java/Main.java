import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите команду\n" +
                    "add - добавление задачи\n" +
                    "print - печать списка задач\n" +
                    "toggle - изменение статуса задачи\n" +
                    "quit - завершение работы");
            String action = in.nextLine();
                switch (action) {
                    case ("add"):
                        task.add();
                        break;
                    case ("print"):
                        task.print();
                        break;
                    case ("toggle"):
                        task.toggle();
                        break;
                    case ("quit"):
                        task.quit();
                        break;
                    default:
                        System.out.println("Введенная команда не поддерживается\n");
                }
            }
        }
    }
