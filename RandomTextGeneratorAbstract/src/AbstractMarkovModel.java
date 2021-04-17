
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<>();
        int start = 0;
        for(int i=0;i<myText.length()-key.length();i++){
            int index = myText.indexOf(key,start);
            int fLetter = index + key.length();
            if(fLetter >= myText.length() || index == -1){break;}
            String st = myText.substring(fLetter,fLetter+1);
            follows.add(st);
            start   = fLetter+1;
        }
        return follows;
    }
    public void setRandom(int random){myRandom = new Random(random);}
}
