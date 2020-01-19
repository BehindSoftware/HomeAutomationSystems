

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C4", "SirenController is in off state");
	}

}
