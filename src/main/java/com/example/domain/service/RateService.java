package com.example.domain.service;

import com.example.domain.vo.Rate;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RateService {

    Optional<Rate> find(LocalDateTime applicationDate, Long productId, Long brandId);
}
