import java.awt.*;
import java.util.ArrayList;

public class WordGramTester {
	public static void main(String[] args) {
		//testWordGram();
		//testWordGramEquals();
		//runMarkovTester();
		testHashMapTester();
		//compareMarkovTester();
	}
	public static void testWordGram(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		int size = 4;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			System.out.println(index+"\t"+wg.length()+"\t"+wg);
		}
		WordGram w = new WordGram(words,0,size);
		WordGram wgg = w.shiftAdd("yes");
		System.out.println("\nshifted "+wgg);
	}
	
	public static void testWordGramEquals(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		ArrayList<WordGram> list = new ArrayList<WordGram>();
		int size = 4;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			list.add(wg);
		}
		WordGram first = list.get(0);
		System.out.println("checking "+first);
		for(int k=0; k < list.size(); k++){
			//if (first == list.get(k)) {
			  if (first.equals(list.get(k))) {
				System.out.println("matched at "+k+" "+list.get(k));
			}
		}
	}
	public static void runMarkovTester(){
		MarkovRunner mr = new MarkovRunner();
		mr.runMarkov();
	}
	public static void testHashMapTester(){
		MarkovRunner mr = new MarkovRunner();
		mr.testHashMap();
	}
	public static void compareMarkovTester(){
		MarkovRunner mr = new MarkovRunner();
		mr.compareMarkovWord();
	}
	
}
