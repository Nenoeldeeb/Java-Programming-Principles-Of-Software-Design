import java.util.ArrayList;
import java.util.Random;

public class MarkovFour {
    private String myText;
    private Random myRandom;

    public MarkovFour() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<>();
        int index = myText.indexOf(key);
        for(int i=0;i<myText.length();i++){
            if(index == myText.length()-1 || index == -1){break;}
            String st = myText.substring(index+key.length(),index+key.length()+1);
            follows.add(st);
            index = myText.indexOf(key,index+key.length());
        }
        return follows;
    }
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index,index+4);
        sb.append(key);
        for(int k=0; k < numChars-4; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){break;}
            index = myRandom.nextInt(follows.size());
            String ch = follows.get(index);
            sb.append(ch);
            key = key.substring(1)+ch;
        }

        return sb.toString();
    }
}
