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

public class Alternative2Activity extends Activity {
	private final static String TAG = WrongWay1Activity.class.getSimpleName();

	protected static final String URL_RANDOM_IMAGE = "http://lorempixel.com/250/250/";

	@Bind(R.id.randomImageButton) Button randomImageButton;
	@Bind(R.id.randomImageView) ImageView randomImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alternative1);

		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
	}

	//Now this implementation is thread-safe: the network operation is done from a separate thread while the ImageView is manipulated from the UI thread.
	//However, as the complexity of the operation grows, this kind of code can get complicated and difficult to maintain.
	//To handle more complex interactions with a worker thread, you might consider using a ``Handler`` in your worker thread, to process messages delivered from the UI thread.
	//Perhaps the best solution, though, is to extend the AsyncTask class, which simplifies the execution of worker thread tasks that need to interact with the UI.
	//More of these in the next button examples of this application..
	@OnClick(R.id.randomImageButton)
	public void getRandomImage(View v) {
		Log.d(TAG, "In getRandomImage(..)");
		new Thread(new Runnable() {
			@Override
			public void run() {
				final Bitmap image = loadImageFromNetwork(URL_RANDOM_IMAGE);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						randomImageView.setImageBitmap(image);
					}
				});
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
