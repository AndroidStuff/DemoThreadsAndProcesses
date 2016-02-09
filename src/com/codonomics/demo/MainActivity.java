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

	@OnClick(R.id.alternative1)
	public void goForAlternative1(View v) {
		startActivity(new Intent(this, Alternative1Activity.class));
	}

	@OnClick(R.id.alternative2)
	public void goForAlternative2(View v) {
		startActivity(new Intent(this, Alternative2Activity.class));
	}

	@OnClick(R.id.alternative3)
	public void goForAlternative3(View v) {
		startActivity(new Intent(this, Alternative3Activity.class));
	}
}
