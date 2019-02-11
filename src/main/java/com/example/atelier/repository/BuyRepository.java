package com.example.atelier.repository;


import com.example.atelier.model.Requests.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {
    List<Buy> findAllByRequest_Progress(int progress);

    Buy findById(int buy_id);
}
