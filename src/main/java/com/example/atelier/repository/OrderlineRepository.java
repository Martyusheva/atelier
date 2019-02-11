package com.example.atelier.repository;


import com.example.atelier.model.Requests.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Long> {

    List<Orderline> findAllByBuy(int buy);


}