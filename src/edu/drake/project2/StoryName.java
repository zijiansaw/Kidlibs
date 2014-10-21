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
import android.widget.Toast;
import edu.drake.project2.R;

import java.io.*;
import java.net.URL;

public class StoryName extends ActionBarActivity {
	
	public void sendMessage(View view) throws IOException{
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("transfer");
				
		EditText text = (EditText)findViewById(R.id.storyName);
		String storyName = text.getText().toString();
		//EditText text1 = (EditText)findViewById(R.id.name);
		//String name = text1.getText().toString();
		String filename = storyName + " by " + name;
		
		InputStream x= getResources().openRawResource(R.raw.try1);
		InputStream y= getResources().openRawResource(R.raw.try2);
		
		saveFile("first",x);
		saveFile("second",y);
		
		//String x1=Environment.getExternalStorageDirectory()+"/first.3gp";
		//String y1=Environment.getExternalStorageDirectory()+"/second.3gp";
		
		//saveMergeFile(filename,x,y); //get concatenated file and filename and save it in device
		//CombineWaveFile(filename,x1,y1);
		
		
		Intent intent1 = new Intent(this,MyLibrary.class);		
		startActivity(intent1);
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
	
	//I can't figure out why it doesn't write from the second audio file 
	public void saveMergeFile(String filename,InputStream...files) throws FileNotFoundException
	{
		
		SequenceInputStream z = new SequenceInputStream(files[1],files[0]);
		String outputFile = Environment.getExternalStorageDirectory()+"/"+filename+".3gp";
		File outFile = new File(outputFile);
		
		FileOutputStream fos = new FileOutputStream(outFile);

        byte[] data = new byte[1024];
        try {
        	    
        	for (int readNum; (readNum = z.read(data)) != -1;)
        	{
        		fos.write(data, 0, readNum);
        	}
        	
        	/*
        	for (int readNum; (readNum = files[0].read(data)) != -1;)
        	{
        		fos.write(data, 0, readNum);
        	}
        	for (int readNum; (readNum = files[1].read(data)) != -1;)
        	{
        		fos.write(data, 0, readNum);
        	}
        	*/
        	
        	files[1].close();                 
            files[0].close();
            z.close();
            fos.close();
            
            Toast.makeText(this, "Done!!", Toast.LENGTH_LONG).show();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}

	//These two methods below may work but I can't confirm it yet
	public void CombineWaveFile(String filename, String file1, String file2) 
	 {
	  
	     FileInputStream in1 = null, in2 = null;
	     final int RECORDER_BPP=16; //8,16,32..etc
	     int RECORDER_SAMPLERATE=8000; //8000,11025,16000,32000,48000,96000,44100..et
	     FileOutputStream out = null;
	     long totalAudioLen = 0;
	     long totalDataLen = totalAudioLen + 36;
	     long longSampleRate = RECORDER_SAMPLERATE;
	     int channels = 1;  //mono=1,stereo=2
	     long byteRate = RECORDER_BPP * RECORDER_SAMPLERATE * channels / 8;

	     int bufferSize=1024;
	     byte[] data = new byte[bufferSize];


	     try {
	         in1 = new FileInputStream(file1);
	         in2 = new FileInputStream(file2);
	         
	       
	         out = new FileOutputStream(new File(Environment.getExternalStorageDirectory()+"/"+filename+".3gp"));

	         totalAudioLen = in1.getChannel().size() + in2.getChannel().size();
	         
	         totalDataLen = totalAudioLen + 36;

	         WriteWaveFileHeader(out, totalAudioLen, totalDataLen,
	         longSampleRate, channels, byteRate,RECORDER_BPP);

	         while (in1.read(data) != -1) 
	               {

	             out.write(data);

	         }
	         while (in2.read(data) != -1)
	              {

	             out.write(data);
	         }

	         out.close();
	         in1.close();
	         in2.close();
	         
	         bufferSize=1024;
	         data = new byte[bufferSize];
	         out.close();
	         out.flush();

	     Toast.makeText(this, "Done!!", Toast.LENGTH_LONG).show();
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	
	private void WriteWaveFileHeader(FileOutputStream out, long totalAudioLen,
	 long totalDataLen, long longSampleRate, int channels, long byteRate, int RECORDER_BPP)
	 throws IOException 
	 {
	
	     byte[] header = new byte[44];
	
	     header[0] = 'R';
	     header[1] = 'I';
	     header[2] = 'F';
	     header[3] = 'F';
	     header[4] = (byte)(totalDataLen & 0xff);
	     header[5] = (byte)((totalDataLen >> 8) & 0xff);
	     header[6] = (byte)((totalDataLen >> 16) & 0xff);
	     header[7] = (byte)((totalDataLen >> 24) & 0xff);
	     header[8] = 'W';
	     header[9] = 'A';
	     header[10] = 'V';
	     header[11] = 'E';
	     header[12] = 'f';
	     header[13] = 'm';
	     header[14] = 't';
	     header[15] = ' ';
	     header[16] = 16;
	     header[17] = 0;
	     header[18] = 0;
	     header[19] = 0;
	     header[20] = 1;
	     header[21] = 0;
	     header[22] = (byte) channels;
	     header[23] = 0;
	     header[24] = (byte)(longSampleRate & 0xff);
	     header[25] = (byte)((longSampleRate >> 8) & 0xff);
	     header[26] = (byte)((longSampleRate >> 16) & 0xff);
	     header[27] = (byte)((longSampleRate >> 24) & 0xff);
	     header[28] = (byte)(byteRate & 0xff);
	     header[29] = (byte)((byteRate >> 8) & 0xff);
	     header[30] = (byte)((byteRate >> 16) & 0xff);
	     header[31] = (byte)((byteRate >> 24) & 0xff);
	     header[32] = (byte)(2 * 16 / 8);
	     header[33] = 0;
	     header[34] = (byte) RECORDER_BPP;
	     header[35] = 0;
	     header[36] = 'd';
	     header[37] = 'a';
	     header[38] = 't';
	     header[39] = 'a';
	     header[40] = (byte)(totalAudioLen & 0xff);
	     header[41] = (byte)((totalAudioLen >> 8) & 0xff);
	     header[42] = (byte)((totalAudioLen >> 16) & 0xff);
	     header[43] = (byte)((totalAudioLen >> 24) & 0xff);
	
	     out.write(header, 0, 44);
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


