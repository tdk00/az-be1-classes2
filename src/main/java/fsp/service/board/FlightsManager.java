package fsp.service.board;
import fsp.model.FlightsVO;
import java.util.List;
import java.util.stream.Stream;

public interface FlightsManager {
    public List<FlightsVO> getBoard();
    Stream<FlightsVO> getFlight(String flight_id);
     Stream<FlightsVO> searchFlight(String departureCity, String arrivalCity, String date, String seatAmount);
}
