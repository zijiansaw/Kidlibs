package edu.drake.project2;



import java.util.Vector;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SayNoun extends ActionBarActivity {
	private String outputFile0, outputFile1, outputFile2, outputFile3, outputFile4, storyOutputFile = null;
	private MediaRecorder myAudioRecorder;
	Vector <String> outputFileNames = new Vector <String>();
	int i=0, numPrompts=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_say_noun);

		int category = getIntent().getIntExtra("category", -1);

		//check to see if category was passed correctly
		if(category <0){
			System.out.println("category not passed correctly");
		}

		//Pull a random story from category
		Story story = new Story(category);
		numPrompts= story.myPromptList.size();
		

		TextView txtLabel = (TextView)findViewById(R.id.textView1);

		//create the 5 hard-coded output file names. 
		outputFile0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res0.3gp";;
		outputFile1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res1.3gp";;
		outputFile2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res2.3gp";;
		outputFile3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res3.3gp";;
		outputFile4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/res4.3gp";;

		outputFileNames.add(outputFile0);
		outputFileNames.add(outputFile1);
		outputFileNames.add(outputFile2);
		outputFileNames.add(outputFile3);
		outputFileNames.add(outputFile4);


		Button micBtn = (Button) findViewById(R.id.micBtn);
		micBtn.setEnabled(false);

		//set up the audioRecorder
		myAudioRecorder = new MediaRecorder();
		myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

		//main game loop.

		//set the text of the label to be the given prompt
		txtLabel.setText(story.myPromptList.get(i).getPromptString());

		//TODO: Add the audio playback if the label is touched (make it a btn eventually)

		//if the microphone btn is pressed, record for 2 seconds. 

		micBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				//set output file
				myAudioRecorder.setOutputFile(outputFileNames.get(i));

				//change image

				//record

			}
		});

	}

	public void next(View view){
		if(i<numPrompts){
			i++;
		}
		else{
			//create the storyOutputFile
			storyOutputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/story.3gp";;
			
			//concatenate the strings here
			
			//go to the play my story screen
			Intent intent = new Intent(getApplicationContext(), Play.class);
			intent.putExtra("storyPath", storyOutputFile);
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







