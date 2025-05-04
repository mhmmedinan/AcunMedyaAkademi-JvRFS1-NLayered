package com.acunmedya_jvrfs1.RentACar.service.rules;

import com.acunmedya_jvrfs1.RentACar.common.exceptions.types.BusinessException;
import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfNameExists(String name){
        Brand brand = brandRepository.getByNameIgnoreCase(name);
        if(brand!=null)
            throw new BusinessException("Böyle bir marka mevcut");

    }
}
