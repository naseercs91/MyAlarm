package com.toprecur.myalarm;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;

public class SoundActivity extends Activity {

	private MediaPlayer mPlay;
	public Intent intent;

//	String str;
//	String str1;
	int hour;
	int minute;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound);
		intent.getIntExtra("AlarmClock.EXTRA_HOUR",hour);
		intent.getIntExtra("AlarmClock.EXTRA_MINUTES", minute);
//		intent.getIntExtra("hour", 0);
//		intent.getIntExtra("minute",0);
//		int hour = Integer.parseInt(str);
//		int minute = Integer.parseInt(str1);
	
		MediaPlayer mPlay = MediaPlayer.create(this, R.raw.alarm_rooster);
		mPlay.start();
		Uri soundURI = Uri.parse("android.resource://com.toprecur.myalarm/"
				+ R.raw.alarm_rooster);
		Notification.Builder notificationBuilder = new Notification.Builder(
				getApplicationContext()).setSound(soundURI);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sound, menu);
		return true;
	}
}