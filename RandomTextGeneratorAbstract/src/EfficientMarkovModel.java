import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class EfficientMarkovModel extends AbstractMarkovModel {

    private int num;
    private HashMap<String,ArrayList<String>> map;

    public EfficientMarkovModel(int number) {
        myRandom = new Random();
        num = number;
        map = new HashMap<String,ArrayList<String>>();
    }


    public void setTraining(String s){
        myText = s.trim();
        buildMap();
        printHashMapInfo();
    }

    private void buildMap() {
        for(int i=0;i<=myText.length()-num;i++){
            int index = i + num;
            String sub = myText.substring(i,index);
            if(!map.containsKey(sub)){
                map.put(sub,new ArrayList<>());
            }
            if(index < myText.length()) {
                ArrayList<String> follow = map.get(sub);
                String subL = myText.substring(index,index+1);
                follow.add(subL);
                map.put(sub,follow);
            }
        }
    }
    public ArrayList<String> getFollows(String key){
        return map.get(key);
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
        return "EfficientMarkovModel of order " +
                num +
                '.';
    }
    private void printHashMapInfo(){
        int lar = 0;
        for(String s : map.keySet()){
            if(map.get(s).size() > lar){
                lar = map.get(s).size();
            }
        }
        System.out.println("The size of map is "+map.size()+" the largest key is "+" "+lar+" \nThese are the largest keys followers ");
        for(String  s : map.keySet()){
            if(map.get(s).size() == lar){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
}
