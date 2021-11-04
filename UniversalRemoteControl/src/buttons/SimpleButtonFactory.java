package buttons;

public class SimpleButtonFactory implements ButtonFactory {

    @Override
    public Button createButton(String action, String opposite) {
        Action a = new Action(action);
        Action o = new Action(opposite);
        return new Button(a, o);
    }
}
