
public class HomeAutomationSystems{

	protected void started() {
		original();
		// subscribes and listens to channel
		Runnable11 sensorDataSubsPub = new Runnable11();
		sensorDataSubsPub.start();
    }
}

class Runnable11 extends Thread 
{ 
	Subject subject = new Subject();
	
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C3");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }
}
