public class DistanceFilter implements Filter {
    private double maxDistance;
    private Location loc;

    public DistanceFilter(double max, Location currLoc) {
        maxDistance = max;
        loc = currLoc;
    }

    public boolean satisfies(QuakeEntry qe) {
        if (qe.getLocation().distanceTo(loc) < maxDistance) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Distance";
    }
}