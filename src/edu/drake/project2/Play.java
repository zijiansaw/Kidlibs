package edu.drake.project2;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Play extends ActionBarActivity {
	
	Button playBtn;
    Button pauseBtn;
    int audioindex;
    String[] files = {Environment.getExternalStorageDirectory().getAbsolutePath() + "/res0.3gp",
    		Environment.getExternalStorageDirectory().getAbsolutePath() + "/res1.3gp",
    		Environment.getExternalStorageDirectory().getAbsolutePath() + "/res2.3gp",
    		Environment.getExternalStorageDirectory().getAbsolutePath() + "/res3.3gp",
    		Environment.getExternalStorageDirectory().getAbsolutePath() + "/res4.3gp"};
    MediaPlayer mediaPlayer;

	public void sendMessage(View view){
		Intent intent = new Intent(this,Name.class);
		startActivity(intent);
	}	
	
	public void playAll(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
	{
		audioindex=1;
		mediaPlayer =  new MediaPlayer();
		mediaPlayer.setDataSource(files[0]);
		mediaPlayer.prepare();
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener()
		{
		    @Override
		    public void onCompletion(MediaPlayer medi) 
		    {
		    	try {
		    		
		    		mediaPlayer.reset();
		    		if(audioindex==5)
		    		{
		    			mediaPlayer.release();
		                mediaPlayer = null;
		    		}
		    		else
		    		{
		    			mediaPlayer.setDataSource(files[audioindex]);
			    		mediaPlayer.prepare();
			    		mediaPlayer.start();
				    	audioindex+=1;
		    		}
		    		
		    	} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		     }
		});
		
		mediaPlayer.start();
		Toast.makeText(this, "Playing audio.", Toast.LENGTH_LONG).show();

	}	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);	
		//playBtn = (Button) findViewById(R.id.play);
        //pauseBtn = (Button) findViewById(R.id.pause);
        //playBtn.setOnClickListener(this);
        //pauseBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
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

/*
	@Override
	public void onClick(View v) 
	{
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.try2);
		switch (v.getId()) 
		{
        case R.id.play:
        	
    		mediaPlayer.start();
    		Toast.makeText(this, "Playing audio.", Toast.LENGTH_LONG).show();
            playBtn.setVisibility(Button.GONE);
            pauseBtn.setVisibility(Button.VISIBLE);
            break;
        case R.id.pause:
    		mediaPlayer.stop();
    		Toast.makeText(this, "Playing audio.", Toast.LENGTH_LONG).show();
            pauseBtn.setVisibility(Button.GONE);
            playBtn.setVisibility(Button.VISIBLE);
            break;
        }
	    
		
	}
	*/
}
