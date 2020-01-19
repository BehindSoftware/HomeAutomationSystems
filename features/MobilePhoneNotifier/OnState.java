
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C3", "MobilePhoneNotifier is in on state");
	}

}
