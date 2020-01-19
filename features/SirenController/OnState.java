
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C4", "SirenController is in on state");
	}

}
