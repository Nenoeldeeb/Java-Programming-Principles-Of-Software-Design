import java.util.ArrayList;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) {
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        Location Denver = new Location(39.7392, -104.9903);
        String phrase = "a";
        String where = "end";
        Filter mag = new MagnitudeFilter(3.5,4.5);
        Filter depth = new DepthFilter(-55000.0,-20000.0);
        Filter distance = new DistanceFilter(1000.0*1000,Denver);
        Filter phrasef = new PhraseFilter(phrase,where);
        //ArrayList<QuakeEntry> m7  = filter(list, mag);
        //ArrayList<QuakeEntry> m8 = filter(m7,depth);
        ArrayList<QuakeEntry> m7  = filter(list, mag);
        ArrayList<QuakeEntry> m8 = filter(m7,depth);
        for (QuakeEntry qe: m8) {
            System.out.println(qe);
        }
        System.out.println("\nFound "+m8.size());
    }
    public void testMatchAllFilters() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilters maf = new MatchAllFilters();
        String phrase = "o";
        String where = "any";
        Filter mag = new MagnitudeFilter(1.0,4.0);
        Filter depth = new DepthFilter(-180000.0,-30000.0);
        Filter phrasef = new PhraseFilter(phrase,where);
        maf.addFilter(mag);
        maf.addFilter(depth);
        maf.addFilter(phrasef);
        ArrayList<QuakeEntry> m8 = filter(list,maf);
        for (QuakeEntry qe: m8) {
            System.out.println(qe);
        }
        System.out.println("\nFound "+m8.size());
    }
    public void testMatchAllFilters2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "src/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        Location Billund = new Location(55.7308, 9.1153);
        MatchAllFilters maf = new MatchAllFilters();
        String phrase = "e";
        String where = "any";
        Filter mag = new MagnitudeFilter(0.0,5.0);
        Filter distance = new DistanceFilter(3000.0*1000,Billund);
        Filter phrasef = new PhraseFilter(phrase,where);
        maf.addFilter(mag);
        maf.addFilter(distance);
        maf.addFilter(phrasef);
        ArrayList<QuakeEntry> m8 = filter(list,maf);
        for (QuakeEntry qe: m8) {
            System.out.println(qe);
        }
        System.out.println("\nFound "+m8.size()+"\nFilters used "+maf.getName());
    }


    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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
