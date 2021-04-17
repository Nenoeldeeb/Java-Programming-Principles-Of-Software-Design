import java.util.ArrayList;

public class MatchAllFilters implements Filter{
    private ArrayList<Filter> filterList;
    public MatchAllFilters() {
        filterList = new ArrayList<>();
    }
    public void addFilter(Filter f){
        filterList.add(f);
    }

    public boolean satisfies(QuakeEntry qe) {
        for(Filter f : filterList){
            if(!f.satisfies(qe)){return false;}
        }
        return true;
    }

    @Override
    public String getName() {
        String filters = new String();
        for(Filter f : filterList){filters += " "+f.getName();}
        return filters;
    }
}
