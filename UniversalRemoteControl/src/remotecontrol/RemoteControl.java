package remotecontrol;

import buttons.Button;
import buttons.ButtonFactory;
import buttons.SimpleButtonFactory;

/**
 * Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {

    public final static int NO_OF_ACTION_BUTTONS = 3;

    private boolean[] buttonStatus;
    private int lastNo;
    private Button[] buttons;
    private ButtonFactory buttonFactory;
    // TODO: Data structures for the actions

    public RemoteControl() {
        buttonStatus = new boolean[NO_OF_ACTION_BUTTONS];

        buttons = new Button[NO_OF_ACTION_BUTTONS];
        buttonFactory = new SimpleButtonFactory();
    }

    @Override
    public void configureButton(int no, String action, String oppositeAction) {
        buttons[no] = buttonFactory.createButton(action, oppositeAction);
    }

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    public void actionButtonPressed(int no) {
        // Execute action
        if (buttonStatus[no] == false) {
            System.out.println("Button activated: " + no);
            buttons[no].activated().execute();
        } else {
            System.out.println("Button deactivated: " + no);
            buttons[no].deactivated().execute();
        }
        // Invert button status
        buttonStatus[no] = !buttonStatus[no];
        lastNo = no;
    }

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    public void undoButtonPressed() {
        // Execute undo action
        System.out.println("Undo button pressed");
        actionButtonPressed(lastNo);
    }
}
