

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C2", "EmergencyCaller is in off state");
		ChannelPublish.publish("C4", "EmergencyCaller is in off state");
		ChannelPublish.publish("C5", "EmergencyCaller is in off state");
	}

}
