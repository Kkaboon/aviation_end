package com.example.project_aviation.dao;

import com.example.project_aviation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;



public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findByDepartureairportAndAndArrivalairportAndDeparturetime(String departureairport,
                                                          String arrivalairport,
                                                          Date departuretime);

    //出发机场+到达机场+出发时间
    @Query(value = "select f.flight_no,f.departure_airport,f.arrival_airport,f.departure_time,f.seats_remain,f.price,a.airline_name " +
            "from flight f,plane p,airline a " +
            "where f.departure_airport =:departureairport and " +
            "f.arrival_airport=:arrivalairport and " +
            "Date(f.departure_time)=str_to_date(:departuretime,'%Y%m%d') and " +
            "f.plane_no=p.plane_no and " +
            "p.airline_no=a.airline_no",nativeQuery = true)
    List<Object[]> bydeaandaraanddetime(@Param("departureairport")String departureairport,
                                        @Param("arrivalairport")String arrivalairport,
                                        @Param("departuretime")String departuretime);

    //航班号+出发时间
    @Query(value = "select f.flight_no,f.departure_airport,f.arrival_airport,f.departure_time,f.seats_remain,f.price,a.airline_name" +
            " from flight f,plane p,airline a "+
            "where f.flight_no=:flightno and " +
            "Date(f.departure_time)=str_to_date(:departuretime,'%Y%m%d') and " +
            "f.plane_no=p.plane_no and " +
            "p.airline_no=a.airline_no",nativeQuery = true)
    List<Object[]> byfnoanddetime(@Param("flightno")Integer flightno,
                                  @Param("departuretime")String departuretime);

    //乘客购票后剩余座位数-1
    @Transactional
    @Modifying
    @Query(value = "update flight f set f.seats_remain=f.seats_remain-1 where f.flight_no=:flightno",nativeQuery = true)
    int seatleft(@Param("flightno")Integer flightno);

    List<Flight> findAll();
}
