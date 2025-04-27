package com.acunmedya_jvrfs1.RentACar.controller;

import com.acunmedya_jvrfs1.RentACar.service.abstracts.CarService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.GetListCarResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // bu api sınıfıdır
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(CreateCarRequest request){
        return carService.add(request);
    }

    @GetMapping("findByPlate/{partialPlate}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCarResponse> findByPlateContainingIgnoreCase(String partialPlate){
        return carService.findByPlateContainingIgnoreCase(partialPlate);
    }

    @GetMapping("findByKilometer/{kilometer}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCarResponse> findByKilometerLessThanEqual(int kilometer){
        return carService.findByKilometerLessThanEqual(kilometer);
    }

    @GetMapping("findTop3")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCarResponse> findTop3ByOrderByDailyPriceAsc(){
        return carService.findTop3ByOrderByDailyPriceAsc();
    }
}
