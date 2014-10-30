package edu.drake.project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Vector;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Play extends ActionBarActivity {
	
	ImageButton playBtn;
    ImageButton pauseBtn;
    int audioindex;
   	String[] files=new String[11];
    MediaPlayer mediaPlayer;
    Story story;
    Vector <Integer> promptFileNames = new Vector<Integer>();
    int length;
    boolean x=false;


	
	
	public void sendMessage2(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void inTheNewVersion(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Play.this);
        // Setting Dialog Title
        alertDialog.setTitle("Can't save?");
        // Setting Dialog Message
        alertDialog.setMessage("The saving option will only be included in Version 2.0. Sorry about this.");
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.exit_icon);
        alertDialog.show();
	}
	
	
	public void playAll(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
	{
		if(x==false)
		{
			playBtn.setVisibility(View.INVISIBLE);
			pauseBtn.setVisibility(View.VISIBLE);
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
			    		if(audioindex==11)
			    		{
			    			mediaPlayer.release();
			                mediaPlayer = null;
			                playBtn.setVisibility(View.VISIBLE);
			                pauseBtn.setVisibility(View.INVISIBLE);
			                message("THE END.");
			                x=false;
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
			Toast.makeText(this, "Playing story.", Toast.LENGTH_LONG).show();
		}
		else
		{
			mediaPlayer.seekTo(length);
			mediaPlayer.start();
			message("Story continues...");
			playBtn.setVisibility(View.INVISIBLE);
			pauseBtn.setVisibility(View.VISIBLE);
		}

	}
	
	public void pause(View view)
	{
		
		
		mediaPlayer.pause();
		message("Story paused.");
		length=mediaPlayer.getCurrentPosition();
		x=true;
		playBtn.setVisibility(View.VISIBLE);
        pauseBtn.setVisibility(View.INVISIBLE);
		
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);	
		
		playBtn = (ImageButton) findViewById(R.id.imageButton1);
		pauseBtn = (ImageButton) findViewById(R.id.imageButton2);
		
		// hide the action bar
        getActionBar().hide();
        
        int category = getIntent().getIntExtra("storyCategory", -1);
      
        int storyNum = getIntent().getIntExtra("storyNum", -1);
        
        //message("category "+category+" story num: "+storyNum);
        if(storyNum<0 || category < 0){
        	message("story num was not passed correctly");
        }
	    
	    //setup the vector of filenames to play
	    //TODO: Fix the one story that starts with a response, not a prompt.
	    //TODO: Also record a snippet of silence to set as beach1_3, change beach1_3 and beach1_4
	    
		//Larry's code
        promptFileNames.clear();
        getStory(category, storyNum);
		InputStream x0=getResources().openRawResource(promptFileNames.get(0));
		InputStream x1=getResources().openRawResource(promptFileNames.get(1));
		InputStream x2=getResources().openRawResource(promptFileNames.get(2));
		InputStream x3=getResources().openRawResource(promptFileNames.get(3));
		InputStream x4=getResources().openRawResource(promptFileNames.get(4));
		InputStream x5=getResources().openRawResource(promptFileNames.get(5));
		try {
			saveFile("cache0",x0);
			saveFile("cache1",x1);
			saveFile("cache2",x2);
			saveFile("cache3",x3);
			saveFile("cache4",x4);
			saveFile("cache5",x5);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		files[0]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache0.3gp";
		files[1]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/res0.3gp";
		files[2]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache1.3gp";
		files[3]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/res1.3gp";
		files[4]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache2.3gp";
		files[5]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/res2.3gp";
		files[6]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache3.3gp";
		files[7]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/res3.3gp";
		files[8]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache4.3gp";
		files[9]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/res4.3gp";
		files[10]=Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache5.3gp";
	}
	//method for showing message to user
	public void message(String message){
		Context context = getApplicationContext();
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	public void saveFile(String filename,InputStream z) throws FileNotFoundException
	{
		String outputFile = Environment.getExternalStorageDirectory()+"/"+filename+".3gp";
		File outFile = new File(outputFile);
		
		FileOutputStream fos = new FileOutputStream(outFile);

        byte[] data = new byte[1024];
        try {
        	    
        	for (int readNum; (readNum = z.read(data)) != -1;)
        	{
        		fos.write(data, 0, readNum);
        	}
            z.close();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	@Override
	public void onPause(){
		if(mediaPlayer != null){
			mediaPlayer.pause();
			mediaPlayer.stop();
		}
		super.onPause();
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

	void getStory(int cat, int num){
		if(cat == 0){
			if(num ==0){

				promptFileNames.add(R.raw.beach1_1);
				promptFileNames.add(R.raw.beach1_2);
				promptFileNames.add(R.raw.silent);
				promptFileNames.add(R.raw.beach1_3);
				promptFileNames.add(R.raw.beach1_4);
				promptFileNames.add(R.raw.silent);
				
			}else if (num ==1){

				promptFileNames.add(R.raw.beach2_1);
				promptFileNames.add(R.raw.beach2_2);
				promptFileNames.add(R.raw.beach2_3);
				promptFileNames.add(R.raw.beach2_4);
				promptFileNames.add(R.raw.beach2_5);
				promptFileNames.add(R.raw.silent);
				
			}else if (num ==2){
				promptFileNames.add(R.raw.silent);
				promptFileNames.add(R.raw.beach3_1);
				promptFileNames.add(R.raw.beach3_2);
				promptFileNames.add(R.raw.beach3_3);
				promptFileNames.add(R.raw.beach3_4);
				promptFileNames.add(R.raw.beach3_5);
			}
		}
		else if (cat==1){
			if(num ==0){				
				promptFileNames.add(R.raw.safari1_1);
				promptFileNames.add(R.raw.safari1_2);
				promptFileNames.add(R.raw.safari1_3);
				promptFileNames.add(R.raw.safari1_4);
				promptFileNames.add(R.raw.safari1_5);
				promptFileNames.add(R.raw.safari1_6);
				
			}else if (num ==1){

				promptFileNames.add(R.raw.safari2_1);
				promptFileNames.add(R.raw.safari2_2);
				promptFileNames.add(R.raw.safari2_3);
				promptFileNames.add(R.raw.safari2_4);
				promptFileNames.add(R.raw.safari2_5);
				promptFileNames.add(R.raw.silent);
				
			}else if (num ==2){
				promptFileNames.add(R.raw.safari3_1);
				promptFileNames.add(R.raw.safari3_2);
				promptFileNames.add(R.raw.silent);
				promptFileNames.add(R.raw.safari3_3);
				promptFileNames.add(R.raw.safari3_4);
				promptFileNames.add(R.raw.safari3_5);
			}
		}
		else if (cat==2){
			if(num ==0){

				promptFileNames.add(R.raw.space1_1);
				promptFileNames.add(R.raw.space1_2);
				promptFileNames.add(R.raw.space1_3);
				promptFileNames.add(R.raw.space1_4);
				promptFileNames.add(R.raw.space1_5);
				promptFileNames.add(R.raw.space1_6);
				
			}else if (num ==1){

				promptFileNames.add(R.raw.space2_1);
				promptFileNames.add(R.raw.space2_2);
				promptFileNames.add(R.raw.space2_3);
				promptFileNames.add(R.raw.space2_4);
				promptFileNames.add(R.raw.space2_5);
				promptFileNames.add(R.raw.space2_6);
			}else if (num ==2){

				promptFileNames.add(R.raw.space3_1);
				promptFileNames.add(R.raw.space3_2);
				promptFileNames.add(R.raw.space3_3);
				promptFileNames.add(R.raw.space3_4);
				promptFileNames.add(R.raw.space3_5);
				promptFileNames.add(R.raw.space3_6);
			}
		}
		else if(cat ==3){
			if(num ==0){

				promptFileNames.add(R.raw.sports1_1);
				promptFileNames.add(R.raw.sports1_2);
				promptFileNames.add(R.raw.sports1_3);
				promptFileNames.add(R.raw.sports1_4);
				promptFileNames.add(R.raw.sports1_5);
				promptFileNames.add(R.raw.silent);
			}else if (num ==1){
				promptFileNames.add(R.raw.sports2_1);
				promptFileNames.add(R.raw.sports2_2);
				promptFileNames.add(R.raw.sports2_3);
				promptFileNames.add(R.raw.sports2_4);
				promptFileNames.add(R.raw.sports2_5);
				promptFileNames.add(R.raw.silent);
				
			}else if (num ==2){
				promptFileNames.add(R.raw.sports3_1);
				promptFileNames.add(R.raw.sports3_2);
				promptFileNames.add(R.raw.sports3_3);
				promptFileNames.add(R.raw.sports3_4);
				promptFileNames.add(R.raw.sports3_5);
				promptFileNames.add(R.raw.silent);
			}
		}
		else if (cat==4){
			if(num ==0){

				promptFileNames.add(R.raw.zoo1_1);
				promptFileNames.add(R.raw.zoo1_2);
				promptFileNames.add(R.raw.zoo1_3);
				promptFileNames.add(R.raw.zoo1_4);
				promptFileNames.add(R.raw.zoo1_5);
				promptFileNames.add(R.raw.silent);
				
			}else if (num ==1){

				promptFileNames.add(R.raw.zoo2_1);
				promptFileNames.add(R.raw.zoo2_2);
				promptFileNames.add(R.raw.zoo2_3);
				promptFileNames.add(R.raw.zoo2_4);
				promptFileNames.add(R.raw.zoo2_5);
				promptFileNames.add(R.raw.zoo2_6);
			}else if (num ==2){
				promptFileNames.add(R.raw.zoo3_1);
				promptFileNames.add(R.raw.zoo3_2);
				promptFileNames.add(R.raw.zoo3_3);
				promptFileNames.add(R.raw.zoo3_4);
				promptFileNames.add(R.raw.zoo3_5);
				promptFileNames.add(R.raw.zoo3_6);
			}
		}
	}
}
