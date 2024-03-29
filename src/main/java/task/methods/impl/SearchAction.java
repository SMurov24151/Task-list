package task.methods.impl;

import org.springframework.stereotype.Service;
import task.Task;
import task.TaskList;
import task.methods.ActionTaskStrategy;

@Service
public class SearchAction implements ActionTaskStrategy {
    @Override
    public void execute(TaskList taskList, String in) {
        String[] arrString = in.split(" ", 2);
        String substring = arrString[1];;
        if (substring.length() == 0) {
            System.out.println("Введите слово");
            return;
        }
        for (Task task : taskList.getTasks()) {
            if (task.getDescription().contains(substring))
                task.print();
        }
    }
}
