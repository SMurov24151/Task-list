package task;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Task {
    private String description;
    public Boolean state;
    public int id;
    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    public Task(String description, int id) {
        this.id = id;
        this.description = description;
        this.state = false;
    }
    public void print() {
        System.out.println(id + ". " + ((state == true) ? "- " : "x ") + description);
        logger.debug("task.print for task with id {}", id);
    }
}