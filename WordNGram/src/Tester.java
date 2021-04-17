public class Tester {
    public static void main(String[] args) {
        //testIndexOfTester();
        runMarkovTester();
    }
    public static void testIndexOfTester(){
        MarkovWordOne mwo = new MarkovWordOne();
        mwo.testIndexOf();
    }
    public static void runMarkovTester(){
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkov();
    }
}
