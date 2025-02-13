package CollectionBook.Streams.CoronavirusApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopCoronaTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StopCoronaApp stopCoronaApp = new StopCoronaApp();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            switch (parts[0]) {
                case "REG": // register
                    String name = parts[1];
                    String id = parts[2];
                    try {
                        stopCoronaApp.addUser(name, id);
                    } catch (UserAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "LOC": // add locations
                    id = parts[1];
                    List<ILocation> locations = new ArrayList<>();
                    for (int i = 2; i < parts.length; i += 3) {
                        locations.add(createLocationObject(parts[i],
                                parts[i + 1], parts[i + 2]));
                    }
                    stopCoronaApp.addLocations(id, locations);
                    break;
                case "DET": // detect new cases
                    id = parts[1];
                    LocalDateTime timestamp =
                            LocalDateTime.parse(parts[2]);
                    stopCoronaApp.detectNewCase(id, timestamp);
                    break;
                case "REP": // print report
                    stopCoronaApp.createReport();
                    break;
                default:
                    break;
            }
        }
    }

    private static ILocation createLocationObject(String lon,
                                                  String lat,
                                                  String timestamp) {
        return new ILocation() {
            @Override
            public double getLongitude() {
                return Double.parseDouble(lon);
            }

            @Override
            public double getLatitude() {
                return Double.parseDouble(lat);
            }

            @Override
            public LocalDateTime getTimestamp() {
                return LocalDateTime.parse(timestamp);
            }
        };
    }
}
