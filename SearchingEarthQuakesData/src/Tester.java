public class Tester {
    public static void main(String[] args){
       //bigQuakesTester();
       //closeToMeTester();
        //quakesOfDepthTester();
        //quakesByPhraseTester();
        //findClosestQuakeTester();
        //findLargetQuakeesTester();
    }
    public static void bigQuakesTester(){
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.bigQuakes();
    }
    public static void closeToMeTester(){
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.closeToMe();
    }
    public static void quakesOfDepthTester() {
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.quakesOfDepth();
    }
    public static void quakesByPhraseTester() {
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.quakesByPhrase();
    }
    public static void findClosestQuakeTester() {
        ClosestQuakes cq = new ClosestQuakes();
        cq.findClosestQuakes();
    }
    public static void findLargetQuakeesTester(){
        LargestQuakes lq = new LargestQuakes();
        lq.findLargestQuakes();
    }

}
