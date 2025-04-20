package com.acunmedya_jvrfs1.RentACar.service.concretes;

import com.acunmedya_jvrfs1.RentACar.entity.Brand;
import com.acunmedya_jvrfs1.RentACar.repository.BrandRepository;
import com.acunmedya_jvrfs1.RentACar.service.abstracts.BrandService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.GetBrandResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.brand.UpdateBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public CreatedBrandResponse add(CreateBrandRequest request) {

        //Manual Mapping
       Brand brand = new Brand();
       brand.setName(request.getName());
       Brand createdBrand = brandRepository.save(brand);

       CreatedBrandResponse response = new CreatedBrandResponse();
       response.setId(createdBrand.getId());
       response.setName(createdBrand.getName());
       return response;
    }

    @Override
    public List<GetListBrandResponse> getAll() {
           return brandRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
          brandRepository.deleteById(id);
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest request) {
        Brand brand = brandRepository.findById(request.getId()).orElseThrow(()->new RuntimeException("Brand not found"));
        brand.setName(request.getName());
        Brand updatedBrand = brandRepository.save(brand);

        UpdateBrandResponse response = new UpdateBrandResponse();
        response.setId(updatedBrand.getId());
        response.setName(updatedBrand.getName());
        return response;
    }

    @Override
    public GetBrandResponse getByName(String name) {
        Brand brand = brandRepository.getByName(name).orElseThrow(()->new RuntimeException("Brand name not found"));
        return mapToBrandResponse(brand);
    }

    private GetListBrandResponse mapToResponse(Brand brand){
        GetListBrandResponse response = new GetListBrandResponse(brand.getId(),brand.getName());
        return response;
    }

    private GetBrandResponse mapToBrandResponse(Brand brand){
        GetBrandResponse response = new GetBrandResponse(brand.getId(),brand.getName());
        return response;
    }
}

