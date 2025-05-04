package com.acunmedya_jvrfs1.RentACar.service.mappers;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.DeletedBrandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand);
}
