package fsp.service.board;
import fsp.dao.board.FlightsDAOImpl;
import fsp.model.FlightsVO;

import java.util.List;
import java.util.stream.Stream;

public class FlightsManagerImpl implements FlightsManager {
    FlightsDAOImpl dao = new FlightsDAOImpl();
    @Override
    public List<FlightsVO> getBoard()
    {
        return dao.getBoard();
    }

    @Override
    public Stream<FlightsVO> getFlight(String flight_id) {
        Stream<FlightsVO> result = dao.getFlight(flight_id);
        return  result;
    }
    @Override
    public Stream<FlightsVO> searchFlight(String departureCity, String arrivalCity,String date, String seatAmount) {
        Stream<FlightsVO> result = dao.searchFlight(departureCity,arrivalCity,date,seatAmount);
        return  result;
    }
}
