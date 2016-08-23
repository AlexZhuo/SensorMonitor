package vc.zz.qduxsh.sensormonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jpardogo.android.flabbylistview.lib.FlabbyLayout;
import com.jpardogo.android.flabbylistview.lib.FlabbyListView;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SensorList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_list);
		FlabbyListView listView = (FlabbyListView) findViewById(R.id.listView1);
		List<SensorInfo> data = new ArrayList<SensorInfo>();
		  //获取一个传感器管理器
	    SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
	    List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
	    int count=0;
	    for (Sensor sensor : sensors) {
			SensorInfo sensorInfo = new SensorInfo();
			sensorInfo.sensorName =sensor.getName();
			int sensorType = sensor.getType();
			String type;
			String discription;
			count++;
			switch (sensorType) {
			case Sensor.TYPE_ACCELEROMETER:
				type="TYPE_ACCELEROMETER";
				discription = "加速度传感器";
				break;
			case Sensor.TYPE_AMBIENT_TEMPERATURE:
				type="TYPE_AMBIENT_TEMPERATURE";
				discription="外界温度传感器";
				break;
			case Sensor.TYPE_GAME_ROTATION_VECTOR:
				type="TYPE_GAME_ROTATION_VECTOR";
				discription="转动向量传感器";
				break;
			case Sensor.TYPE_GRAVITY:
				type="TYPE_GRAVITY";
				discription="重力传感器";
				break;
			case Sensor.TYPE_GYROSCOPE:
				type="TYPE_GYROSCOPE";
				discription="陀螺仪";
				break;
			case Sensor.TYPE_LIGHT:
				type="TYPE_LIGHT";
				discription="光照传感器";
				break;
			case Sensor.TYPE_LINEAR_ACCELERATION:
				type="TYPE_LINEAR_ACCELERATION";
				discription="线性加速度传感器";
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				type="TYPE_MAGNETIC_FIELD";
				discription="磁场传感器";
				break;
			case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
				type="TYPE_MAGNETIC_FIELD_UNCALIBRATED";
				discription="未校准磁场传感器";
				break;
			case Sensor.TYPE_PROXIMITY:
				type="TYPE_PROXIMITY";
				discription="近距离传感器";
				break;
			case Sensor.TYPE_ROTATION_VECTOR:
				type="TYPE_ROTATION_VECTOR";
				discription="旋转向量传感器";
				break;
			case Sensor.TYPE_SIGNIFICANT_MOTION:
				type="TYPE_SIGNIFICANT_MOTION";
				discription="有力动作感应器";
				break;
			case Sensor.TYPE_TEMPERATURE:
				type="TYPE_TEMPERATURE";
				discription="cpu温度感应器";
				break;
			case Sensor.TYPE_PRESSURE:
				type="TYPE_PRESSURE";
				discription="压力感应器";
				break;
			case Sensor.TYPE_STEP_COUNTER:
				type="TYPE_STEP_COUNTER";
				discription="计步器";
				break;
			case Sensor.TYPE_RELATIVE_HUMIDITY:
				type="TYPE_RELATIVE_HUMIDITY";
				discription="相对湿度感应器";
				break;
			case Sensor.TYPE_ORIENTATION:
			 	type="TYPE_ORIENTATION";
			 	discription="方向感应器";
				break;

			default:
				type="未知";
				discription="未知";
				break;
			}
			sensorInfo.type = type;
			sensorInfo.disp = discription;
			sensorInfo.count = String.valueOf(count);
			data.add(sensorInfo);
			
		}
		final Random random = new Random();
		listView.setAdapter(new CommonAdapter<SensorInfo>(this,R.layout.sensor_info_item,data) {
			@Override
			public void convert(ViewHolder holder, int position, SensorInfo entity) {
				holder.setText(R.id.count,entity.count);
				holder.setText(R.id.sensorName,entity.sensorName);
				holder.setText(R.id.sensorType,entity.type);
				holder.setText(R.id.disp,entity.disp);
				int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
				((FlabbyLayout)holder.getConvertView()).setFlabbyColor(color);
			}
		});
	}

	public static class SensorInfo{
		public String disp;
		public String type;
		public String count;
		public String sensorName;
	}

	
}
