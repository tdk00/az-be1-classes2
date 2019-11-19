package fsp.dao.board;
import fsp.model.FlightsVO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FlightsDAOImpl implements FlightsDAO {
    @Override
    public List<FlightsVO> getBoard()
    {
        List<FlightsVO> board = new ArrayList<FlightsVO>();

        List<String> cities = null;


        try {
            cities = Files.readAllLines(Paths.get("C:\\Users\\LordGamer\\Documents\\nurlan\\sstp2\\az-be1-classes\\src\\main\\java\\fsp\\db\\cities.txt"));
        } catch (IOException e) {

            e.printStackTrace();
            cities=null;
        }
                if(cities!=null) {
                    try {
                        File flights = new File("C:\\Users\\LordGamer\\Documents\\nurlan\\sstp2\\az-be1-classes\\src\\main\\java\\fsp\\db\\flights.txt");
                        Scanner fl = new Scanner(flights);
                        fl.useDelimiter("[,\n]");
                        while (fl.hasNext()) {
                            FlightsVO vo = new FlightsVO();
                            String flightId = fl.next();
                            vo.setFlight_id(flightId);
                            vo.setDepartureId(cities.get(Integer.parseInt(fl.next())));
                            vo.setArrivalId(cities.get(Integer.parseInt(fl.next())));
                            String airplaneId = fl.next();
                            vo.setAirplaneId(airplaneId);
                            vo.setDate(fl.next());
                            vo.setTime(fl.next());
                            vo.setFreeSeats(getOccupiedSeats(flightId,airplaneId));
                            board.add(vo);
                        }
                    } catch (FileNotFoundException fnf) {

                    }
                }
                else{
                    return null;
                }

        return board;
    }
    @Override
    public int getOccupiedSeats(String FlightId, String airplaneId){
        int occupied = 0;
        List<String> airplains = null;
        try {
            airplains = Files.readAllLines(Paths.get("C:\\Users\\LordGamer\\Documents\\nurlan\\sstp2\\az-be1-classes\\src\\main\\java\\fsp\\db\\airplains.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            airplains=null;
        }
        try {

            File booking = new File("C:\\Users\\LordGamer\\Documents\\nurlan\\sstp2\\az-be1-classes\\src\\main\\java\\fsp\\db\\bookings.txt");
            Scanner bk = new Scanner(booking);
            bk.useDelimiter("[,\n]");
            String bookingId = "";
            String userId = "";
            String passengerId = "";
            String flightId = "";
            String seatId = "";
            while (bk.hasNext()) {
                bookingId = bk.next();
                userId = bk.next();
                passengerId = bk.next();
                flightId = bk.next();
                seatId = bk.next().replace("\n", "").replace("\r", "");
                if(flightId.equals(FlightId)){
                    occupied++;
                }
            }
        } catch (FileNotFoundException fnf) {
                return 0;
        }
        int allSeats = Integer.parseInt(airplains.get(Integer.parseInt(airplaneId)));
        int freeSeats = (allSeats*4)-occupied;
        return freeSeats;
    }
    @Override
    public Stream<FlightsVO> getFlight(String flight_id)
    {
        List<FlightsVO> allFlights = this.getBoard();
        Stream<FlightsVO> result = allFlights.stream()
                .filter(line -> flight_id.equals(line.getFlight_id()));
        return result;
    }
    @Override
    public Stream<FlightsVO> searchFlight(String departureCity, String arrivalCity,String date, String seatAmount)
    {
        List<FlightsVO> allFlights = this.getBoard();
        Stream<FlightsVO> result = allFlights.stream()
                .filter(line -> departureCity.toLowerCase().equals(line.getDepartureId().toLowerCase()))
                .filter(line -> arrivalCity.toLowerCase().equals(line.getArrivalId().toLowerCase()))
                .filter(line -> date.toLowerCase().equals(line.getDate().toLowerCase()))
                .filter(line -> Integer.parseInt(seatAmount) <= line.getFreeSeats());
        return result;
    }

}
