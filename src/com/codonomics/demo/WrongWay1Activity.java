package com.codonomics.demo;

import android.app.Activity;
import android.os.Bundle;

public class WrongWay1Activity extends Activity {
	private final static String TAG = WrongWay1Activity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wrong_way_1);
	}
}
