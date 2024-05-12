package com.java.api.services.interfaces;

import java.util.List;

import com.java.api.models.ResponseModel;
import com.java.api.models.ServiceModel;

public interface IServices {
    public ResponseModel<List<ServiceModel>> getAll();
    public ResponseModel<ServiceModel> addService(ServiceModel serviceModel);
    public ResponseModel<ServiceModel> updateService(int id, ServiceModel serviceModel);
    public ResponseModel<ServiceModel> deleteService(int id);  
}
