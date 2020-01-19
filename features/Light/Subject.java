
public class Subject {

	public void registerChanneltoListen (String channel) {

		// Add the listener to the list of registered listeners

		ChannelSubscribe.subscribe(channel);

	}

	public void unregisterChanneltoListen (String channel) {

		// Remove the listener from the list of the registered listeners

		//ChannelSubscribe.unsubscribe(channel);

	}

}