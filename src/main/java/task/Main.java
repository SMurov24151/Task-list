package task;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import task.methods.ActionExecutor;
import task.methods.impl.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {
    static TaskList taskList = TaskList.getInstance();
    public static int nextIndexTask = 1;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static List<String> ACTION_WITH_REQUIRED_ARG = List.of("add", "toggle", "delete", "edit", "search");


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    private final AddAction addAction;
    private final DeleteAction deleteAction;
    private final EditAction editAction;
    private final PrintAction printAction;
    private final SearchAction searchAction;
    private final ToggleAction toggleAction;

    @Override
    public void run(String... args) {
        new BufferedReader(new InputStreamReader(System.in));
        logger.info("Simple log statement");
        ActionExecutor executor = new ActionExecutor();
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            logger.debug(input);
            String[] arrString = input.split(" ", 2);
            String action = arrString[0];
            if (ACTION_WITH_REQUIRED_ARG.contains(action) && arrString.length < 2) {
                System.out.println("Недостаточно аргументов");
                logger.error("Undefined args");
                continue;
            }
            switch (action) {
                case ("add"):
                    executor.setNewAction(addAction, taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("print"):
                    executor.setNewAction(printAction, taskList, input);
                    executor.runTask();
                    break;
                case ("toggle"):
                    executor.setNewAction(toggleAction, taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("quit"):
                    exit(0);
                case ("delete"):
                    executor.setNewAction(deleteAction, taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("edit"):
                    executor.setNewAction(editAction, taskList, arrString[1]);
                    executor.runTask();
                    break;
                case ("search"):
                    executor.setNewAction(searchAction, taskList, arrString[1]);
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