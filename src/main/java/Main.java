import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static ArrayList<Task> listTask = new ArrayList<Task>();
    static int nextIndexTask = 1;

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String action = in.next();
            switch (action) {
                case ("add"):
                    addTask(in);
                    break;
                case ("print"):
                    printTask(in);
                    break;
                case ("toggle"):
                    toggleTask(in);
                    break;
                case ("quit"):
                    quitTask(in);
                    break;
                case ("delete"):
                    deleteTask(in);
                    break;
                case ("edit"):
                    editTask(in);
                    break;
                case ("search"):
                    searchTask(in);
                    break;
                default:
                    System.out.println("Введенная команда не поддерживается\n");
            }
        }
    }

    public static void addTask(Scanner in) {
        String description = in.nextLine().trim();
        if (description.length() == 0) {
            System.out.println("Необходимо ввести описание задачи");
            return;
        }
        listTask.add(new Task(description, nextIndexTask));
        nextIndexTask++;
    }

    public static void printTask(Scanner in) {
        String signAll = in.nextLine().trim();
        if (signAll.equals("all")) {
            for (Task task : listTask) {
                task.print();
            }
        } else
            for (Task task : listTask) {
                if (!task.getState()) task.print();
            }
    }

    public static void searchTask(Scanner in) {
        String substring = in.nextLine().trim();
        for (Task task : listTask) {
            if (task.getDescription().contains(substring))
                task.print();
        }
    }

    public static void deleteTask(Scanner in) {
        try {
            int deleteIndex = Integer.parseInt(in.nextLine().trim());
            Task taskForDelete = listTask.stream()
                    .filter(el -> el.getId() == deleteIndex)
                    .findAny()
                    .orElse(null);
            listTask.remove(taskForDelete);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Некоректный аргумент");
        }
    }

    public static void toggleTask(Scanner in) {
        try {
            int statusСhange = Integer.parseInt(in.nextLine().trim());
            for (Task task : listTask) {
                if (task.getId() == statusСhange) {
                    task.setState(!task.getState());
                    return;
                }
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Некоректный аргумент");
        }
    }

    public static void editTask(Scanner in) {
        try {
            int idTask = Integer.parseInt(in.next().trim());
            String descriptionTask = in.nextLine().trim();
            for (Task task : listTask) {
                if (task.getId() == idTask) {
                    task.setDescription(descriptionTask);
                    return;
                }
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Некоректный аргумент");
        }
    }

    public static void quitTask(Scanner in) {
        exit(0);
    }
}
