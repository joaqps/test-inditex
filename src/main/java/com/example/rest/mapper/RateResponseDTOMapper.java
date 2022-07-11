package com.example.rest.mapper;

import com.example.domain.vo.Rate;
import com.example.dto.RateResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RateResponseDTOMapper{

    @Mapping(target = "brandId", source = "vo", qualifiedByName = "brandId")
    @Mapping(target = "productId", source = "vo", qualifiedByName = "productId")
    @Mapping(target = "rateId", source = "vo", qualifiedByName = "rateId")
    RateResponseDTO of(Rate vo);

    @Named("brandId")
    default Long mapBrandId(Rate vo) {

        if (vo.getBrand() == null) {
            return null;
        }
        return vo.getBrand().getId();
    }

    @Named("productId")
    default Long mapProductId(Rate vo) {

        if (vo.getProduct() == null) {
            return null;
        }
        return vo.getProduct().getId();
    }

    @Named("rateId")
    default Long mapRateId(Rate vo) {
        return vo.getId();
    }
}

