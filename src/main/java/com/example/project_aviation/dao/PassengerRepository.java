package com.example.project_aviation.dao;

import com.example.project_aviation.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,String> {
    @Query(value = "select p.identity_no,p.name,p.sex,p.telephone,p.address,p.password,p.is_ad from passenger p",nativeQuery = true)
    List<Object[]> findALL();

    Passenger findByIdentityno(String identityno);

    Passenger findByTelephone(String telelephone);

    //String findByIdentity_no(int idetity_no);
    @Modifying
    @Transactional
    @Query("update Passenger p set p.password=:password,p.address=:address " +
            "where p.identityno=:identityno")
    int updatePassenger(@Param("identityno") String identityno,
                        @Param("password") String password,
                        @Param("address") String address);

}
