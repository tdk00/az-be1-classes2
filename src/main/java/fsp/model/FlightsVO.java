package fsp.model;

import java.io.Serializable;

public class FlightsVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String flight_id;
    private String departure_id;
    private String arrival_id;
    private String airplane_id;
    private String date;
    private String time;
    private int freeSeats;

   @Override
    public String toString() {
       return String.format("%2s %2s %15s %15s %15s %10s %10s %5s %15s %5s %5s", flight_id, "|", departure_id, "|", arrival_id, "|", freeSeats, "|", date, "|",time);

   }


    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getDepartureId() {
        return departure_id;
    }

    public void setDepartureId(String departure_id) {
        this.departure_id = departure_id;
    }

    public String getArrivalId() {
        return arrival_id;
    }

    public void setArrivalId(String arrival_id) {
        this.arrival_id = arrival_id;
    }

    public String getAirplaneId() {
        return airplane_id;
    }

    public void setAirplaneId(String airplane_id) {
        this.airplane_id = airplane_id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }
}
