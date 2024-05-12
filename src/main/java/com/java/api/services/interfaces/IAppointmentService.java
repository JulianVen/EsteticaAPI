package com.java.api.services.interfaces;

import java.util.Date;
import java.util.List;

import com.java.api.models.AddAppointmentModel;
import com.java.api.models.AppointmentModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.RevenueModel;

public interface IAppointmentService {
    public ResponseModel<List<AppointmentModel>> getAllAppointments();
    public ResponseModel<List<AppointmentModel>> getAppointmentsByClientId(int id); 
    public ResponseModel<List<RevenueModel>> getRevenueReport(Date start, Date end);
    public ResponseModel<AppointmentModel> addAppointment(AddAppointmentModel addAppointmentModel);
    public ResponseModel<AppointmentModel> cancelAppointment(int clientId, int appointmentId);
    public ResponseModel<AppointmentModel> acceptAppointment(int clientId, int appointmentId);
}
