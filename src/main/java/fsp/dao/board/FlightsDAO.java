package fsp.dao.board;
import fsp.model.FlightsVO;
import java.util.List;
import java.util.stream.Stream;

public interface FlightsDAO {
    List<FlightsVO> getBoard();

    int getOccupiedSeats(String FlightId, String airplaneId);

    Stream<FlightsVO> getFlight(String flight_id);
    Stream<FlightsVO> searchFlight(String departureCity, String arrivalCity, String date, String seatAmount);
}
