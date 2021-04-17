import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    @Override
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int compare = String.CASE_INSENSITIVE_ORDER.compare(qe1.getInfo(), qe2.getInfo());
        if(compare < 0 )return -1;
        if(compare > 0 )return 1;
        if(compare == 0){
            if(qe1.getDepth()< qe2.getDepth())return -1;
            if(qe1.getDepth() > qe2.getDepth())return 1;
        }
        return 0;
    }
}
