package task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> tasks;
    private static TaskList INSTANCE;

    private TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public static TaskList getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskList();
        }
        return INSTANCE;
    }
    public List<Task> getTasks() {
        return tasks;
    }
}