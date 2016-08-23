package vc.zz.qduxsh.sensormonitor;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.romainpiel.shimmer.ShimmerViewBase;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class IndexActivity extends Activity {
	FButton myPhone ;
	FButton accelButton ;
	FButton proxiButton ;
	FButton lightButton; 
	FButton magButton;
	FButton tempButton;
	FButton humidityButton;
	FButton gravityButton;
	FButton preasureButton;
	FButton rotateButton;
	
	Shimmer shimmer;
	ShimmerTextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		if(title==null){
			initialViews();
		}
		shimmer = new Shimmer();
		shimmer.start(title);
		myPhone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(IndexActivity.this, SensorList.class));
			}
		});
		OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int wtd=0;
				switch (v.getId()) {
				case R.id.accelButton:
					wtd=Sensor.TYPE_ACCELEROMETER;
					break;
				case R.id.proxiButton:
					wtd=Sensor.TYPE_PROXIMITY;
					break;
				case R.id.lightButton:
					wtd=Sensor.TYPE_LIGHT;
					break;
				case R.id.magButton:
					wtd=Sensor.TYPE_MAGNETIC_FIELD;
					break;
				case R.id.tempratrueButton:
					wtd=Sensor.TYPE_TEMPERATURE;
					break;
				case R.id.humidityButton:
					wtd=Sensor.TYPE_RELATIVE_HUMIDITY;
					break;
				case R.id.pressureButton:
					wtd=Sensor.TYPE_PRESSURE;
					break;
				case R.id.gravityButton:
					wtd=Sensor.TYPE_GRAVITY;
					break;
				case R.id.rotateButton:
					wtd=Sensor.TYPE_ROTATION_VECTOR;
					break;

				default:
					break;
				}
				Intent intent = new Intent(IndexActivity.this,AccelActivity.class);
				intent.putExtra("wtd",wtd );
				startActivity(intent);
			}
		};
		accelButton.setOnClickListener(onClickListener);
		lightButton.setOnClickListener(onClickListener);
		proxiButton.setOnClickListener(onClickListener);
		magButton.setOnClickListener(onClickListener);
		tempButton.setOnClickListener(onClickListener);
		preasureButton.setOnClickListener(onClickListener);
		humidityButton.setOnClickListener(onClickListener);
		gravityButton.setOnClickListener(onClickListener);
		preasureButton.setOnClickListener(onClickListener);
		rotateButton.setOnClickListener(onClickListener);
		
	}
	
	public void initialViews(){
		myPhone = (FButton) findViewById(R.id.myPhone);
		accelButton = (FButton) findViewById(R.id.accelButton);
		proxiButton = (FButton) findViewById(R.id.proxiButton);
		lightButton = (FButton) findViewById(R.id.lightButton);
		magButton = (FButton) findViewById(R.id.magButton);
		tempButton = (FButton) findViewById(R.id.tempratrueButton);
		preasureButton = (FButton) findViewById(R.id.pressureButton);
		humidityButton = (FButton) findViewById(R.id.humidityButton);
		gravityButton = (FButton) findViewById(R.id.gravityButton);
		rotateButton = (FButton) findViewById(R.id.rotateButton);
		
		
		title = (ShimmerTextView) findViewById(R.id.shimmer_tv);
	}
	
	
}
