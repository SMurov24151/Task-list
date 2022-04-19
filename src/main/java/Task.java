public class Task {
    private String description;
    public Boolean state;
    public int id;

    @Override
    public String toString() {
        return "Task{" +
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
    }
}
