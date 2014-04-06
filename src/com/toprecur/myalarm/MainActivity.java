package com.toprecur.myalarm;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  OnClickListener setClickListener = new OnClickListener() {
			  
	            @Override
	            public void onClick(View v) {
	              
	                Intent i = new Intent(MainActivity.this,SoundActivity.class);
	                //startActivity(i);
	 
	               
	                PendingIntent operation = PendingIntent.getActivity(getBaseContext(), 0, i, Intent.FLAG_ACTIVITY_NEW_TASK);
	 
	                
	                AlarmManager alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);
	 
	                TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
	 
	                int hour = tpTime.getCurrentHour();
	                int minute = tpTime.getCurrentMinute();
	 
	                
	                GregorianCalendar calendar = new GregorianCalendar( hour, minute, 0);
	 
	                
	                long alarm_time = calendar.getTimeInMillis();
	 
	               
	                alarmManager.set(AlarmManager.RTC_WAKEUP  , alarm_time , operation);
	 
	                
	                Toast.makeText(getBaseContext(), "Alarm is set successfully",Toast.LENGTH_SHORT).show();
	            }
	        };
	        OnClickListener quitClickListener = new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                finish();
	            }
	        };
	 
	        Button btnSetAlarm = ( Button ) findViewById(R.id.btn_set_alarm);
	        btnSetAlarm.setOnClickListener(setClickListener);
	 
	        Button btnQuitAlarm = ( Button ) findViewById(R.id.btn_quit_alarm);
	        btnQuitAlarm.setOnClickListener(quitClickListener);
	 
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
