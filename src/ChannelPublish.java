import redis.clients.jedis.Jedis; 
 
public  class  ChannelPublish {
	
 
  public static void publish(String channel, String message) {
     
    Jedis jedis = null;
     
    try {           
    /* Creating Jedis object for connecting with redis server */
    jedis = new Jedis("localhost");
             
    /* Publishing message to channel C13 */
    jedis.publish(channel, message); 
             
    } catch(Exception ex) {         
             
            System.out.println("Exception : " + ex.getMessage());   
             
    } finally {
             
        if(jedis != null) {
            jedis.close();
        }
             
    }
  }


}
