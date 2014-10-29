package edu.drake.project2;

import java.io.Serializable;
import java.util.Vector;

//So essentially when you create a story, you create a list of prompts, and then iterate through the list to play the game. 
//need to work on adding the audio, as well as output files for the 
public class Story implements Serializable {

	/**
	 * Each story should just be a list of prompts
	 */
	Vector <Prompt> myPromptList = new Vector<Prompt>();
	Vector <Integer> promptFileNames = new Vector<Integer>();
	Vector <String> commandFileNames = new Vector<String>();
	int storyNum = 0;
	public int category;
	

	/**
	 * Constructs a story based on the category that is chosen
	 * @param cat
	 */
	public Story(int cat, int num){
		category = cat;
		storyNum = num;
		

	}
	public Story(int cat){
		Story story = new Story(cat, getRandomStoryNum());
		
	}

	

	/**
	 * 
	 *Chooses a random story to play from the category
	 *
	 * 1= beach
	 * 2= Safari
	 * 3=Space
	 * 4= Sports
	 * 5=Zoo
	 */
	
	public int getRandomStoryNum(){
		 int rand =  (int)(Math.random()*3);
		 storyNum= rand;
		 return storyNum;
	}



}
