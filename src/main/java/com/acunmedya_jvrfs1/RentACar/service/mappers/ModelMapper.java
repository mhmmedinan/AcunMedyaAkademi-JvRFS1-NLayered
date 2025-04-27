package com.acunmedya_jvrfs1.RentACar.service.mappers;

import com.acunmedya_jvrfs1.RentACar.entity.Model;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(source = "brandId",target="brand.id")
    Model modelFromCreateModelRequest(CreateModelRequest createModelRequest);

    @Mapping(target="brandId",source = "brand.id")
    CreatedModelResponse createdModelResponseFromModel(Model model);


    @Mapping(source = "brand.id",target = "brandId")
    @Mapping(source = "brand.name",target="brandName")
    GetListModelResponse getListModelResponseFromModel(Model model);
}
