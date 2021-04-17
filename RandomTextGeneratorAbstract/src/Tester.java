import edu.duke.FileResource;

public class Tester {
    public static void main(String[] args) {
        //runMarkovTester();
        printHashMapInfoTester();
        //markovModelCompareTester();
    }
    public static void runMarkovTester(){
        MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
        mrwi.runMarkov();
    }
    public static void printHashMapInfoTester(){
        MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
        mrwi.printHashMapInfo();
    }
    public static void markovModelCompareTester(){
        MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
        mrwi.markovModelCompare();
    }
}
