package com.example.domain.service.impl;

import com.example.domain.service.RateService;
import com.example.domain.vo.Rate;
import com.example.h2.entity.RateEntity;
import com.example.h2.mapper.RateEntityMapper;
import com.example.h2.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final RateEntityMapper mapper = Mappers.getMapper(RateEntityMapper.class);

    @Override
    public Optional<Rate> find(LocalDateTime applicationDate, Long productId, Long brandId) {

        List<RateEntity> rateEntities = rateRepository.findByDateAndProductIdAndBrandId(applicationDate, productId, brandId);

        if (!rateEntities.isEmpty())
            return rateEntities.stream()
                    .max(Comparator.comparingInt(RateEntity::getPriority))
                    .map(mapper::of);

        return Optional.empty();
    }
}
