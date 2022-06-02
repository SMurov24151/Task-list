package task.methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.TaskList;
import task.methods.impl.*;

@Service
public class ActionExecutor {

    private TaskList taskList;
    private String in;
    private ActionTaskStrategy strategy;

    @Autowired
    private AddAction addAction;
    @Autowired
    private DeleteAction deleteAction;
    @Autowired
    private EditAction editAction;
    @Autowired
    private PrintAction printAction;
    @Autowired
    private SearchAction searchAction;
    @Autowired
    private ToggleAction toggleAction;

    public void runTask() {
        this.strategy.execute(taskList, in);
    }

    public void addOperation(TaskList taskList, String param) {
        setNewAction(addAction, taskList, param);
        runTask();
    }

    public void printOperation(TaskList taskList, String param) {
        setNewAction(printAction, taskList, param);
        runTask();
    }

    public void toggleOperation(TaskList taskList, String param) {
        setNewAction(toggleAction, taskList, param);
        runTask();
    }

    public void editOperation(TaskList taskList, String param) {
        setNewAction(editAction, taskList, param);
        runTask();
    }

    public void deleteOperation(TaskList taskList, String param) {
        setNewAction(deleteAction, taskList, param);
        runTask();
    }

    public void searchOperation(TaskList taskList, String param) {
        setNewAction(searchAction, taskList, param);
        runTask();
    }

    public void setNewAction(ActionTaskStrategy strategy, TaskList taskList, String in) {
        this.strategy = strategy;
        this.taskList = taskList;
        this.in = in;
    }
}
