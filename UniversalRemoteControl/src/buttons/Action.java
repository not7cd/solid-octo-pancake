package buttons;

public class Action {
    private String action;

    public Action(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }

    public void execute() {
        System.out.println("Executing: " + this);
    }
}
