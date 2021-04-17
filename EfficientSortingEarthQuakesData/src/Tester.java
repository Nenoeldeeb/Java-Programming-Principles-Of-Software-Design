public class Tester {
    public static void main(String[] args) {
        //sortWithCompareToTester();
        //sortWithTitleAndDepthTester();
        sortWithLastWordInTitleAndMagnitudeTester();
    }
    public static void sortWithCompareToTester(){
        DifferentSorters ds = new DifferentSorters();
        ds.sortWithCompareTo();
    }
    public static void sortWithTitleAndDepthTester(){
        DifferentSorters ds = new DifferentSorters();
        ds.sortWithTitleAndDepth();
    }
    public static void sortWithLastWordInTitleAndMagnitudeTester(){
        DifferentSorters ds = new DifferentSorters();
        ds.sortWithLastWordInTitleAndMagnitude();
    }
}
