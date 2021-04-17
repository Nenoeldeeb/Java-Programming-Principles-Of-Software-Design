
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    private int getLargestDepth(ArrayList<QuakeEntry> quakeData,int from){
        int max = from;
        for(int i=from;i<quakeData.size();i++){
            if(quakeData.get(i).getDepth() > quakeData.get(max).getDepth()){
                max = i;
            }
        }
        return max;
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        for(int i=0;i<in.size();i++){
            int max = getLargestDepth(in,i);
            QuakeEntry maxQ = in.get(max);
            QuakeEntry currQ = in.get(i);
            in.set(i,maxQ);
            in.set(max,currQ);
            if(i == 49){break;}
        }
    }
    private void onePassBubbleSort(ArrayList<QuakeEntry> quakeData,int numSorted){
        for(int i=0;i<quakeData.size()-numSorted;i++){
            QuakeEntry firstElement = quakeData.get(i);
            if(i+1 < quakeData.size()) {
                QuakeEntry adjacentElement = quakeData.get(i + 1);
                if (firstElement.getMagnitude() > adjacentElement.getMagnitude()) {
                    quakeData.set(i, adjacentElement);
                    quakeData.set(i + 1, firstElement);
                }
            }
        }
    }
    private boolean checkInSortedOrder(ArrayList<QuakeEntry> quakeData){
        for(int i=0;i<quakeData.size();i++){
            QuakeEntry firstElement = quakeData.get(i);
            if(i+1 < quakeData.size()) {
                QuakeEntry adjacentElement = quakeData.get(i + 1);
                if (firstElement.getMagnitude() > adjacentElement.getMagnitude()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        int totalPasses = 0;
        for(int i=0;i<in.size()-1;i++){
            onePassBubbleSort(in,i);
            if(checkInSortedOrder(in)){
                totalPasses = i+1;
                break;
            }
        }
        System.out.println("\nTotal passes needed to sort this list are "+totalPasses);
    }
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        int totalPasses = 0;
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if(checkInSortedOrder(in)){
                totalPasses = i+1;
                break;
            }
        }
        System.out.println("\nTotal passes needed to sort this list are "+totalPasses);
    }


    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "src/data/nov20quakedatasmall.atom";
        String source = "src/data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
