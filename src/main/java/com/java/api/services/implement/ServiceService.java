package com.java.api.services.implement;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.java.api.entities.ServiceEntity;
import com.java.api.exceptions.NotFoundException;
import com.java.api.models.ResponseModel;
import com.java.api.models.ServiceModel;
import com.java.api.repository.IServiceRepository;
import com.java.api.services.interfaces.IServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceService implements IServices {
        private final ModelMapper modelMapper;
        private final IServiceRepository serviceRepository;

        @Override
        public ResponseModel<List<ServiceModel>> getAll() {
                List<ServiceEntity> services = serviceRepository.findAll();

                List<ServiceModel> servicesModel = services.stream()
                                .map(service -> modelMapper.map(service, ServiceModel.class)).toList();
                return new ResponseModel<List<ServiceModel>>(
                                new Date(),
                                200,
                                "Succesfull list",
                                servicesModel);
        }


        @Override
        public ResponseModel<ServiceModel> addService(ServiceModel serviceModel) {
                ServiceEntity service = modelMapper.map(serviceModel, ServiceEntity.class);
                ServiceModel savedService = modelMapper.map(serviceRepository.save(service), ServiceModel.class);

                return new ResponseModel<ServiceModel>(
                                new Date(),
                                204,
                                "Service created succesfully",
                                savedService);
        }

        @Override
        public ResponseModel<ServiceModel> updateService(int id, ServiceModel serviceModel) {
                ServiceEntity service = serviceRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Service"));

                serviceModel.setId(service.getId());
                serviceRepository.save(modelMapper.map(serviceModel, ServiceEntity.class));
                return new ResponseModel<ServiceModel>(
                                new Date(),
                                200,
                                "Service updated succesfully",
                                serviceModel);
        }

        @Override
        public ResponseModel<ServiceModel> deleteService(int id) {
                ServiceEntity service = serviceRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Service"));

                service.setDeleted(true);
                serviceRepository.save(service);
                return new ResponseModel<ServiceModel>(
                                new Date(),
                                200,
                                "Service deleted succesfully",
                                modelMapper.map(service, ServiceModel.class));
        }


}
