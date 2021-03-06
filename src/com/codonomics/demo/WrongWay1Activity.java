package com.codonomics.demo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WrongWay1Activity extends Activity {
	private final static String TAG = WrongWay1Activity.class.getSimpleName();

	protected static final String URL_RANDOM_IMAGE = "http://lorempixel.com/250/250/";

	@Bind(R.id.randomImageButton) Button randomImageButton;
	@Bind(R.id.randomImageView) ImageView randomImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wrong_way_1);

		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
	}

	//This implementation throws FATAL EXCEPTION: Only the original thread that created a view hierarchy can touch its views.
	//Reason is we're updating the randomImageView view created by parent thread.
	@OnClick(R.id.randomImageButton)
	public void getRandomImage(View v) {
		Log.d(TAG, "In getRandomImage(..)");
		new Thread(new Runnable() {
			@Override
			public void run() {
				Bitmap image = loadImageFromNetwork(URL_RANDOM_IMAGE);
				randomImageView.setImageBitmap(image);
			}
		}).start();
	}

	private Bitmap loadImageFromNetwork(String urlRandomImage) {
		try {
			Log.d(TAG, "Loading " + urlRandomImage + "...");
			URL url=new URL(urlRandomImage);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input=connection.getInputStream();
			Bitmap bmp = BitmapFactory.decodeStream(input);
			return bmp;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
