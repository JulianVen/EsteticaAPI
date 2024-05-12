package com.java.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.api.entities.ServiceEntity;

@Repository
public interface IServiceRepository extends JpaRepository<ServiceEntity, Integer> {

    @Override
    @Query("select e from #{#entityName} e where e.isDeleted=false")
    public List<ServiceEntity> findAll();
    
}
