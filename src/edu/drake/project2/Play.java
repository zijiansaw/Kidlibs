package edu.drake.project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Vector;

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
   	Vector <String> files;
    MediaPlayer mediaPlayer;
    Story story;


	public void sendMessage(View view){
		Intent intent = new Intent(this, Name.class);
		startActivity(intent);
	}
	
	
	
	public void playAll(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
	{
		audioindex=1;
		mediaPlayer =  new MediaPlayer();
		mediaPlayer.setDataSource(files.get(0));
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
		    			mediaPlayer.setDataSource(files.get(audioindex));
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
		
		// hide the action bar
        getActionBar().hide();
		
        
		story = (Story) getIntent().getSerializableExtra("story");
	    
	    //setup the vector of filenames to play
	    //TODO: Fix the one story that starts with a response, not a prompt.
	    //TODO: Also record a snippet of silence to set as beach1_3, change beach1_3 and beach1_4
	    
						//Larry's code
						String cache0 = null,cache1 = null,cache2=null,cache3=null,cache4=null,cache5=null,cache6=null;
						InputStream x0=getResources().openRawResource(story.promptFileNames.get(0));
						InputStream x1=getResources().openRawResource(story.promptFileNames.get(1));
						InputStream x2=getResources().openRawResource(story.promptFileNames.get(2));
						InputStream x3=getResources().openRawResource(story.promptFileNames.get(3));
						InputStream x4=getResources().openRawResource(story.promptFileNames.get(4));
						try {
							saveFile(cache0,x0);
							saveFile(cache1,x1);
							saveFile(cache2,x2);
							saveFile(cache3,x3);
							saveFile(cache4,x4);
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache0.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/res0.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache1.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/res1.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache2.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/res2.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache3.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/res3.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache4.3gp");
		files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/res4.3gp");
		if(story.promptFileNames.size()>5 || story.promptFileNames.size() == 5 )
		{
			InputStream x5=getResources().openRawResource(story.promptFileNames.get(0));
			try {
				saveFile(cache5,x5);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			files.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache5.3gp");
		}
		
	    
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
            
            Toast.makeText(this, "Save inputstream as "+ filename+"!!", Toast.LENGTH_LONG).show();
            
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
