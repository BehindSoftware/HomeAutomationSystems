

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C2", "GlassBreakDetector is in off state");
	}

}
