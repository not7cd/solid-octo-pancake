import remotecontrol.RemoteControl;

/**
 * Main for testing the functionality
 */
public class Main {
	public static void main(String[] args) {
		RemoteControl mediaPlayerRemote = new RemoteControl();

		mediaPlayerRemote.configureButton(0, "on", "off");
		mediaPlayerRemote.configureButton(1, "play", "pause");
		mediaPlayerRemote.configureButton(2, "next", "previous");

		mediaPlayerRemote.actionButtonPressed(0);
		mediaPlayerRemote.actionButtonPressed(1);
		mediaPlayerRemote.actionButtonPressed(2);
		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(1);
		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(0);

		mediaPlayerRemote.actionButtonPressed(0);
		mediaPlayerRemote.undoButtonPressed();
		mediaPlayerRemote.actionButtonPressed(0);

	}
}

