

public class Subject {

	private String name;
	private int duration_onState;
	private int duration_offState;
	private int value;
	
	public void valueIncrease() {
		this.setValue(++this.value);
	}
	
	public void valueDecrease() {
		this.setValue(--this.value);
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getDuration_onState() {
		return duration_onState;
	}
	
	public void setDuration_onState(int duration_onState) {
		this.duration_onState = duration_onState;
	}
	
	public int getDuration_offState() {
		return duration_offState;
	}
	
	public void setDuration_offState(int duration_offState) {
		this.duration_offState = duration_offState;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    public void updateState (Context context) {

        // Notify the list of registered listeners

        this.notifyAnimalAddedListeners(context);

    }

    protected void notifyAnimalAddedListeners (Context context) {

        // Notify each of the listeners in the list of registered listeners
    	context.doAction();

    }

}