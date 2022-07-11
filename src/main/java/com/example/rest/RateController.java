package com.example.rest;

import com.example.domain.service.RateService;
import com.example.domain.vo.Rate;
import com.example.dto.RateQueryDTO;
import com.example.dto.RateResponseDTO;
import com.example.rest.mapper.RateResponseDTOMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;
    private final RateResponseDTOMapper mapper = Mappers.getMapper(RateResponseDTOMapper.class);

    @PostMapping("/find")
    public ResponseEntity<RateResponseDTO> find(@RequestBody RateQueryDTO queryParams) {

        Optional<Rate> rate = rateService.find(queryParams.getApplicationDate(), queryParams.getProductId(), queryParams.getBrandId());

        return rate.map(r -> ResponseEntity.ok(mapper.of(r))).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
