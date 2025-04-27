package com.acunmedya_jvrfs1.RentACar.repository;

import com.acunmedya_jvrfs1.RentACar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    //Plaka içinde geçen ifadeye göre araçları getir
    List<Car> findByPlateContainingIgnoreCase(String partialPlate);

    //Kilometresi belli bir değerden az veya eşit olan arabaları getir
    List<Car> findByKilometerLessThanEqual(int kilometer);

    List<Car> findTop3ByOrderByDailyPriceAsc();
    //günlük fiyatı en düşük ilk 3 aracı getir
}
