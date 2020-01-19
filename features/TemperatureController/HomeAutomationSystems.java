
public class HomeAutomationSystems{

	protected void started() {
		original();
		// subscribes and listens to channel
		Runnable13 sensorDataSubsPub = new Runnable13();
		sensorDataSubsPub.start();
    }
}

class Runnable13 extends Thread 
{ 
	Subject subject = new Subject();
	
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C7");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }
}
