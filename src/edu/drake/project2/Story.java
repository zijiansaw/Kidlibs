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
	Vector <String> promptFileNames = new Vector<String>();
	Vector <String> commandFileNames = new Vector<String>();
	public int category;
	
	/**
	 * Constructs a story based on the category that is chosen
	 * @param cat
	 */
	public Story(int cat){
		category = cat;
		getRandomStory();
	}
	/**
	 * If you ever need to manually add a prompt to a story
	 * @param p
	 */
	public void addPrompt(Prompt p){
		myPromptList.add(p);
	}
	
	/**
	 * Sets the category with an integer. Also has an awesome cat :)
	 * 1= beach
	 * 2= Safari
	 * 3=Space
	 * 4= Sports
	 * 5=Zoo
	 * @param cat
	 */
	public void setCategory(int cat){
		category = cat; //meow ^    ^ 
						//      o  o
						//    >  <>  <
						//        Y
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
	
	public void getRandomStory(){
		 int rand =  (int)(Math.random()*3);
		//beach
		if(category==0){
			//randomly choose a story from the 4 beach
			 if(rand==0){
				 myPromptList = getStory1();
			 }
			 else if (rand ==1){
				  myPromptList = getStory2();
			 }
			 else if(rand ==2){
				  myPromptList = getStory3();
			 }
		}
		//safari
		else if(category ==1){
			 if(rand==0){
				  myPromptList = getSafariStory1();
			 }
			 else if (rand ==1){
				  myPromptList = getSafariStory2();
			 }
			 else if(rand ==2){
				  myPromptList = getSafariStory3();
			 }
		}
		//space
		else if(category ==2){
			 if(rand==0){
				  myPromptList = getSpaceStory1();
			 }
			 else if (rand ==1){
				  myPromptList = getSpaceStory2();
			 }
			 else if(rand ==2){
				 myPromptList = getSpaceStory3();
			 }
		}
		//sports
		else if(category ==3){
			 if(rand==0){
				 myPromptList = getSportsStory1();
			 }
			 else if (rand ==1){
				  myPromptList = getSportsStory2();
			 }
			 else if(rand ==2){
				  myPromptList = getSportsStory3();
			 }
		}
		//zoo
		else if(category ==4){
			 if(rand==0){
				 myPromptList = getZooStory1();
			 }
			 else if (rand ==1){
				 myPromptList = getZooStory2();
			 }
			 else if(rand ==2){
				 myPromptList = getZooStory3();
			 }
		}
	}
	
	//for the first draft, just hard code the stories into methods here. 
	public Vector<Prompt> getStory1(){
		Prompt prompt1 = new Prompt("Say a furry animal!", 0);
		Prompt prompt2 = new Prompt("Say something you wear when it's cold outside!", 1);
		Prompt prompt3 = new Prompt("Say something you use at school!", 2);
		Prompt prompt4 = new Prompt("Say your favorite flavor of ice cream!", 3);
		Prompt prompt5 = new Prompt("Say an animal that likes the cold!", 4);
		Vector<Prompt> myBeachStory = new Vector<Prompt>();
		commandFileNames.add("raw/beachc1_1");
		commandFileNames.add("raw/beachc1_2");
		commandFileNames.add("raw/beachc1_3");
		commandFileNames.add("raw/beachc1_4");
		commandFileNames.add("raw/beachc1_5");
		
		myBeachStory.add(prompt1);
		myBeachStory.add(prompt2);
		myBeachStory.add(prompt3);
		myBeachStory.add(prompt4);
		myBeachStory.add(prompt5);
		promptFileNames.add("raw/beach1_1.mp3");
		promptFileNames.add("raw/beach1_2.mp3");
		promptFileNames.add("raw/beach1_3.mp3");
		promptFileNames.add("raw/beach1_4.mp3");
		promptFileNames.add("raw/beach1_5.mp3");
		return myBeachStory;
	}
	public Vector<Prompt> getStory2(){
		Prompt prompt1 = new Prompt("Say a vegetable!", 0);
		Prompt prompt2 = new Prompt("Say an ocean animal!", 1);
		Prompt prompt3 = new Prompt("Say a farm animal!", 2);
		Prompt prompt4 = new Prompt("Say a vegetable you don't like!", 3);
		Prompt prompt5 = new Prompt("Say a fruit!", 4);
		Vector<Prompt> myBeachStory = new Vector<Prompt>();
		myBeachStory.add(prompt1);
		myBeachStory.add(prompt2);
		myBeachStory.add(prompt3);
		myBeachStory.add(prompt4);
		myBeachStory.add(prompt5);
		commandFileNames.add("raw/beachc2_1");
		commandFileNames.add("raw/beachc2_2");
		commandFileNames.add("raw/beachc2_3");
		commandFileNames.add("raw/beachc2_4");
		commandFileNames.add("raw/beachc2_5");
		promptFileNames.add("raw/beach2_1.mp3");
		promptFileNames.add("raw/beach2_2.mp3");
		promptFileNames.add("raw/beach2_3.mp3");
		promptFileNames.add("raw/beach2_4.mp3");
		promptFileNames.add("raw/beach2_5.mp3");
		return myBeachStory;
	}
	public Vector<Prompt> getStory3(){
		Prompt prompt1 = new Prompt("Say a color!", 0);
		Prompt prompt2 = new Prompt("Say your favoite kind of sandwich!", 1);
		Prompt prompt3 = new Prompt("Say something you wear when it's warm outside!", 2);
		Prompt prompt4 = new Prompt("Say something cold you like to eat in the summer!", 3);
		Prompt prompt5 = new Prompt("Say a number!", 4);
		Vector<Prompt> myBeachStory = new Vector<Prompt>();
		myBeachStory.add(prompt1);
		myBeachStory.add(prompt2);
		myBeachStory.add(prompt3);
		myBeachStory.add(prompt4);
		myBeachStory.add(prompt5);
		commandFileNames.add("raw/beachc3_1");
		commandFileNames.add("raw/beachc3_2");
		commandFileNames.add("raw/beachc3_3");
		commandFileNames.add("raw/beachc3_4");
		commandFileNames.add("raw/beachc3_5");
		promptFileNames.add("raw/beach3_1.mp3");
		promptFileNames.add("raw/beach3_2.mp3");
		promptFileNames.add("raw/beach3_3.mp3");
		promptFileNames.add("raw/beach3_4.mp3");
		promptFileNames.add("raw/beach3_5.mp3");
		return myBeachStory;
	}
	public Vector<Prompt> getSafariStory1(){
		Prompt prompt1 = new Prompt("Say a color!", 0);
		Prompt prompt2 = new Prompt("Say an ocean animal!", 1);
		Prompt prompt3 = new Prompt("Say a size, like 'big' or 'small'!", 2);
		Prompt prompt4 = new Prompt("Say a number!", 3);
		Prompt prompt5 = new Prompt("Say a color!", 4);
		Vector<Prompt> mySafariStory = new Vector<Prompt>();
		mySafariStory.add(prompt1);
		mySafariStory.add(prompt2);
		mySafariStory.add(prompt3);
		mySafariStory.add(prompt4);
		mySafariStory.add(prompt5);
		
		commandFileNames.add("raw/safaric1_1.mp3");
		commandFileNames.add("raw/safaric1_2.mp3");
		commandFileNames.add("raw/safaric1_3.mp3");
		commandFileNames.add("raw/sarafic1_4.mp3");
		commandFileNames.add("raw/safaric1_5.mp3");
		
		promptFileNames.add("raw/safari1_1.mp3");
		promptFileNames.add("raw/safari1_2.mp3");
		promptFileNames.add("raw/safari1_3.mp3");
		promptFileNames.add("raw/sarafi1_4.mp3");
		promptFileNames.add("raw/safari1_5.mp3");
		return mySafariStory;
	}
	public Vector<Prompt> getSafariStory2(){
		Prompt prompt1 = new Prompt("Say a color!", 0);
		Prompt prompt2 = new Prompt("Say the name of your town!", 1);
		Prompt prompt3 = new Prompt("Say an ocean animal!", 2);
		Prompt prompt4 = new Prompt("Say the name of a dinosaur!", 3);
		Prompt prompt5 = new Prompt("Say a big animal!", 4);
		Vector<Prompt> mySafariStory = new Vector<Prompt>();
		mySafariStory.add(prompt1);
		mySafariStory.add(prompt2);
		mySafariStory.add(prompt3);
		mySafariStory.add(prompt4);
		mySafariStory.add(prompt5);
		
		commandFileNames.add("raw/safaric2_1.mp3");
		commandFileNames.add("raw/safaric2_2.mp3");
		commandFileNames.add("raw/safaric2_3.mp3");
		commandFileNames.add("raw/sarafic2_4.mp3");
		commandFileNames.add("raw/safaric2_5.mp3");
		
		promptFileNames.add("raw/safari2_1.mp3");
		promptFileNames.add("raw/safari2_2.mp3");
		promptFileNames.add("raw/safari2_3.mp3");
		promptFileNames.add("raw/sarafi2_4.mp3");
		promptFileNames.add("raw/safari2_5.mp3");
		
		return mySafariStory;
	}
	public Vector<Prompt> getSafariStory3(){
		Prompt prompt1 = new Prompt("Say a kind of frosting!", 0);
		Prompt prompt2 = new Prompt("Say a vegetable!", 1);
		Prompt prompt3 = new Prompt("Say a type of fruit!", 2);
		Prompt prompt4 = new Prompt("Say a number!", 3);
		Prompt prompt5 = new Prompt("Say a color!", 4);
		Vector<Prompt> mySafariStory = new Vector<Prompt>();
		mySafariStory.add(prompt1);
		mySafariStory.add(prompt2);
		mySafariStory.add(prompt3);
		mySafariStory.add(prompt4);
		mySafariStory.add(prompt5);
		
		commandFileNames.add("raw/safaric3_1.mp3");
		commandFileNames.add("raw/safaric3_2.mp3");
		commandFileNames.add("raw/safaric3_3.mp3");
		commandFileNames.add("raw/sarafic3_4.mp3");
		commandFileNames.add("raw/safaric3_5.mp3");
		
		promptFileNames.add("raw/safari3_1.mp3");
		promptFileNames.add("raw/safari3_2.mp3");
		promptFileNames.add("raw/safari3_3.mp3");
		promptFileNames.add("raw/sarafi3_4.mp3");
		promptFileNames.add("raw/safari3_5.mp3");
		return mySafariStory;
	}	
	public Vector<Prompt> getSpaceStory1(){
		Prompt prompt1 = new Prompt("Say a kind of ice cream!", 0);
		Prompt prompt2 = new Prompt("Say a color!", 1);
		Prompt prompt3 = new Prompt("Say a yellow animal!", 2);
		Prompt prompt4 = new Prompt("Say a type of fruit!", 3);
		Prompt prompt5 = new Prompt("Say something you use at the dinner table!", 4);
		Vector<Prompt> mySpaceStory = new Vector<Prompt>();
		mySpaceStory.add(prompt1);
		mySpaceStory.add(prompt2);
		mySpaceStory.add(prompt3);
		mySpaceStory.add(prompt4);
		mySpaceStory.add(prompt5);
		
		commandFileNames.add("raw/spacec1_1.mp3");
		commandFileNames.add("raw/spacec1_2.mp3");
		commandFileNames.add("raw/spacec1_3.mp3");
		commandFileNames.add("raw/spacec1_4.mp3");
		commandFileNames.add("raw/spacec1_5.mp3");
		
		promptFileNames.add("raw/space1_1.mp3");
		promptFileNames.add("raw/space1_2.mp3");
		promptFileNames.add("raw/space1_3.mp3");
		promptFileNames.add("raw/space1_4.mp3");
		promptFileNames.add("raw/space1_5.mp3");
		return mySpaceStory;
	}
	public Vector<Prompt> getSpaceStory2(){
		Prompt prompt1 = new Prompt("Name a planet", 0);
		Prompt prompt2 = new Prompt("Say your name!", 1);
		Prompt prompt3 = new Prompt("Say a color!", 2);
		Prompt prompt4 = new Prompt("Say your favorite candy!", 3);
		Prompt prompt5 = new Prompt("Say a color!", 4);
		Vector<Prompt> mySpaceStory = new Vector<Prompt>();
		mySpaceStory.add(prompt1);
		mySpaceStory.add(prompt2);
		mySpaceStory.add(prompt3);
		mySpaceStory.add(prompt4);
		mySpaceStory.add(prompt5);
		
		commandFileNames.add("raw/spacec2_1.mp3");
		commandFileNames.add("raw/spacec2_2.mp3");
		commandFileNames.add("raw/spacec2_3.mp3");
		commandFileNames.add("raw/spacec2_4.mp3");
		commandFileNames.add("raw/spacec2_5.mp3");
		
		promptFileNames.add("raw/space2_1.mp3");
		promptFileNames.add("raw/space2_2.mp3");
		promptFileNames.add("raw/space2_3.mp3");
		promptFileNames.add("raw/space2_4.mp3");
		promptFileNames.add("raw/space2_5.mp3");
		return mySpaceStory;
	}
	public Vector<Prompt> getSpaceStory3(){
		Prompt prompt1 = new Prompt("Say the name of your town!", 0);
		Prompt prompt2 = new Prompt("Say a planet!", 1);
		Prompt prompt3 = new Prompt("Say your name!", 2);
		Prompt prompt4 = new Prompt("Say a vegetable!", 3);
		Prompt prompt5 = new Prompt("Say another planet!", 4);
		Vector<Prompt> mySpaceStory = new Vector<Prompt>();
		mySpaceStory.add(prompt1);
		mySpaceStory.add(prompt2);
		mySpaceStory.add(prompt3);
		mySpaceStory.add(prompt4);
		mySpaceStory.add(prompt5);
		
		commandFileNames.add("raw/spacec2_1.mp3");
		commandFileNames.add("raw/spacec2_2.mp3");
		commandFileNames.add("raw/spacec2_3.mp3");
		commandFileNames.add("raw/spacec2_4.mp3");
		commandFileNames.add("raw/spacec2_5.mp3");
		
		promptFileNames.add("raw/space3_1.mp3");
		promptFileNames.add("raw/space3_2.mp3");
		promptFileNames.add("raw/space3_3.mp3");
		promptFileNames.add("raw/space3_4.mp3");
		promptFileNames.add("raw/space3_5.mp3");
		return mySpaceStory;
	}
	public Vector<Prompt> getSportsStory1(){
		Prompt prompt1 = new Prompt("Say the name of a bug", 0);
		Prompt prompt2 = new Prompt("Say your favorite cartoon character!", 1);
		Prompt prompt3 = new Prompt("Say a vegetable!", 2);
		Prompt prompt4 = new Prompt("Say a place!", 3);
		Prompt prompt5 = new Prompt("Say a soft animal!", 4);
		Vector<Prompt> mySportsStory = new Vector<Prompt>();
		mySportsStory.add(prompt1);
		mySportsStory.add(prompt2);
		mySportsStory.add(prompt3);
		mySportsStory.add(prompt4);
		mySportsStory.add(prompt5);
		
		commandFileNames.add("raw/spacec3_1.mp3");
		commandFileNames.add("raw/spacec3_2.mp3");
		commandFileNames.add("raw/spacec3_3.mp3");
		commandFileNames.add("raw/spacec3_4.mp3");
		commandFileNames.add("raw/spacec3_5.mp3");
		
		promptFileNames.add("raw/sports1_1.mp3");
		promptFileNames.add("raw/sports1_2.mp3");
		promptFileNames.add("raw/sports1_3.mp3");
		promptFileNames.add("raw/sports1_4.mp3");
		promptFileNames.add("raw/sports1_5.mp3");
		return mySportsStory;
	}
	public Vector<Prompt> getSportsStory2(){
		Prompt prompt1 = new Prompt("Say the name of a bug", 0);
		Prompt prompt2 = new Prompt("Say your favorite cartoon character!", 1);
		Prompt prompt3 = new Prompt("Say a vegetable!", 2);
		Prompt prompt4 = new Prompt("Say a place!", 3);
		Prompt prompt5 = new Prompt("Say a soft animal!", 4);
		Vector<Prompt> mySportsStory = new Vector<Prompt>();
		mySportsStory.add(prompt1);
		mySportsStory.add(prompt2);
		mySportsStory.add(prompt3);
		mySportsStory.add(prompt4);
		mySportsStory.add(prompt5);
		
		commandFileNames.add("raw/sportsc1_1.mp3");
		commandFileNames.add("raw/sportsc1_2.mp3");
		commandFileNames.add("raw/sportsc1_3.mp3");
		commandFileNames.add("raw/sporstc1_4.mp3");
		commandFileNames.add("raw/sportsc1_5.mp3");
		
		promptFileNames.add("raw/sports2_1.mp3");
		promptFileNames.add("raw/sports2_2.mp3");
		promptFileNames.add("raw/sports2_3.mp3");
		promptFileNames.add("raw/sports2_4.mp3");
		promptFileNames.add("raw/sports2_5.mp3");
		return mySportsStory;
	}
	public Vector<Prompt> getSportsStory3(){
		Prompt prompt1 = new Prompt("Say something you wear around your neck!", 0);
		Prompt prompt2 = new Prompt("Say a color!", 1);
		Prompt prompt3 = new Prompt("Say sometihng you do at recess!", 2);
		Prompt prompt4 = new Prompt("Say your favorite kind of candy!", 3);
		Prompt prompt5 = new Prompt("Say the name of a superhero!", 4);
		Vector<Prompt> mySportsStory = new Vector<Prompt>();
		mySportsStory.add(prompt1);
		mySportsStory.add(prompt2);
		mySportsStory.add(prompt3);
		mySportsStory.add(prompt4);
		mySportsStory.add(prompt5);
		
		commandFileNames.add("raw/sportsc3_1.mp3");
		commandFileNames.add("raw/sportsc3_2.mp3");
		commandFileNames.add("raw/sportsc3_3.mp3");
		commandFileNames.add("raw/sporstc3_4.mp3");
		commandFileNames.add("raw/sportsc3_5.mp3");
		
		promptFileNames.add("raw/sports3_1.mp3");
		promptFileNames.add("raw/sports3_2.mp3");
		promptFileNames.add("raw/sports3_3.mp3");
		promptFileNames.add("raw/sports3_4.mp3");
		promptFileNames.add("raw/sports3_5.mp3");
		return mySportsStory;
	}
	//not exactly sure this one does the right thing or is ever called.
	public Vector<Prompt> getSportsStory4(){
		Prompt prompt1 = new Prompt("Say a vegetable", 0);
		Prompt prompt2 = new Prompt("Say your favorite ice cream sundae topping!", 1);
		Prompt prompt3 = new Prompt("Say the name of a farm animal!", 2);
		Prompt prompt4 = new Prompt("Say your favoite restaurant!", 3);
		Prompt prompt5 = new Prompt("Say something you use to bake a cake!", 4);
		Vector<Prompt> mySportsStory = new Vector<Prompt>();
		mySportsStory.add(prompt1);
		mySportsStory.add(prompt2);
		mySportsStory.add(prompt3);
		mySportsStory.add(prompt4);
		mySportsStory.add(prompt5);
		
		commandFileNames.add("raw/sportsc1_1.mp3");
		commandFileNames.add("raw/sportsc1_2.mp3");
		commandFileNames.add("raw/sportsc1_3.mp3");
		commandFileNames.add("raw/sporstc1_4.mp3");
		commandFileNames.add("raw/sportsc1_5.mp3");
		
		promptFileNames.add("raw/zoo1_1.mp3");
		promptFileNames.add("raw/zoo1_2.mp3");
		promptFileNames.add("raw/zoo1_3.mp3");
		promptFileNames.add("raw/zoo1_4.mp3");
		promptFileNames.add("raw/zoo1_5.mp3");
		return mySportsStory;
	}
	public Vector<Prompt> getZooStory1(){
		Prompt prompt1 = new Prompt("Say a color", 0);
		Prompt prompt2 = new Prompt("Say a size, like 'small' or 'large'!", 1);
		Prompt prompt3 = new Prompt("Say a vegetable!", 2);
		Prompt prompt4 = new Prompt("Say an ocean animal!", 3);
		Prompt prompt5 = new Prompt("Say something you eat for lunch!", 4);
		Prompt prompt6 = new Prompt("Say the name of a city", 5);
		Vector<Prompt> myZooStory = new Vector<Prompt>();
		myZooStory.add(prompt1);
		myZooStory.add(prompt2);
		myZooStory.add(prompt3);
		myZooStory.add(prompt4);
		myZooStory.add(prompt5);
		myZooStory.add(prompt6);
		
		commandFileNames.add("raw/zooc1_1.mp3");
		commandFileNames.add("raw/zooc1_2.mp3");
		commandFileNames.add("raw/zooc1_3.mp3");
		commandFileNames.add("raw/zooc1_4.mp3");
		commandFileNames.add("raw/zooc1_5.mp3");
		
		promptFileNames.add("raw/zoo1_1.mp3");
		promptFileNames.add("raw/zoo1_2.mp3");
		promptFileNames.add("raw/zoo1_3.mp3");
		promptFileNames.add("raw/zoo1_4.mp3");
		promptFileNames.add("raw/zoo1_5.mp3");
		return myZooStory;
	}
	public Vector<Prompt> getZooStory2(){
		Prompt prompt1 = new Prompt("Say a planet", 0);
		Prompt prompt2 = new Prompt("Say a color!", 1);
		Prompt prompt3 = new Prompt("Say a farm animal!", 2);
		Prompt prompt4 = new Prompt("Say a large number!", 3);
		Prompt prompt5 = new Prompt("Say your name!", 4);
		Vector<Prompt> myZooStory = new Vector<Prompt>();
		myZooStory.add(prompt1);
		myZooStory.add(prompt2);
		myZooStory.add(prompt3);
		myZooStory.add(prompt4);
		myZooStory.add(prompt5);
		
		commandFileNames.add("raw/zooc2_1.mp3");
		commandFileNames.add("raw/zooc2_2.mp3");
		commandFileNames.add("raw/zooc2_3.mp3");
		commandFileNames.add("raw/zooc2_4.mp3");
		commandFileNames.add("raw/zooc2_5.mp3");
		
		promptFileNames.add("raw/zoo2_1.mp3");
		promptFileNames.add("raw/zoo2_2.mp3");
		promptFileNames.add("raw/zoo2_3.mp3");
		promptFileNames.add("raw/zoo2_4.mp3");
		promptFileNames.add("raw/zoo2_5.mp3");
		return myZooStory;
	}
	public Vector<Prompt> getZooStory3(){
		Prompt prompt1 = new Prompt("Say a color", 0);
		Prompt prompt2 = new Prompt("Say your favoite color of ice cream!", 1);
		Prompt prompt3 = new Prompt("Say your favoite kind of Kool-Aid!", 2);
		Prompt prompt4 = new Prompt("Say the name of a vegetable you don't like!", 3);
		Prompt prompt5 = new Prompt("Say what you ate for breakfast this morning!", 4);
		Vector<Prompt> myZooStory = new Vector<Prompt>();
		myZooStory.add(prompt1);
		myZooStory.add(prompt2);
		myZooStory.add(prompt3);
		myZooStory.add(prompt4);
		myZooStory.add(prompt5);
		
		commandFileNames.add("raw/zooc3_1.mp3");
		commandFileNames.add("raw/zooc3_2.mp3");
		commandFileNames.add("raw/zooc3_3.mp3");
		commandFileNames.add("raw/zooc3_4.mp3");
		commandFileNames.add("raw/zooc3_5.mp3");
		
		promptFileNames.add("raw/zoo3_1.mp3");
		promptFileNames.add("raw/zoo3_2.mp3");
		promptFileNames.add("raw/zoo3_3.mp3");
		promptFileNames.add("raw/zoo3_4.mp3");
		promptFileNames.add("raw/zoo3_5.mp3");
		return myZooStory;
	}

	
	

}
