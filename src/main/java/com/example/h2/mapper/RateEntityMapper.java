package com.example.h2.mapper;

import com.example.domain.vo.Rate;
import com.example.h2.entity.RateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateEntityMapper {

//    @Mapping(target = "brandId", source = "entity", qualifiedByName = "brandId")
//    @Mapping(target = "productId", source = "entity", qualifiedByName = "productId")
    Rate of(RateEntity entity);

//    @Mapping(target = "brand", source = "vo", qualifiedByName = "brand")
//    @Mapping(target = "product", source = "vo", qualifiedByName = "product")
    RateEntity of(Rate vo);

//    @Named("brandId")
//    default Long mapBrandId(RateEntity entity) {
//
//        if (entity.getBrand() == null) {
//            return null;
//        }
//        return entity.getBrand().getId();
//    }
//
//    @Named("productId")
//    default Long mapProductId(RateEntity entity) {
//
//        if (entity.getProduct() == null) {
//            return null;
//        }
//        return entity.getProduct().getId();
//    }
//
//    @Named("brand")
//    default BrandEntity mapBrand(Rate vo) {
//
//        BrandEntity brand = new BrandEntity();
//        brand.setId(vo.getBrandId());
//        return brand;
//    }
//
//    @Named("product")
//    default ProductEntity mapProduct(Rate vo) {
//
//        ProductEntity product = new ProductEntity();
//        product.setId(vo.getProductId());
//        return product;
//    }

}

