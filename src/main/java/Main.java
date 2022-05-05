import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;

public class Main {
    static TaskList taskList = TaskList.getInstance();
    static int nextIndexTask = 1;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static List<String> ACTION_WITH_REQUIRED_ARG = List.of("add", "toggle", "delete", "edit", "search");

    public static void main(String[] args) {
        logger.info("Simple log statement");
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            logger.debug(input);
            String[] arrString = input.split(" ", 2);
            String action = arrString[0];
            if (ACTION_WITH_REQUIRED_ARG.contains(action) && arrString.length<2) {
                System.out.println("Недостаточно аргументов");
                logger.error("Undefined args");
                continue;
            }
            switch (action) {
                case ("add"):
                    addTask(arrString[1]);
                    break;
                case ("print"):
                    printTask(arrString);
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
        taskList.getTasks().add(new Task(description, nextIndexTask));
        nextIndexTask++;
    }

    public static void printTask(String[] in) {
        if (in.length<2){
            for (Task task : taskList.getTasks()) {
                if (!task.getState()) task.print();
            }
        } else if (in[1].equals("all")) {
            for (Task task : taskList.getTasks()) {
                task.print();
            }
        } else {
            logger.error("Error in input for action print");
            System.out.println("Некорректный ввод");
        }

    }

    public static void searchTask(String in) {
        String substring = in;
        if (substring.length() == 0) {
            System.out.println("Введите слово");
            return;
        }
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().contains(substring))
                task.print();
        }
    }

    public static void deleteTask(String in) {
        int id = findElement(in);
        if (id >= 0) taskList.getTasks().remove(id);
    }

    public static void toggleTask(String in) {
        int id = findElement(in);
        if (id >= 0) taskList.getTasks().get(id).setState(!taskList.getTasks().get(id).getState());
    }

    public static void editTask(String in) {
        String[] arrString = in.split(" ", 2);
        int id = findElement(arrString[0]);
        String descriptionTask = arrString[1];
        if (id >= 0) taskList.getTasks().get(id).setDescription(descriptionTask);
    }

    public static int findElement(String in) {
        try {
            int idTask = Integer.parseInt(in);
            for (int i = 0; i < taskList.getTasks().size(); i++) {
                if (taskList.getTasks().get(i).getId() == idTask) {
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
