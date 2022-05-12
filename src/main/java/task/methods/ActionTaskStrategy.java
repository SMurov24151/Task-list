package task.methods;

import task.TaskList;

@FunctionalInterface
public interface ActionTaskStrategy {
    public void execute(TaskList taskList, String in);
}