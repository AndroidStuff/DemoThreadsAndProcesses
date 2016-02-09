package com.codonomics.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
	private final static String TAG = MainActivity.class.getSimpleName();

	@Bind(R.id.wrongWay1) Button wrongWay1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.wrongWay1)
	public void goWrongWay1(View v) {
		startActivity(new Intent(this, WrongWay1Activity.class));
	}
}
