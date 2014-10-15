package drake.edu.project2;

import java.util.Vector;

//So essentially when you create a story, you create a list of prompts, and then iterate through the list to play the game. 
//need to work on adding the audio, as well as output files for the 
public class Story {

	/**
	 * Each story should just be a list of prompts
	 */
	Vector <Prompt> myStory = new Vector<Prompt>();
	public int category;
	public Story(){
		 int rand =  (int)(Math.random()*3);
		//beach
		if(category==0){
			//randomly choose a story from the 4 beach
			 if(rand==0){
				 myStory = getStory1();
			 }
			 else if (rand ==1){
				  myStory = getStory2();
			 }
			 else if(rand ==2){
				  myStory = getStory3();
			 }
		}
		//safari
		else if(category ==2){
			 if(rand==0){
				  myStory = getSafariStory1();
			 }
			 else if (rand ==1){
				  myStory = getSafariStory2();
			 }
			 else if(rand ==2){
				  myStory = getSafariStory3();
			 }
		}
		//space
		else if(category ==3){
			 if(rand==0){
				  myStory = getSpaceStory1();
			 }
			 else if (rand ==1){
				  myStory = getSpaceStory2();
			 }
			 else if(rand ==2){
				 myStory = getSpaceStory3();
			 }
		}
		//sports
		else if(category ==4){
			 if(rand==0){
				 myStory = getSportsStory1();
			 }
			 else if (rand ==1){
				  myStory = getSportsStory2();
			 }
			 else if(rand ==2){
				  myStory = getSportsStory3();
			 }
		}
		//zoo
		else if(category ==5){
			 if(rand==0){
				 myStory = getZooStory1();
			 }
			 else if (rand ==1){
				 myStory = getZooStory2();
			 }
			 else if(rand ==2){
				 myStory = getZooStory3();
			 }
		}
	}
	public void addPrompt(Prompt p){
		myStory.add(p);
	}
	
	public void setCategory(int cat){
		category = cat; //meow ^    ^ 
						//      o  o
						//    >  <>  <
						//        Y
	}
	
	//for the first draft, just hard code the stories into methods here. 
	public Vector<Prompt> getStory1(){
		Prompt prompt1 = new Prompt("Say a furry animal!", 0);
		Prompt prompt2 = new Prompt("Say something you wear when it's cold outside!", 1);
		Prompt prompt3 = new Prompt("Say something you use at school!", 2);
		Prompt prompt4 = new Prompt("Say your favorite flavor of ice cream!", 3);
		Prompt prompt5 = new Prompt("Name an animal that likes the cold!", 4);
		Vector<Prompt> myBeachStory = new Vector<Prompt>();
		myBeachStory.add(prompt1);
		myBeachStory.add(prompt2);
		myBeachStory.add(prompt3);
		myBeachStory.add(prompt4);
		myBeachStory.add(prompt5);
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
		return mySportsStory;
	}
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
		return myZooStory;
	}
	
	

}
