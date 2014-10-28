package edu.drake.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Category extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		
		//create buttons and onClickListeners for each categories
		Button beachBtn = (Button) findViewById(R.id.button3);
		Button safariBtn = (Button) findViewById(R.id.button5);
		Button spaceBtn = (Button) findViewById(R.id.button4);
		Button sportsBtn = (Button) findViewById(R.id.button1);
		Button zooBtn = (Button) findViewById(R.id.button2);

		beachBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 0);
				startActivity(intent);
			}
			
		});
		safariBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 1);
				startActivity(intent);
			}
			
		});
		spaceBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 2);
				startActivity(intent);
			}
			
		});
		sportsBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), SayNoun.class);
				intent.putExtra("category", 3);
				startActivity(intent);
			}
			
		});
		zooBtn.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
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
