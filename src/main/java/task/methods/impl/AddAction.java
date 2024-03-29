package task.methods.impl;

import org.springframework.stereotype.Service;
import task.Main;
import task.Task;
import task.TaskList;
import task.methods.ActionTaskStrategy;

@Service
public class AddAction implements ActionTaskStrategy {

    @Override
    public void execute(TaskList taskList, String in) {
        String[] arrString = in.split(" ", 2);
        String description = arrString[1];
        if (description.length() == 0) {
            System.out.println("Необходимо ввести описание задачи");
            return;
        }
        taskList.getTasks().add(new Task(description, Main.nextIndexTask));
        Main.nextIndexTask++;
    }
}
