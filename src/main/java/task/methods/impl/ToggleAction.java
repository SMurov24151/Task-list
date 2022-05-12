package task.methods.impl;

import task.Main;
import task.TaskList;
import task.methods.ActionTaskStrategy;

public class ToggleAction implements ActionTaskStrategy {
    @Override
    public void execute(TaskList taskList, String in) {
        int id = Main.findElement(in);
        if (id >= 0) taskList.getTasks().get(id).setState(!taskList.getTasks().get(id).getState());
    }
}
