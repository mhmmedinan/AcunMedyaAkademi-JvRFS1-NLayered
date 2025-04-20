package com.acunmedya_jvrfs1.RentACar.service.abstracts;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand);
    List<Brand> getAll();
}
