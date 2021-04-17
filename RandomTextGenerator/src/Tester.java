import edu.duke.FileResource;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        //runMarkovZeroTester();
        //runMarkovOneTester();
        //getFollowsTester();
        //getFollowsWithFileTester();
        //runMarkovFourTester();
        runMarkovModelTester();
    }
    public static void runMarkovZeroTester(){
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkovZero();
    }
    public static void runMarkovOneTester(){
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkovOne();
    }
    public static void runMarkovFourTester(){
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkovFour();
    }
    public static void runMarkovModelTester(){
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkovModel();
    }
    public static void getFollowsTester(){
        String test = "this is a test yes this is a test.";
        MarkovOne mo = new MarkovOne();
        mo.setTraining(test);
        ArrayList<String >follow = mo.getFollows("o");
        System.out.println(follow+"\n"+follow.size());
    }
    public static void getFollowsWithFileTester(){
        FileResource file = new FileResource();
        String test = file.asString().replace("\n"," ");
        MarkovOne mo = new MarkovOne();
        mo.setTraining(test);
        ArrayList<String >follow = mo.getFollows("he");
        System.out.println(follow+"\n"+follow.size());
    }
}
