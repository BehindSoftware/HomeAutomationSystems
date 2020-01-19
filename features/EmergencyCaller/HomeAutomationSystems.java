
public class HomeAutomationSystems{

	protected void started() {
		original();
		// subscribes and listens to channel
		Runnable12 sensorDataSubsPub = new Runnable12();
		sensorDataSubsPub.start();
    }
}

class Runnable12 extends Thread 
{ 
	Subject subject = new Subject();
	
    @Override
    public void run() {
    	super.run();
    	while(true) {
    		try
    		{
    			Thread.sleep(5000);
    			subject.registerChanneltoListen("C2");
    			subject.registerChanneltoListen("C4");
    			subject.registerChanneltoListen("C5");
    		}
    		catch(InterruptedException ex)
    		{

    			Thread.currentThread().interrupt();
    		}
    	}
    }
}
