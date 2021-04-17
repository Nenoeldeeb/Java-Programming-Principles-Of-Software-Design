import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram,ArrayList<String>> myMap;

    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        myMap = new HashMap<>();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
        printHashMapInfo();
    }
    private void buildMap() {
        for(int i=0;i<=myText.length-myOrder;i++){
            WordGram wg = new WordGram(myText,i,myOrder);
            if(! myMap.containsKey(wg)){
                myMap.put(wg,new ArrayList<>());
            }
            if(i+myOrder < myText.length-1) {
                ArrayList<String> follow = myMap.get(wg);
                String subL = myText[i+myOrder];
                follow.add(subL);
                myMap.put(wg,follow);
            }
        }
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText,index,myOrder);
        sb.append(kGram);
        sb.append(" ");
        for(int k=0; k < numWords; k++){
            ArrayList<String> follows = getFollows(kGram);
            if (follows == null || follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }

        return sb.toString().trim();
    }
    private int indexOf(String[] words,WordGram target,int start){
        for(int i=start;i<words.length-myOrder;i++){
            WordGram wg = new WordGram(words,i,myOrder);
            if(wg.equals(target))return i;
        }
        return -1;
    }

    private ArrayList<String > getFollows(WordGram kGram) {

        return myMap.get(kGram);
    }
    private void printHashMapInfo(){
        int lar = 0;
        for(WordGram s : myMap.keySet()){
            if(myMap.get(s).size() > lar){
                lar = myMap.get(s).size();
            }
            //System.out.println(s+" "+myMap.get(s));
        }
        System.out.println("The size of map is "+myMap.size()+" the largest key is "+" "+lar+" \nThese are the largest keys followers ");
        for(WordGram  s : myMap.keySet()){
            if(myMap.get(s).size() == lar){
                System.out.println(s+" "+myMap.get(s));
            }
        }
    }

}
