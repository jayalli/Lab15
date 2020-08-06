package Final.Q5DSF;

public class Element {
	
	Boolean isEnding;
	Boolean visited;
	String storyLine_string;
	int links = 2;
	String name;
	int id;
	int timesVisited;
	int numberOfStoryLines;
	String [] storyLine;
	Element left, right;
	
	
	//constructor
	Element(String s){
		
		storyLine_string = s;
		visited = false;
		isEnding= false;
	    timesVisited= 0;
	    storyLine = new String[100];
	    storyLine[0] = s;
	
		
	}
	
	//constructor for ending elements; sets isending for ending nodes  
	Element(String s, Boolean e){
		
		storyLine_string = s;
		visited = false;
		isEnding= e;
	    timesVisited= 0;
	    storyLine = new String[100];
	    storyLine[0] = s;

	    
		
		
	}
	
	/*
	Input : storyline
	Output : nothing
	BigO: 1
	space: 1?
	*/  
	public void addStoryLine(String s) {
		
		
		numberOfStoryLines++;
		storyLine[numberOfStoryLines-1] = s;
		
		//only adds to during creation 
		
	}
	
	/*
	Input : new storyLine
	Output : nothoing
	BigO: 1
	space: 1?
	*/  
	public void updateStoryLine(String s, int index) {
		
	if(index >= numberOfStoryLines) {
		System.out.println("Out of bounds");

		
	}else {
		
		storyLine[index] = s;
		
	}
			
	}
	
	
    private  String[] removeIt(String[] arr, int index){
        
    	  
        if (arr == null
            || index < 0
            || index >= arr.length) { 
  
            return arr; 
        } 
  
        String[] anotherArray = new String[arr.length - 1]; 
  
       
        for (int i = 0, k = 0; i < arr.length; i++) { 
  
      
            if (i == index) { 
                continue; 
            } 
  
  
            anotherArray[k++] = arr[i]; 
        } 

        return anotherArray; 
        
    }
    
    /*
	Input : nothing
	Output : removes storyLine
	BigO: 1
	space: 1
	*/  
    public  void remove(){
    	
    	numberOfStoryLines--;
    	
    	if(storyLine.length <= 1) {
    		
			System.out.println("Can not remove any Storylines becaue you only have one");

    	}else {
    		
    		removeIt(storyLine, (storyLine.length -1) );
    	}
    
    }

    /*
	Input : head of the node
	Output : prints the list
	BigO: n
	space: 1
	*/  
	public void printStory() {
		
		for(int i = 0; i <numberOfStoryLines; i++ ) {
			
			System.out.println(storyLine[i]);
		}
		
	}
	
	//instead of links method i made neighbors method in Choose YourOwn Adventure class

}
