public class Task {
    private String description;
    private Boolean state;

    public Task(String description) {
        this.description = description;
        this.state = false;
    }

    public Task() {
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

    public void add() {
    }

    public void print () {
    }

    public void toggle () {
    }

    public void quit () {
    }
}
