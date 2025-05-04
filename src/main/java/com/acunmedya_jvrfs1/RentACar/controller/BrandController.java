package com.acunmedya_jvrfs1.RentACar.controller;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.repository.BrandRepository;
import com.acunmedya_jvrfs1.RentACar.service.abstracts.BrandService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.*;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK) //200
    public List<GetListBrandResponse> getBrands(){
        return brandService.getAll();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK) //200
    public GetBrandResponse getByName(@PathVariable String name){
        return brandService.getByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedBrandResponse add(@RequestBody CreateBrandRequest request){
       return brandService.add(request);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK) //200
    public UpdateBrandResponse update(@RequestBody UpdateBrandRequest request){
        return brandService.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }


    @DeleteMapping("softdelete/{id}")
    @ResponseStatus(HttpStatus.OK) //200
    public DeletedBrandResponse softdelete(@PathVariable int id){
        return brandService.softDelete(id);
    }

    /*@GetMapping("/getbyid/{id}")
    public ResponseEntity<Brand> getById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }*/
}
