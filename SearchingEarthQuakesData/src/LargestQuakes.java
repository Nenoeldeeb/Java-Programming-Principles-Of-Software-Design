import java.util.ArrayList;
public class LargestQuakes {

    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int largestIndex = 0;
        double maxMag = 0.0;
        for(int i=0;i<data.size();i++){
            double mag = data.get(i).getMagnitude();
            if(mag > maxMag){
                maxMag = mag;
                largestIndex = i;
            }
        }
        return  largestIndex;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany){
        ArrayList<QuakeEntry> result = new ArrayList<>();
        ArrayList<QuakeEntry> copy = quakeData;
        for(int i=0;i<howMany;i++){
            int index = indexOfLargest(copy);
            result.add(copy.get(index));
            copy.remove(index);
        }
        return  result;
    }
    public void findLargestQuakes(){
            EarthQuakeParser parser = new EarthQuakeParser();
            //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
            String source = "src/data/nov20quakedata.atom";
            ArrayList<QuakeEntry> list  = parser.read(source);
            int largestQuakeIndex = indexOfLargest(list);
            System.out.println("read data for "+list.size()+" quakes\nThe largest quake index is "+largestQuakeIndex+"\n");
            ArrayList<QuakeEntry> topQuakes = getLargest(list,50);
            for(QuakeEntry qe : topQuakes){
                System.out.println(qe);
            }
    }
}
