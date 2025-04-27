package com.acunmedya_jvrfs1.RentACar.service.abstracts;

import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.GetListCarResponse;

import java.util.List;

public interface CarService {

    CreatedCarResponse add(CreateCarRequest request);
    List<GetListCarResponse> findByPlateContainingIgnoreCase(String partialPlate);
    List<GetListCarResponse> findByKilometerLessThanEqual(int kilometer);
    List<GetListCarResponse> findTop3ByOrderByDailyPriceAsc();
}
