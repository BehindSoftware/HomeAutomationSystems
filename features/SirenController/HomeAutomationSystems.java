
public class HomeAutomationSystems{

	protected void started() {
		original();
		// subscribes and listens to channel
		Runnable10 sensorDataSubsPub = new Runnable10();
		sensorDataSubsPub.start();
    }
}

class Runnable10 extends Thread 
{ 
	Subject subject = new Subject();
	
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C4");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }
}
