package fsp.controller.board;
import fsp.model.FlightsVO;
import fsp.service.board.FlightsManagerImpl;

import java.util.List;
import java.util.stream.Stream;

public class FlightsController
{
    FlightsManagerImpl manager = new FlightsManagerImpl();
    public List<FlightsVO> getBoard()
    {
        return manager.getBoard();
    }
    public Stream<FlightsVO> getFlight(String flight_id)
    {
        return manager.getFlight(flight_id);
    }

    public Stream<FlightsVO> searchFlight(String departureCity, String arrivalCity,String date, String seatAmount)
    {
        return manager.searchFlight(departureCity,arrivalCity,date,seatAmount);
    }

}

