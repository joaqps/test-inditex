package com.example.h2.repository;

import com.example.h2.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RateRepository extends JpaRepository<RateEntity, Long> {

    @Query("SELECT r FROM RateEntity r  JOIN r.brand b  JOIN r.product p  WHERE p.id = :productId  AND b.id = :brandId  AND r.startDate < :applicationDate  AND r.endDate > :applicationDate")
    List<RateEntity> findByDateAndProductIdAndBrandId(LocalDateTime applicationDate, Long productId, Long brandId);
}
