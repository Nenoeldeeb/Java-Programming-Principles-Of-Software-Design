import java.util.ArrayList;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            if(qe.getMagnitude() > magMin){
                answer.add(qe);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            Location loc = qe.getLocation();
            if(loc.distanceTo(from) < distMax ){
                answer.add(qe);
            }
        }
        return answer;
    }
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth,double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth){
                answer.add(qe);
            }
        }
        return answer;
    }
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            if((where == "any" && qe.getInfo().contains(phrase))
            ||(where == "start" && qe.getInfo().startsWith(phrase))
            ||(where == "end" && qe.getInfo().endsWith(phrase))){
                answer.add(qe);
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes\n");
        ArrayList<QuakeEntry> bigQuakes = filterByMagnitude(list,5.0);
        for(QuakeEntry qe : bigQuakes){
            System.out.println(qe);
        }
        System.out.println("\nFound "+bigQuakes.size()+" quakes match that criteria");

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes\n");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);

        ArrayList<QuakeEntry> distance = filterByDistanceFrom(list,1000.0*1000,city);
        for(QuakeEntry qe : distance){
            Location loc = qe.getLocation();
            System.out.println(" "+(loc.distanceTo(city)/1000)+" "+qe.getInfo());
        }
        System.out.println("\nFound "+distance.size()+" match that criteria");
    }
    public void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes\nFind quakes with depth between -10000.0 and -5000.0\n");
        ArrayList<QuakeEntry> quakesWithDepth = filterByDepth(list,-4000.0,-2000.0);
        for(QuakeEntry qe : quakesWithDepth){
            System.out.println(qe);
        }
        System.out.println("\nFound "+ quakesWithDepth.size()+" quakes match that criteria");

    }
    public void quakesByPhrase() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes\n");
        String where = "any";
        String phrase = "Can";
        ArrayList<QuakeEntry> quakesWithPhrases = filterByPhrase(list,where,phrase);
        for(QuakeEntry qe : quakesWithPhrases){
            System.out.println(qe);
        }
        System.out.println("\nFound "+ quakesWithPhrases.size()+" quakes have the "+phrase+" at the "+where+" of the title");

    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
