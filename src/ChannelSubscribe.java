import redis.clients.jedis.Jedis; 
import redis.clients.jedis.JedisPubSub; 
 
public   class  ChannelSubscribe {
	
 
	static Context context  = new Context();

	
	static OnState onState  = new OnState();

	
	static OffState offState  = new OffState();

	

	public static void subscribe(String channel) {

		Jedis jedis = null;

		try {

			/* Creating Jedis object for connecting with redis server */
			jedis = new Jedis("localhost");

			/* Creating JedisPubSub object for subscribing with channels */
			JedisPubSub jedisPubSub = new JedisPubSub() {

				@Override
				public void onPMessage(String pattern, String channel, String message) {
					System.out.println("Channel " +channel+ " has sent a message : " +message+ " on pattern " + pattern);
				}

				@Override
				public void onPSubscribe(String pattern, int subscribedChannels) {
					System.out.println("Client is Subscribed to pattern : "+ pattern);
					System.out.println("Client is Subscribed to "+ subscribedChannels + " no. of patterns");
				}

				@Override
				public void onPUnsubscribe(String pattern, int subscribedChannels) {
					System.out.println("Client is Unsubscribed from pattern : "+ pattern);
					System.out.println("Client is Subscribed to "+ subscribedChannels + " no. of patterns");
				}

				@Override
				public void onMessage(String arg0, String arg1) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onSubscribe(String arg0, int arg1) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onUnsubscribe(String arg0, int arg1) {
					// TODO Auto-generated method stub

				}

			};

			/* Subscribing to channel C1 and C2 */
			jedis.psubscribe(jedisPubSub, channel);

		} catch(Exception ex) {         

			System.out.println("Exception : " + ex.getMessage());   

		} finally {

			if(jedis != null) {
				jedis.close();
			}

		}       
	}


}
