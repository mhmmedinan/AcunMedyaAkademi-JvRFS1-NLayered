package com.acunmedya_jvrfs1.RentACar.controller;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.repository.BrandRepository;
import com.acunmedya_jvrfs1.RentACar.service.abstracts.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // bu api sınıfıdır
@RequestMapping("/api/brands") // route tanımlama işlevini görür
public class BrandController {

   /* private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }*/

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    //Get
    @GetMapping
    public List<Brand> getBrands(){
        return brandService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandService.add(brand);
    }

    /*@GetMapping("/getbyid/{id}")
    public ResponseEntity<Brand> getById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }*/
}
