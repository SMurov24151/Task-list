package task.methods.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task.Task;
import task.TaskList;
import task.methods.ActionTaskStrategy;

public class PrintAction implements ActionTaskStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PrintAction.class);

    @Override
    public void execute(TaskList taskList, String in) {
        String[] arrString = in.split(" ", 2);
        if (arrString.length<2){
            for (Task task : taskList.getTasks()) {
                if (!task.getState()) task.print();
            }
        } else if (arrString[1].equals("all")) {
            for (Task task : taskList.getTasks()) {
                task.print();
            }
        } else {
            logger.error("Error in input for action print");
            System.out.println("Некорректный ввод");
        }
    }
}
