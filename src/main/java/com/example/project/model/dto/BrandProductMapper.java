package com.example.project.model.dto;

import com.example.project.model.entity.BrandProduct;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BrandProductMapper {
    BrandProduct brandProductDtoToBrandProduct(BrandProductDto brandProductDto);

    BrandProductDto brandProductToBrandProductDto(BrandProduct brandProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BrandProduct updateBrandProductFromBrandProductDto(BrandProductDto brandProductDto, @MappingTarget BrandProduct brandProduct);

    @AfterMapping
    default void linkRequestDetails(@MappingTarget BrandProduct brandProduct) {
        brandProduct.getRequestDetails().forEach(requestDetail -> requestDetail.setBrandProduct(brandProduct));
    }
}
