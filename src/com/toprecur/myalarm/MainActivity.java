package com.toprecur.myalarm;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {


	protected static final TimePicker timePicker1 = null;
	protected static final Calendar calendar = null;
	protected static final String ELAPSED_TIME = null;
	protected static final String INTERVAL_DAY = null;
	protected static final PendingIntent operation = null;
	protected String FLAG_ACTIVITY_NEW_TASK;
	protected Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
	
	            	final AlarmManager alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);
	            	 OnClickListener setClickListener = new OnClickListener() {
	              public void onClick(View v) {
	                TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
	 
	                int hour = tpTime.getCurrentHour();
	                int minute = tpTime.getCurrentMinute();
              
	                GregorianCalendar calendar = new GregorianCalendar( hour, minute, 0);
	 	             
	            	
	                long alarm_time = calendar.getTimeInMillis();
	                
	                Intent intent = new Intent(MainActivity.this,SoundActivity.class);
	                
	                PendingIntent operation = PendingIntent.getActivity(getBaseContext(), 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
	                	               
	                Intent intent1 = new Intent(MainActivity.this,RepeatActivity.class);
	                
	                alarmManager.set(AlarmManager.RTC_WAKEUP  , alarm_time , operation);
	                
	                Toast.makeText(getBaseContext(), "Alarm is set successfully",Toast.LENGTH_SHORT).show();
	             
	            }
	        };
	         OnClickListener repeatClickListener = new OnClickListener (){
	        	 public void onClick (View v){
	        		 alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),
	                         2*60*60, operation);
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
	        
	        Button btnRepeatAlarm = (Button) findViewById(R.id.btn_set_repeat);
	        btnRepeatAlarm.setOnClickListener (setClickListener);
	       
	        }

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
