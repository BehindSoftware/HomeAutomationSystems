import java.io.IOException; import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

import org.json.JSONException; 
import org.json.JSONObject; 
public   class  HomeAutomationSystems  extends Thread {
	

	 private void  started__wrappee__Sensors  () {
		System.out.println("HomeAutomationSystems are started...");
	}

	

	 private void  started__wrappee__Temperature  () {
		started__wrappee__Sensors();

		Runnable7 sensorDataPublisher = new Runnable7();
		sensorDataPublisher.start();
	}

	

	 private void  started__wrappee__TemperatureController  () {
		started__wrappee__Temperature();
		// subscribes and listens to channel
		Runnable13 sensorDataSubsPub = new Runnable13();
		sensorDataSubsPub.start();
    }

	
	
	protected void started() {
		started__wrappee__TemperatureController();
		// subscribes and listens to channel
		HomeAutomationSystems sensorDataSubscriber = new HomeAutomationSystems();
		sensorDataSubscriber.start();
    }

	
	
	public static void main(String[] args){
		try {
			ProcessBuilder pb = new ProcessBuilder("redis-stable/src/redis-server");
			Process p = pb.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		new HomeAutomationSystems().started();
	}

	

	Subject subject = new Subject();

	
    
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
 
class  Runnable7  extends Thread {
	 
	Context context = new Context();

	 
	OnState onState = new OnState();

	
	OffState offState = new OffState();

	
	static Subject sensor = new Subject();

	

	@Override
	public void run() {
		super.run();

		try {
			Scanner scanner = new Scanner( new File("sim_env.json") );
			String json = scanner.useDelimiter("\\A").next();
			scanner.close();
			JSONObject obj = new JSONObject(json);
			sensor.setName("Temperature");
			sensor.setDuration_onState(Integer.parseInt(obj.getJSONObject(sensor.getName()).getString("duration_onState")));	
			sensor.setDuration_offState(Integer.parseInt(obj.getJSONObject(sensor.getName()).getString("duration_offState")));
			sensor.setValue(Integer.parseInt(obj.getJSONObject(sensor.getName()).getString("value")));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(true) {
			try
			{
				context.setState(offState); 
				sensor.updateState(context);
				Thread.sleep(sensor.getDuration_offState());
				context.setState(onState); 
				sensor.updateState(context);
				sensor.valueIncrease(); //Increase 1 degree at one onStateDuration
				Thread.sleep(sensor.getDuration_onState());
				sensor.valueDecrease(); //Decrease 1 degree at one offStateDuration
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
	}


} 

 

class  Runnable13  extends Thread {
	 
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
