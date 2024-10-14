import java.util.ArrayList;
import java.util.Scanner;
class FlightDest{
    private String flightNo, destination;

    public FlightDest(String flightNo, String destination){
        this.flightNo = flightNo;
        this.destination = destination;
    }
    public String getFlightNo(){
        return flightNo;
    }
    public String getFlightDest(){
        return destination;
    }
}
class FlightInfo{
    ArrayList<FlightDest> flightDestList;

    public FlightInfo(){
        flightDestList = new ArrayList<FlightDest>();
    }
    public void addFlightDestPair(String fNo, String dest){
        flightDestList.add(new FlightDest(fNo, dest));
    }
    public ArrayList<String> getFlightsDest(String dest){
        ArrayList<String> flightnos = new ArrayList<>();
        System.out.println("Flights going to "+dest+" :");
        for(int i = 0; i<flightDestList.size(); i++){
            if(flightDestList.get(i).getFlightDest().equals(dest)){
                flightnos.add(flightDestList.get(i).getFlightNo());
                System.out.println(flightDestList.get(i).getFlightNo());
            }
        }
        return flightnos;
    }
}

public class FlightDestinationTester{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightInfo flightInfo = new FlightInfo();

        flightInfo.addFlightDestPair("AB112", "DUBAI");
        flightInfo.addFlightDestPair("XY345", "LONDON");
        flightInfo.addFlightDestPair("LM678", "NEW YORK");
        flightInfo.addFlightDestPair("QR910", "TOKYO");
        flightInfo.addFlightDestPair("JK123", "SYDNEY");
        flightInfo.addFlightDestPair("MN456", "PARIS");
        flightInfo.addFlightDestPair("OP789", "TORONTO");
        flightInfo.addFlightDestPair("ST234", "BERLIN");
        flightInfo.addFlightDestPair("UV567", "SINGAPORE");
        flightInfo.addFlightDestPair("WX890", "ROME");
        flightInfo.addFlightDestPair("AB999", "DUBAI");
        flightInfo.addFlightDestPair("XY888", "LONDON");
        flightInfo.addFlightDestPair("LM777", "NEW YORK");
        flightInfo.addFlightDestPair("QR666", "TOKYO");
        flightInfo.addFlightDestPair("JK555", "SYDNEY");
        flightInfo.addFlightDestPair("MN444", "PARIS");

        System.out.print("Enter destination: ");
        String d = scanner.nextLine().toUpperCase();
        flightInfo.getFlightsDest(d);
        scanner.close();
    }
}
