package Final.Q5DSF;

import java.util.Scanner;

//import Test2.BSTNode;

public class ChooseYourAdventure {
	
	int numberOfElements =3 ;
	Element start;
	int numEndings = 2;
	Element [] endings;
	int chocies;
	Boolean [][] links;
	Element [] element_list;

	
	ChooseYourAdventure(String startStrings, String[] endStrings) {
		

		element_list = new Element[1000];
		start = new Element(startStrings);
		start.id = 0;
		endings = new Element[]{new Element(endStrings[0], true), new Element(endStrings[1], true)};
		endings[0].id = 1;
		endings[1].id = 2;
		element_list[0] = start;
		element_list[1] = endings[0];
		element_list[2] = endings[1];


		links = new Boolean[1000][1000];
		
		
		//Initiates links
		for (int i = 0; i < numberOfElements; ++i) { 
			
            for (int j = 0; j < numberOfElements; ++j) { 
            	
               links[i][j] = false; 
               
            } 
            
        } 

		links[0][1] = true; //link between the start node and the endings
		
		
	}
	
	
	/*
	 * Increase the numberOfElements by one intializes the all links assoiated
	 * to the new vertex to false and automatically creates a link between the new node and 
	 * one of the endings so it automatically has one child, it always has an ending and it would be classified as an ending
	 */
	
	/*
	Input : elment to add
	Output : nothing
	BigO:n
	space: 1?
	*/  
	public void addElement(Element e) {
		
	//all elements have to converge on the preexisiting ending nodes
	//Can only add nodes to nodes that have one child(if they have 2 they are full if they have 
	//0 they are ending)
	
		numberOfElements++;
		e.id = numberOfElements-1;
		
		 for (int i = 0; i < numberOfElements; ++i) { 
			 links[i][numberOfElements - 1] = false; 
			 links[numberOfElements - 1][i] = false; 
		    } 
		 
		 
		 links[numberOfElements - 1][soRandom()]  = true;
		 element_list[numberOfElements - 1] = e;
		 
		
	}
	
	
	private int soRandom() {
		
		
		 double randend = Math.random();
	        
	        if(((int)(randend*1)) <= 0  ){
	            
	            randend = ((int)(randend*3))+1 ;
	        }else{
	            
	             randend = ((int)(randend*3));
	        }

	        return (int) randend;      
      
	 }
	
	/*
	Input : element
	Output : the children of the  elment
	BigO: n + 1 ->n 
	space: 
	*/  
	public int[] neighbors(Element e) {
		
		
		    int[] nei = new int[2];
		    int t = 0;
		    for (int i = 0; i < numberOfElements; i++){
		    	
		        if(links[e.id][i] && t == 0) {
		        	
		            nei[t] = i;
		            t++;
		            
		        }else if(links[e.id][i] && t==1 ) {
		        	
		        	nei[t] = i;
		        	break;
		        	
		        }
		    }
		    
		    return nei;
		
	}
		
	/*
	Input : to elments you want to connect
	Output : nothing
	BigO: 1
	space: 1
	*/  
	//link from s1 -> s2
	public void addLink(Element s1, Element s2) {
		
		int[]n  = neighbors(s1);
		
		if(s1.isEnding == true ||  s1.id >= numberOfElements  || s2.id > numberOfElements || s1.id  == s2.id || n[0] != 0 && n[1] != 0 ) { 
			
			System.out.println("Can not add link");

		}else {
			
			links[s1.id][s2.id] = true;
			
			
		}

		
	}
	

	/*
	Input : element to remove
	Output : nothing
	BigO: n
	space: o
	*/  
	public void removeElement(Element c) {

		//Can not remove ending node
		if(c.isEnding) {
			
			System.out.println("Can not delete");

		}else {
			
			if (c.id > numberOfElements) { 
		        System.out.println("Element not present!"); 
		        return; 
		    } 
		    else { 
		        int i; 
		  
		        // removing the vertex 
		        while (c.id < numberOfElements) { 
		  
		            // shifting the rows to left side 
		            for (i = 0; i < numberOfElements; ++i) { 
		            	links[i][c.id] = links[i][c.id + 1]; 
		            } 
		  
		            // shifting the columns upwards 
		            for (i = 0; i < numberOfElements; ++i) { 
		            	links[c.id][i] = links[c.id + 1][i]; 
		            } 
		            c.id++; 
		        } 
		  
		        // decreasing the number of vertices 
		        element_list[c.id] = null;
		        numberOfElements--;

		    } 
	
		}
		
	}
	
	/*
	Input : link to remove
	Output : nothing
	BigO: 1
	space: 0
	*/  
	public void removeLink(Element s1, Element s2) {

		if(links[s1.id][s2.id]) {
			
			
			links[s1.id][s2.id] = false;
			
		}
	}
	
	/*
	Input : nothing
	Output : nothing
	counts choices
	BigO: 1
	space: 0
	*/  
	public int choiceHistory() {

		return chocies;
		
	}
	
	/*
	Input : nothing
	Output : choices and storylines
	BigO: n
	space: 3
	*/  
	public void play() {
		
		Scanner scan  = new Scanner(System.in);
		
		System.out.println("Welcome to the Adventure Game!");
		
		Element node = start;
		System.out.println(node.storyLine_string);

		while(!node.isEnding){
			
			int[] neighbors = neighbors(node);

			if(neighbors[1] != 0){

				System.out.println("1 for first choice, 2 for second choice");
				int choice = scan.nextInt();
				chocies++;
				node = element_list[neighbors[choice-1]];
				System.out.println(node.storyLine_string);

			}
			
			else if(neighbors[1] == 0){
				
				System.out.println("1 for first choice");
				int choice = scan.nextInt();
				chocies++;
				node = element_list[neighbors[0]];
				System.out.println(node.storyLine_string);

				
			}
			
		}

	

		
	}

}
