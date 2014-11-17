package designpatterns.status;

public class Light {
	
	private State state;

	public Light(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void change(Light light){
		
		state.change(light);
		
	}
	
	//信号的24小时工作
	public void work() {
		
		while(true) {
			change(this);
		}
	}
	
	/**
	 * 变黄灯
	 * @param light
	 */
	public void toYellowState(Light light) {
		light.setState(new YellowState());
	}
	
	/**
	 * 变红灯
	 * @param light
	 */
	public void toRedState(Light light) {
		light.setState(new RedState());
	}
	
	
	/**
	 * 变绿灯
	 * @param light
	 */
	public void toGreenState(Light light) {
		light.setState(new GreenState());
	}

}
