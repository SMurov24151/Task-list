import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;

public class Main {
    static ArrayList<Task> listTask = new ArrayList<Task>();
    static int nextIndexTask = 1;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Simple log statement");
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            logger.debug(input);
            String[] arrString = input.split(" ", 2);
            String action = arrString[0];
            switch (action) {
                case ("add"):
                    addTask(arrString[1]);
                    break;
                case ("print"):
                    printTask(arrString[1]);
                    break;
                case ("toggle"):
                    toggleTask(arrString[1]);
                    break;
                case ("quit"):
                    exit(0);
                case ("delete"):
                    deleteTask(arrString[1]);
                    break;
                case ("edit"):
                    editTask(arrString[1]);
                    break;
                case ("search"):
                    searchTask(arrString[1]);
                    break;
                default:
                    System.out.println("Введенная команда не поддерживается\n");
            }
        }
    }

    public static void addTask(String description) {
        if (description.length() == 0) {
            System.out.println("Необходимо ввести описание задачи");
            return;
        }
        listTask.add(new Task(description, nextIndexTask));
        nextIndexTask++;
    }

    public static void printTask(String signAll) {
        if (signAll.equals("all")) {
            for (Task task : listTask) {
                task.print();
            }
        } else
            for (Task task : listTask) {
                if (!task.getState()) task.print();
            }
    }

    public static void searchTask(String in) {
        String substring = in;
        if (substring.length() == 0) {
            System.out.println("Введите слово");
            return;
        }
        for (Task task : listTask) {
            if (task.getDescription().contains(substring))
                task.print();
        }
    }

    public static void deleteTask(String in) {
        int id = findElement(in);
        if (id >= 0) listTask.remove(id);
    }

    public static void toggleTask(String in) {
        int id = findElement(in);
        if (id >= 0) listTask.get(id).setState(!listTask.get(id).getState());
    }

    public static void editTask(String in) {
        String[] arrString = in.split(" ", 2);
        int id = findElement(arrString[0]);
        String descriptionTask = arrString[1];
        if (id >= 0) listTask.get(id).setDescription(descriptionTask);
    }

    public static int findElement(String in) {
        try {
            int idTask = Integer.parseInt(in);
            for (int i = 0; i < listTask.size(); i++) {
                if (listTask.get(i).getId() == idTask) {
                    return i;
                }
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Некоректный аргумент");
            logger.error("Error parse input index {}", numberFormatException.getMessage());
        }
        return -1;
    }
}
