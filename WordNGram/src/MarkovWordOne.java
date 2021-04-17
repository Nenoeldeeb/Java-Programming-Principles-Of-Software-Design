
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	private int indexOf(String[] words,String target,int start){
    	for(int i=start;i<words.length;i++){
    		if(words[i].equals(target))return i;
		}
    	return -1;
	}
	
	private ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
		int index = indexOf(myText,key,0);
		for(int i=0;i<myText.length;i++){
			if(index == myText.length-1 || index == -1){break;}
			String st = myText[index+1];
			follows.add(st);
			index = indexOf(myText,key,index+1);
		}
	    return follows;
    }
    public void testIndexOf(){
    	String[] words = "this is just a test yes this is a simple test".split("\\s+");
    	int this0 = indexOf(words,"this",0);
    	int this3 = indexOf(words,"this",3);
    	int frog0 = indexOf(words,"frog",0);
    	int frog5 = indexOf(words,"frog",5);
    	int simple2 = indexOf(words,"simple",2);
    	int test5 = indexOf(words,"test",5);
		System.out.println("this 0 "+this0+" this 3 "+this3+" frog 0 "+frog0+" frog 5 "+frog5
		+" simple 2 "+simple2+" test 5 "+test5);
	}

}
