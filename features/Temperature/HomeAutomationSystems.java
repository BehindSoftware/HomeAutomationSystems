import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeAutomationSystems{

	protected void started() {
		original();

		Runnable7 sensorDataPublisher = new Runnable7();
		sensorDataPublisher.start();
	}
}
class Runnable7 extends Thread 
{ 
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
