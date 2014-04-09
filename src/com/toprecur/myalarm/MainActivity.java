package com.toprecur.myalarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
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
			

			public void onClick(View v) {

				TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);
		
//				 GregorianCalendar calendar = new GregorianCalendar(hour,
//						 minute, 0);
				AlarmManager alarmManager = (AlarmManager) getBaseContext()
						.getSystemService(ALARM_SERVICE);
				
				int hour = tpTime.getCurrentHour();
				int minute = tpTime.getCurrentMinute();
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				long alarm_time = calendar.getTimeInMillis();
			
			/*	StringBuilder sb = new StringBuilder();
				sb.append(hour);
				sb.append(minute);
				
				String str = Integer.toString(hour);
				String str1 = Integer.toString(minute);
						
				intent.putExtra(str, hour);
				intent.putExtra(str1, minute);*/

			//	Intent intent = new Intent(MainActivity.this,SoundActivity.class);
				 Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
		            //.putExtra(AlarmClock.EXTRA_MESSAGE, message)
		            .putExtra(AlarmClock.EXTRA_HOUR, hour)
		            .putExtra(AlarmClock.EXTRA_MINUTES, minute);
		   
		        startActivity(intent);
				
				PendingIntent operation = PendingIntent.getActivity(
						getBaseContext(), 0, intent,Intent.FLAG_ACTIVITY_NEW_TASK);
			  //intent.putExtra ("hour",hour);
			  //intent.putExtra ("minute",minute);
			  //tartActivity(intent);
				alarmManager.set(AlarmManager.RTC_WAKEUP,
						calendar.getTimeInMillis(), operation);

				Toast.makeText(MainActivity.this, "Alarm is set successfully",
						Toast.LENGTH_SHORT).show();

			}

		};

		 OnClickListener repeatClickListener = new OnClickListener() {
		 public void onClick(View v) {
		 Intent intent = new Intent(MainActivity.this,RepeatActivity.class);
		
		  intent = putExtra(this, RepeatActivity.class);
		  startActivity(intent);
		 }
		
		 private Intent putExtra(OnClickListener onClickListener,
		 Class<RepeatActivity> class1) {
		
		 return null;
		 }
		 };

		OnClickListener quitClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {

				finish();
			}
		};
		Button btnSetAlarm = (Button) findViewById(R.id.btn_set_alarm);
		btnSetAlarm.setOnClickListener(setClickListener);
		
		Button btnQuitAlarm = (Button) findViewById(R.id.btn_quit_alarm);
		btnQuitAlarm.setOnClickListener(quitClickListener);

//		Button btnRepeatAlarm = (Button) findViewById(R.id.btn_set_repeat);
//		btnRepeatAlarm.setOnClickListener(setClickListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
