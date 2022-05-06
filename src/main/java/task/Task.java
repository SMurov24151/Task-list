package task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {
    private String description;
    public Boolean state;
    public int id;
    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    @Override
    public String toString() {
        return "task.Task{" +
                "description='" + description + '\'' +
                ", state=" + state +
                '}';
    }

    public Task(String description, int id) {
        this.id = id;
        this.description = description;
        this.state = false;
    }

    public Task() {
        state = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void print() {
        System.out.println(id + ". " + ((state == true) ? "- " : "x ") + description);
        logger.debug("task.print for task with id {}", id);
    }
}
