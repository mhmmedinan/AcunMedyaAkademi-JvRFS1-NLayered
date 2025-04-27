package com.acunmedya_jvrfs1.RentACar.service.abstracts;

import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.GetListModelResponse;

import java.util.List;

public interface ModelService {

    CreatedModelResponse add(CreateModelRequest request);
    List<GetListModelResponse> getList();
    List<GetListModelResponse> getByBrandName(String brandName);
    List<GetListModelResponse> getByBrandId(int brandId);
}
