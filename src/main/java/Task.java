
import static java.lang.System.exit;

public class Task {
    private String description;
    private Boolean state;

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", state=" + state +
                '}';
    }

    public Task(String description) {
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

    public void add(String descriptionTask) {
        state = false;
        description = descriptionTask;
    }

    public void print () {
        System.out.println(((state == true) ? "-" : "x") + " " + description);
    }

    public void toggle () {
        state = !state;
    }

    public void quit () {
        exit(0);
    }
}
