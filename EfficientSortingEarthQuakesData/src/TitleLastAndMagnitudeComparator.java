import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator <QuakeEntry> {
    @Override
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int compare = String.CASE_INSENSITIVE_ORDER.compare(qe1.getInfo().substring(qe1.getInfo()
                .lastIndexOf(" ")+1),qe2.getInfo().substring(qe2.getInfo().lastIndexOf(" ")+1));
        if(compare <0)return -1;
        if(compare > 0)return 1;
        if(compare == 0){
            if(qe1.getMagnitude() < qe2.getMagnitude())return -1;
            if(qe1.getMagnitude() > qe2.getMagnitude())return 1;
        }
        return 0;
    }
}
