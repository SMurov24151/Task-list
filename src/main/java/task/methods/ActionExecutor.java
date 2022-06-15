package task.methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.TaskList;
import task.methods.impl.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

@Service
public class ActionExecutor {

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

    public Map<String, ActionTaskStrategy> strategyByAction() {
        Map<String, ActionTaskStrategy> result = new HashMap<>();

        result.put("add", addAction);
        result.put("delete", deleteAction);
        result.put("edit", editAction);
        result.put("print", printAction);
        result.put("search", searchAction);
        result.put("toggle", toggleAction);

        return result;
    }

    public void runTask(String actionName, TaskList taskList, String args) {
        if (actionName.equals("quit")) exit(0);
        strategy = strategyByAction().get(actionName);
        if (strategy == null) {
            System.out.println("Введенная команда не поддерживается\n");
            return;
        }
        this.strategy.execute(taskList, args);
    }
}
