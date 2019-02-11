package com.example.atelier.repository;

import com.example.atelier.model.Requests.Tailoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TailoringRepository extends JpaRepository<Tailoring, Long> {
    List<Tailoring> findAllByRequest_Progress(int progress);

    Tailoring findById(int util_id);
}
