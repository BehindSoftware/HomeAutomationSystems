

public   class  OffState  implements State {
	

	@Override
	public void doAction() {
		ChannelPublish.publish("C7", "TemperatureController is in off state");
	}


}
