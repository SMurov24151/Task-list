package task.methods.impl;

import org.springframework.stereotype.Service;
import task.Main;
import task.TaskList;
import task.methods.ActionTaskStrategy;

@Service
public class EditAction implements ActionTaskStrategy {
    @Override
    public void execute(TaskList taskList, String in) {
        String[] arrString = in.split(" ", 2);
        int id = Main.findElement(arrString[0]);
        String descriptionTask = arrString[1];
        if (id >= 0) taskList.getTasks().get(id).setDescription(descriptionTask);
    }
}
