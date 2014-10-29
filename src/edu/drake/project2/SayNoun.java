package edu.drake.project2;



import java.io.IOException;
import java.util.Vector;

import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SayNoun extends ActionBarActivity {

	private static final String LOG_TAG = "Audio Record";
	private String outputFile0, outputFile1, outputFile2, outputFile3, outputFile4, storyOutputFile, outputFileName = null;
	private MediaRecorder myAudioRecorder;
	Vector <String> outputFileNames = new Vector <String>();
	int i=0, numPrompts=0, storyNum;
	Story story;
	TextView txtLabel;
	int category;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		message("in onCreate of SayNoun");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_say_noun);

		int category = getIntent().getIntExtra("category", -1);

		//check to see if category was passed correctly
		if(category <0){
			System.out.println("category not passed correctly");
		}

		//Pull a random story from category
		story = new Story(category);
		numPrompts= story.myPromptList.size();
		storyNum = story.storyNum;

		//Set the text of the label to the given prompt
		txtLabel = (TextView)findViewById(R.id.textView1);
		txtLabel.setText(story.myPromptList.get(i).getPromptString());
		message("Prompt text view set");

		setUpAudio();

		//set up timer and mic button
		ImageButton micBtn = (ImageButton) findViewById(R.id.imageButton1);

		micBtn.setOnClickListener( new OnClickListener() {


			@Override
			public void onClick(View arg0) {

				startRecording();
				//stops recording after 3 seconds and call the next method.
				try {
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							stopRecording();
							next();
						}
					}, 3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startRecording(){
		//start recording
		myAudioRecorder = new MediaRecorder();
		Log.i("Audio", "created myAudioRecorder");
		myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		Log.i("Audio", "set the source to Mic");
		myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		Log.i("Audio", "set the outputFormat");
		myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		myAudioRecorder.setOutputFile(outputFileName);
		try{
			myAudioRecorder.prepare();
		}
		catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}
		myAudioRecorder.start(); 
		message("Started Recording"); 
	}

	//stops the recording
	public void stopRecording(){
		myAudioRecorder.stop();
		myAudioRecorder.release();
		myAudioRecorder  = null;
		//display message to confirm recording has stopped
	}

	//method for showing message to user
	public void message(String message){
		Context context = getApplicationContext();
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	public void setUpAudio(){
		//create the 5 hard-coded output file names. 
		Log.i("Audio", "inside the audio start method");
		outputFile0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res0.3gp";;
		outputFile1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res1.3gp";;
		outputFile2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res2.3gp";;
		outputFile3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res3.3gp";;
		outputFile4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res4.3gp";;

		outputFileName = outputFile0;

		Log.i("Audio", "Created the output files");
		outputFileNames.add(outputFile0);
		outputFileNames.add(outputFile1);
		outputFileNames.add(outputFile2);
		outputFileNames.add(outputFile3);
		outputFileNames.add(outputFile4);
		Log.i("Audio", "Added the outputFiles to the vector");

	}

	public void next(){
		ImageView image = (ImageView) findViewById(R.id.progress);
		int progress[] = {getResources().getIdentifier("drawable/dog3", null, getPackageName()),
				getResources().getIdentifier("drawable/dog4", null, getPackageName()),
				getResources().getIdentifier("drawable/dog5", null, getPackageName()),
				getResources().getIdentifier("drawable/dog6", null, getPackageName())};

		if(i<4){
			i++;
			txtLabel.setText(story.myPromptList.get(i).getPromptString());
			outputFileName = outputFileNames.elementAt(i);
			image.setImageResource(progress[i-1]);
		}
		else{
			Log.i("next", "in the else statment");

			//go to the play my story screen
			Intent intent = new Intent(getApplicationContext(), Play.class);

			intent.putExtra("storyNum", storyNum);
			intent.putExtra("storyCategory", category);
			startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.say_noun, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
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







