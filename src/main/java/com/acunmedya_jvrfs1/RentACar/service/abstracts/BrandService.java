package com.acunmedya_jvrfs1.RentACar.service.abstracts;

import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.*;

import java.util.List;

public interface BrandService {

    //Request-Response Pattern
    CreatedBrandResponse add(CreateBrandRequest request);
    List<GetListBrandResponse> getAll();
    void delete(int id);
    UpdateBrandResponse update(UpdateBrandRequest request);
    GetBrandResponse getByName(String name);
    DeletedBrandResponse softDelete(int id);
}
