package com.java.api.services.implement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.java.api.entities.Appointment;
import com.java.api.entities.Client;
import com.java.api.entities.RevenueReport;
import com.java.api.entities.ServiceEntity;
import com.java.api.exceptions.DeletedException;
import com.java.api.exceptions.NotFoundException;
import com.java.api.models.AddAppointmentModel;
import com.java.api.models.AppointmentModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.RevenueModel;
import com.java.api.repository.IAppointmentRepository;
import com.java.api.repository.IClientRepository;
import com.java.api.repository.IRevenueReportRepository;
import com.java.api.repository.IServiceRepository;
import com.java.api.services.interfaces.IAppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {
        private final IServiceRepository serviceRepository;
        private final IClientRepository clientRepository;
        private final IAppointmentRepository appointmentRepository;
        private final IRevenueReportRepository revenueReportRepository;
        private final ModelMapper modelMapper;

        @Override
        public ResponseModel<List<AppointmentModel>> getAllAppointments() {
                List<Appointment> appointments = appointmentRepository.findAll();

                List<AppointmentModel> appointmentsModel = appointments.stream()
                                .map(appointment -> modelMapper.map(appointment, AppointmentModel.class)).toList();

                return new ResponseModel<List<AppointmentModel>>(
                                new Date(),
                                200,
                                "Succesfull list",
                                appointmentsModel);
        }

        @Override
        public ResponseModel<List<AppointmentModel>> getAppointmentsByClientId(int id) {
                clientRepository.findById(id).orElseThrow(
                                () -> new NotFoundException("Client"));

                List<Appointment> appointments = appointmentRepository.findByClientId(id);

                List<AppointmentModel> appointmentsModel = appointments.stream()
                                .map(appointment -> modelMapper.map(appointment, AppointmentModel.class)).toList();

                return new ResponseModel<List<AppointmentModel>>(
                                new Date(),
                                200,
                                "Succesfull list",
                                appointmentsModel);

        }

        @Override
        public ResponseModel<List<RevenueModel>> getRevenueReport(Date start, Date end) {
                List<RevenueReport> revenueReport = revenueReportRepository.findAllByDateBetween(start, end);
                List<RevenueModel> revenueModelReport = revenueReport.stream()
                                .map(revenue -> modelMapper.map(revenue, RevenueModel.class)).toList();

                // Remove time
                for (RevenueModel revenueModel : revenueModelReport) {
                        // Date without time
                        String date = revenueModel.getDate().split(" ")[0];
                        revenueModel.setDate(date);
                }

                return new ResponseModel<List<RevenueModel>>(
                                new Date(),
                                200,
                                "Succesfull report",
                                revenueModelReport);
        }

        @Override
        public ResponseModel<AppointmentModel> addAppointment(AddAppointmentModel addAppointmentModel) {
                Client client = clientRepository.findById(addAppointmentModel.getClient()).orElseThrow(
                                () -> new NotFoundException("Client"));

                ServiceEntity service = serviceRepository.findById(addAppointmentModel.getService()).orElseThrow(
                                () -> new NotFoundException("Service"));

                if (service.isDeleted()) {
                        throw new DeletedException(service.getId());
                }

                Appointment appointment = new Appointment().builder()
                                .client(client)
                                .service(service)
                                .date(addAppointmentModel.getDate())
                                .time(addAppointmentModel.getTime())
                                .build();

                AppointmentModel savedAppointment = modelMapper.map(appointmentRepository.save(appointment),
                                AppointmentModel.class);

                return new ResponseModel<AppointmentModel>(
                                new Date(),
                                204,
                                "Appointment created succesfully",
                                savedAppointment);
        }

        @Override
        public ResponseModel<AppointmentModel> cancelAppointment(int clientId, int appointmentId) {
                Client client = clientRepository.findById(clientId).orElseThrow(
                                () -> new NotFoundException("Client"));

                Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(
                                () -> new NotFoundException("Appointment"));

                if (appointment.getClient().getId() != client.getId()) {
                        throw new NotFoundException("Client with that appointment");
                }

                // Cancel Appointment
                appointment.setCanceled(true);
                appointment.setAccepted(false);

                AppointmentModel savedAppointment = modelMapper.map(appointmentRepository.save(appointment),
                                AppointmentModel.class);

                return new ResponseModel<AppointmentModel>(
                                new Date(),
                                204,
                                "Appointment Canceled",
                                savedAppointment);
        }

        @Override
        public ResponseModel<AppointmentModel> acceptAppointment(int clientId, int appointmentId) {
                Client client = clientRepository.findById(clientId).orElseThrow(
                                () -> new NotFoundException("Client"));

                Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(
                                () -> new NotFoundException("Appointment"));

                if (appointment.getClient().getId() != client.getId()) {
                        throw new NotFoundException("Client with that appointment");
                }

                // Accept appointment
                appointment.setCanceled(false);
                appointment.setAccepted(true);

                AppointmentModel savedAppointment = modelMapper.map(appointmentRepository.save(appointment),
                                AppointmentModel.class);

                return new ResponseModel<AppointmentModel>(
                                new Date(),
                                204,
                                "Appointment created succesfully",
                                savedAppointment);
        }

}