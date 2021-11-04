package buttons;

public class Button {
    private Action action;
    private Action actionOpposite;



    public Action activated() {
        return this.action;
    }

    public Action deactivated() {
        return this.actionOpposite;
    }

    public Button(Action action, Action actionOpposite) {
        this.action = action;
        this.actionOpposite = actionOpposite;
    }
}
