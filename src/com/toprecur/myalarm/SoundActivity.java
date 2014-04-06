package com.toprecur.myalarm;

import android.app.Activity;
import android.app.Notification;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;

public class SoundActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound);
		Uri soundURI = Uri
				.parse("android.resource://course.examples.Notification.StatusBarWithCustomView/"
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