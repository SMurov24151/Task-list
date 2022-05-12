package task.methods;

import task.TaskList;

public class ActionExecutor {
    private TaskList taskList;
    private String in;
    private ActionTaskStrategy strategy;

    public ActionExecutor() {
    }

    public void setNewAction(ActionTaskStrategy strategy, TaskList taskList, String in) {
        this.strategy = strategy;
        this.taskList = taskList;
        this.in = in;
    }

    public void runTask() {
        this.strategy.execute(taskList, in);
    }
}
