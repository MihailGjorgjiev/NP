package CollectionBook.Streams.CoronavirusApp;

import java.time.Duration;

public class LocationUtils {
    public static double distanceBetween(ILocation l1,ILocation l2){
        double dx= l1.getLatitude()-l2.getLatitude();
        double dy= l1.getLongitude()-l2.getLongitude();

        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public static double timeBetweenInSeconds(ILocation l1,ILocation l2){
        return Math.abs(Duration.between(l1.getTimestamp(),l2.getTimestamp()).getSeconds());
    }

    public static boolean isDanger(ILocation l1,ILocation l2){
        return distanceBetween(l1,l2)<=2.0 && timeBetweenInSeconds(l1,l2)<=300;
    }
}
