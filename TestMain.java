package Final.Q5DSF;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String[] args) {
		
		//still need to assign ids
		//How to tell if a element was visited
		//How to play
		
		Scanner scan = new Scanner(System.in);
		
		String start = "This is the beginning";
		String[] ends = {"This is the first ending", "This is the second ending"};
		
		
		ChooseYourAdventure myStory = new ChooseYourAdventure(start, ends);
	
		
		//add, delete,  elements
		//edit storylines
		Element p = new  Element("This is an added element");
		myStory.addElement(p);
		myStory.addLink( myStory.start ,p);

		
		playMethod(myStory);
		
	}
	
	
	public static void playMethod(ChooseYourAdventure story) {
		
		
		story.play();
		
	}

	
}
