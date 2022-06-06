package task;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import task.methods.ActionExecutor;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
@EntityScan(basePackages = {"task"})
public class Main implements CommandLineRunner {
    static TaskList taskList = TaskList.getInstance();
    public static int nextIndexTask = 1;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static List<String> ACTION_WITH_REQUIRED_ARG = List.of("add", "toggle", "delete", "edit", "search");
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    private final ActionExecutor executor;

    @Override
    public void run(String... args) {
        logger.info("Simple log statement");
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
            executor.runTask(action, taskList, input);
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