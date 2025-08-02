package com.example.hospital_management_system;

public class HospitalService {


	    private Patient patient;
	    private Appointment appointment;
	    private Billing billing;

	    // Setters for injection
	    public void setPatient(Patient patient) {
	        this.patient = patient;
	    }

	    public void setAppointment(Appointment appointment) {
	        this.appointment = appointment;
	    }

	    public void setBilling(Billing billing) {
	        this.billing = billing;
	    }

	    public void runSystem() {
	        patient.registerPatient();
	        patient.getPatientDetails();

	        appointment.bookAppointment();
	        appointment.cancelAppointment();

	        billing.generateBill();
	        billing.sendBill();
	    }
	}

