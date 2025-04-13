package com.acunmedya_jvrfs1.RentACar.controller;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.repository.BrandRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // bu api sınıfıdır
@RequestMapping("/api/brands") // route tanımlama işlevini görür
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    //Get
    @GetMapping
    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Brand> getById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
