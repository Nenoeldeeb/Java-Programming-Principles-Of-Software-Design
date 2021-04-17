public class Tester {
    public static void main(String[] args){
        quakesWithFiltersTester();
        testMatchAllFiltersTester();
        testMatchAllFilters2Tester();
    }
    public static void quakesWithFiltersTester(){
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        eqc.quakesWithFilter();
    }
    public static void testMatchAllFiltersTester(){
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        eqc.testMatchAllFilters();
    }
    public static void testMatchAllFilters2Tester(){
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        eqc.testMatchAllFilters2();
    }

}
