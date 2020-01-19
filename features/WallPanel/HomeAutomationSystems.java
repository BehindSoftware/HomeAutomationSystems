
public class HomeAutomationSystems extends Thread{

	Subject subject = new Subject();
	
	protected void started() {
		original();
		// subscribes and listens to channel
		HomeAutomationSystems sensorDataSubscriber = new HomeAutomationSystems();
		sensorDataSubscriber.start();
    }
    
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C4");
    			subject.registerChanneltoListen("C6");
    			subject.registerChanneltoListen("C5");
    			subject.registerChanneltoListen("C2");
    			subject.registerChanneltoListen("C7");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }

}
