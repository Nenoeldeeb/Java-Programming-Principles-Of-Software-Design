
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.FileResource;

import java.io.File;
import java.util.Locale;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size,int seed) {
		markov.setRandom(seed);
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    public void printHashMapInfo(){
    	EfficientMarkovModel emm = new EfficientMarkovModel(5);
    	FileResource file = new FileResource();
    	String st = file.asString().replace("\n"," ");
    	runModel(emm,st,100,531);
    	//emm.printHashMapInfo();
	}
	public void markovModelCompare(){
		FileResource file = new FileResource();
		String input = file.asString();
    	//EfficientMarkovModel markov = new EfficientMarkovModel(2);
		MarkovModel markov = new MarkovModel(2);
    	runModel(markov,input,1000,42);
    }
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,25);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,25);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,25);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,25);

    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
