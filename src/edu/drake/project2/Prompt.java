package edu.drake.project2;

public class Prompt {
	public String prompt;
	public int ndx;
	//audio file input
	//audio file output

	//eventually should create an exception for if that i is already taken,
	//also should make it part of a loop instead of hard coding it in.
	//also should allow an audio file to be passed in as an argument.
	/**
	 * Sets the prompt to the arguments given to it
	 * @param whatTheyShouldSay
	 * @param i
	 */
	public Prompt(String whatTheyShouldSay, int i){
		prompt = whatTheyShouldSay;
		ndx = i; 
	}
	/**
	 * Sets prompt to have the string that is passed in
	 * @param whatTheyShouldSay
	 */
	public void setPrompt(String whatTheyShouldSay){
		prompt = whatTheyShouldSay;
	}
	/**
	 * Sets prompt to have the index passed in
	 * @param i
	 */
	public void setPrompt(int i){
		ndx = i;
	}
	/**
	 * Returns the index of a given prompt
	 * @return int
	 */
	public int getNdx(){
		return ndx;
	}
	/**
	 * Returns the String associated with a given prompt
	 * @return String 
	 */
	public String getPromptString(){
		return prompt;
	}
	
}

