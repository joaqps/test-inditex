package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateQueryDTO {

    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;

}
