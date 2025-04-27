package com.acunmedya_jvrfs1.RentACar.service.mappers;

import com.acunmedya_jvrfs1.RentACar.entity.Car;
import com.acunmedya_jvrfs1.RentACar.entity.Model;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.GetListCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "modelId",target="model.id")
    Car carFromCreateCarRequest(CreateCarRequest createCarRequest);

    @Mapping(target="modelId",source = "model.id")
    CreatedCarResponse createdCarResponseFromCar(Car car);


    @Mapping(source = "model.id",target = "modelId")
    @Mapping(source = "model.name",target="modelName")
    GetListCarResponse getListCarResponseFromCar(Car car);
}
