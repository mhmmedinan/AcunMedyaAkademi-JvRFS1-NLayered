package com.acunmedya_jvrfs1.RentACar.controller;

import com.acunmedya_jvrfs1.RentACar.service.abstracts.ModelService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // bu api sınıfıdır
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(CreateModelRequest request){
        return modelService.add(request);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getList(){
        return modelService.getList();
    }


    @GetMapping("getbybrandname/{brandName}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getByBrandName(String brandName){
        return modelService.getByBrandName(brandName);
    }


    @GetMapping("getbybrandid/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getByBrandId(int brandId){
        return modelService.getByBrandId(brandId);
    }
}
