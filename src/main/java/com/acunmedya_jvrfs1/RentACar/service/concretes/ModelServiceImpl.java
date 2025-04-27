package com.acunmedya_jvrfs1.RentACar.service.concretes;

import com.acunmedya_jvrfs1.RentACar.entity.Model;
import com.acunmedya_jvrfs1.RentACar.repository.ModelRepository;
import com.acunmedya_jvrfs1.RentACar.service.abstracts.ModelService;
import com.acunmedya_jvrfs1.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.dtos.responses.model.GetListModelResponse;
import com.acunmedya_jvrfs1.RentACar.service.mappers.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public CreatedModelResponse add(CreateModelRequest request) {
        Model model = ModelMapper.INSTANCE.modelFromCreateModelRequest(request);
        Model createdModel = modelRepository.save(model);
        CreatedModelResponse response = ModelMapper.INSTANCE.createdModelResponseFromModel(createdModel);
        return response;
    }

    @Override
    public List<GetListModelResponse> getList() {
        List<Model> models = modelRepository.findAll();
        List<GetListModelResponse> responses = models.stream().
                map(model -> ModelMapper.INSTANCE.getListModelResponseFromModel(model)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetListModelResponse> getByBrandName(String brandName) {
        List<Model> models = modelRepository.findByBrandName(brandName);
        List<GetListModelResponse> responses = models.stream().
                map(model -> ModelMapper.INSTANCE.getListModelResponseFromModel(model)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetListModelResponse> getByBrandId(int brandId) {
        List<Model> models = modelRepository.findByBrandIdNative(brandId);
        List<GetListModelResponse> responses = models.stream().
                map(model -> ModelMapper.INSTANCE.getListModelResponseFromModel(model)).collect(Collectors.toList());
        return responses;
    }
}
