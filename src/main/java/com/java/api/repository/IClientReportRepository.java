package com.java.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.api.entities.ClientReport;

@Repository
public interface IClientReportRepository extends JpaRepository<ClientReport, Integer> {

}
