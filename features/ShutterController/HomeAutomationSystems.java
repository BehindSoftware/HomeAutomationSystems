
public class HomeAutomationSystems{

	protected void started() {
		original();
		// subscribes and listens to channel
		Runnable9 sensorDataSubsPub = new Runnable9();
		sensorDataSubsPub.start();
    }
}

class Runnable9 extends Thread 
{ 
	Subject subject = new Subject();
	
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C6");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }
}
