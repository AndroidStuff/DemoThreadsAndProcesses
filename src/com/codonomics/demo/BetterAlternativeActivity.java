package com.codonomics.demo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BetterAlternativeActivity extends Activity {
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

	// Using AsyncTask
	// AsyncTask allows you to perform asynchronous work on your user interface.
	// It performs the blocking operations in a worker thread and then publishes the results on the UI thread,
	// without requiring you to handle threads and/or handlers yourself.
	@OnClick(R.id.randomImageButton)
	public void getRandomImage(View v) {
		Log.d(TAG, "In getRandomImage(..)");
		new DownloadImageAsyncTask().execute(URL_RANDOM_IMAGE);
	}

	// Caution: Another problem you might encounter when using a worker thread is unexpected restarts in your activity
	// due to a runtime configuration change (such as when the user changes the screen orientation), which may destroy your worker thread.
	// To see how you can persist your task during one of these restarts and
	// how to properly cancel the task when the activity is destroyed,
	// see the source code for the Shelves[http://code.google.com/p/shelves/] sample application.
	private class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

		// The system calls this to perform work in a worker thread and
		// delivers it the parameters given to AsyncTask.execute()
		@Override
		protected Bitmap doInBackground(String... urls) {
			return loadImageFromNetwork(urls[0]);
		}

		// The system calls this to perform work in the UI thread and
		// delivers the result from doInBackground() method defined above
		@Override
		protected void onPostExecute(Bitmap image) {
			randomImageView.setImageBitmap(image);
		}
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
