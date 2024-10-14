

import java.util.ArrayList;

class FlightDest {
    private String flightNo;
    private String destination;

    public FlightDest(String flightNo, String destination) {
        this.flightNo = flightNo;
        this.destination = destination;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }
}
class FlightInfo {
    private ArrayList<FlightDest> flightDestList;

    public FlightInfo() {
        flightDestList = new ArrayList<FlightDest>();
    }

    public void addFlightDestPair(String fNo, String dest) {
        FlightDest flightDest = new FlightDest(fNo, dest);
        flightDestList.add(flightDest);
    }

    public ArrayList<String> getFlightsDest(String dest) {
        ArrayList<String> flightNos = new ArrayList<String>();
        for (FlightDest flightDest : flightDestList) {
            if (flightDest.getDestination().equalsIgnoreCase(dest)) {
                flightNos.add(flightDest.getFlightNo());
            }
        }
        return flightNos;
    }
}

public class FlightDestinationTester {
    public static void main(String[] args) {
        FlightInfo flightInfo = new FlightInfo();
        
        flightInfo.addFlightDestPair("AA123", "New York");
        flightInfo.addFlightDestPair("BA456", "London");
        flightInfo.addFlightDestPair("AA789", "New York");
        flightInfo.addFlightDestPair("DL321", "Chicago");

        ArrayList<String> flightsToNY = flightInfo.getFlightsDest("New York");
        System.out.println("Flights to New York: " + flightsToNY);
        
        ArrayList<String> flightsToLondon = flightInfo.getFlightsDest("London");
        System.out.println("Flights to London: " + flightsToLondon);
        
        ArrayList<String> flightsToChicago = flightInfo.getFlightsDest("Chicago");
        System.out.println("Flights to Chicago: " + flightsToChicago);
    }
}
