package task;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task.methods.ActionExecutor;
import task.methods.impl.*;

import static java.lang.System.exit;

public class Main {
    static TaskList taskList = TaskList.getInstance();
    public static int nextIndexTask = 1;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static List<String> ACTION_WITH_REQUIRED_ARG = List.of("add", "toggle", "delete", "edit", "search");

    public static void main(String[] args) {
        logger.info("Simple log statement");
        ActionExecutor executor = new ActionExecutor();
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
                    executor.setNewAction(new AddAction(), taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("print"):
                    executor.setNewAction(new PrintAction(), taskList, input);
                    executor.runTask();
                    break;
                case ("toggle"):
                    executor.setNewAction(new ToggleAction(), taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("quit"):
                    exit(0);
                case ("delete"):
                    executor.setNewAction(new DeleteAction(), taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("edit"):
                    executor.setNewAction(new EditAction(), taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("search"):
                    executor.setNewAction(new SearchAction(), taskList, arrString[1]);
                    executor.runTask();
                    break;
                default:
                    System.out.println("Введенная команда не поддерживается\n");
            }
        }
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
