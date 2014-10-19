package edu.drake.project2;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import edu.drake.project2.R;
import java.io.*;

public class StoryName extends ActionBarActivity {
	
	public void sendMessage(View view) throws FileNotFoundException{
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("transfer");
				
		EditText text = (EditText)findViewById(R.id.storyName);
		String storyName = text.getText().toString();
		//EditText text1 = (EditText)findViewById(R.id.name);
		//String name = text1.getText().toString();
		String filename = storyName + " by " + name;
		saveFile(filename); //get concatenated file and filename and save it in device
		
		Intent intent1 = new Intent(this,MyLibrary.class);		
		startActivity(intent1);
	}	
	
	public void saveFile(String filename) throws FileNotFoundException
	{
		InputStream x=getResources().openRawResource(R.raw.try1);
		InputStream y=getResources().openRawResource(R.raw.try1);
		SequenceInputStream z = concatenate(x,y);
		
		String outputFile = Environment.getExternalStorageDirectory()+"/"+filename+".3gp";
		File outFile = new File(outputFile);
		
		FileOutputStream fos = new FileOutputStream(outFile);

        int temp;

        try {
            while ((temp = z.read())!= -1){

                fos.write(temp);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}
	
	public SequenceInputStream concatenate(InputStream x, InputStream y)
	{
		SequenceInputStream z = new SequenceInputStream(x,y);
		return z;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story_name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.story_name, menu);
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


