package edu.drake.project2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Category extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//message("created Category screen");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		
		//create buttons and onClickListeners for each categories
		ImageButton beachBtn = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton safariBtn = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton spaceBtn = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton sportsBtn = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton zooBtn = (ImageButton) findViewById(R.id.imageButton5);

		beachBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 0);
				//message("category 0, intent set up");
				startActivity(intent);
			}
			
		});
		safariBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 1);
				startActivity(intent);
			}
			
		});
		spaceBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 2);
				startActivity(intent);
			}
			
		});
		sportsBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 3);
				startActivity(intent);
			}
			
		});
		zooBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 4);
				startActivity(intent);
			}
			
		});
		// hide the action bar
        getActionBar().hide();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category, menu);
		return true;
	}
	//method for showing message to user
	public void message(String message){
		Context context = getApplicationContext();
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
