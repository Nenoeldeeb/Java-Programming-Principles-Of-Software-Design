import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel {

    private int num;

    public MarkovModel(int number) {
        myRandom = new Random();
        num = number;
    }


    public void setTraining(String s){
        myText = s.trim();
    }


    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-num);
        String key = myText.substring(index,index+num);
        sb.append(key);
        for(int k=0; k < numChars-num; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){break;}
            index = myRandom.nextInt(follows.size());
            String ch = follows.get(index);
            sb.append(ch);
            key = key.substring(1)+ch;
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "MarkovModel of order " +
                num +
                '.';
    }
}
