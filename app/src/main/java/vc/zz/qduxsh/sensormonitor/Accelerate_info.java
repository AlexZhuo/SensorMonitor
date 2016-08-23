package vc.zz.qduxsh.sensormonitor;

public class Accelerate_info {
	public long id ;
	public long time;
	public double value;
	public int sensor;
	
	public Accelerate_info(long time, double value, int sensor) {
		this.time = time;
		this.value = value;
		this.sensor = sensor;
	}
	public Accelerate_info(){};
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getSensor() {
		return sensor;
	}
	public void setSensor(int sensor) {
		this.sensor = sensor;
	}
	@Override
	public String toString() {
		return "Accelerate_info [id=" + id + ", time=" + time + ", value="
				+ value + ", sensor=" + sensor + "]";
	}
	
	
}
