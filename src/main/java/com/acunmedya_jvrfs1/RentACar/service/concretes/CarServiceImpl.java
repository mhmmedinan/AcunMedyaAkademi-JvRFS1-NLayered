package com.acunmedya_jvrfs1.RentACar.service.concretes;

import com.acunmedya_jvrfs1.RentACar.entity.Car;
import com.acunmedya_jvrfs1.RentACar.repository.CarRepository;
import com.acunmedya_jvrfs1.RentACar.service.abstracts.CarService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.car.GetListCarResponse;
import com.acunmedya_jvrfs1.RentACar.service.mappers.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = CarMapper.INSTANCE.carFromCreateCarRequest(request);
        Car createdCar = carRepository.save(car);
        CreatedCarResponse response = CarMapper.INSTANCE.createdCarResponseFromCar(createdCar);
        return response;
    }

    @Override
    public List<GetListCarResponse> findByPlateContainingIgnoreCase(String partialPlate) {
       List<Car> cars = carRepository.findByPlateContainingIgnoreCase(partialPlate);
       List<GetListCarResponse> responses = cars.stream().
               map(CarMapper.INSTANCE::getListCarResponseFromCar).collect(Collectors.toList());
       return responses;
    }

    @Override
    public List<GetListCarResponse> findByKilometerLessThanEqual(int kilometer) {
        List<Car> cars = carRepository.findByKilometerLessThanEqual(kilometer);
        List<GetListCarResponse> responses = cars.stream().
                map(CarMapper.INSTANCE::getListCarResponseFromCar).collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetListCarResponse> findTop3ByOrderByDailyPriceAsc() {
        List<Car> cars = carRepository.findTop3ByOrderByDailyPriceAsc();
        List<GetListCarResponse> responses = cars.stream().
                map(CarMapper.INSTANCE::getListCarResponseFromCar).collect(Collectors.toList());
        return responses;
    }
}
