package com.java.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.api.entities.RevenueReport;

@Repository
public interface IRevenueReportRepository extends JpaRepository<RevenueReport, Date> {

    public List<RevenueReport> findAllByDateBetween(Date start, Date end);

}
