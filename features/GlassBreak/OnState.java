
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C2", "GlassBreakDetector is in on state");
	}

}
