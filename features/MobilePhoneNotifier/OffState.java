

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C3", "MobilePhoneNotifier is in off state");
	}

}
