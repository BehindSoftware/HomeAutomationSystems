
public   class  OnState  implements State {
	

	@Override
	public void doAction() {
		ChannelPublish.publish("C7", "TemperatureController is in on state");
	}


}
