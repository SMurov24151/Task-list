package task.methods.impl;

import org.springframework.stereotype.Service;
import task.Main;
import task.TaskList;
import task.methods.ActionTaskStrategy;

@Service
public class DeleteAction implements ActionTaskStrategy {
    @Override
    public void execute(TaskList taskList, String in) {
        String[] arrString = in.split(" ", 2);
        in = arrString[1];
        int id = Main.findElement(in);
        if (id >= 0) taskList.getTasks().remove(id);
    }
}
