import java.util.Scanner;

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

    public void add() {
        state = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Опишите задaчу: ");
        description = in.nextLine();
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
