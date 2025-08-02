package com.example.hospital_management_system;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HospitalService service = (HospitalService) context.getBean("hospitalService");
        service.runSystem();
        ((AbstractApplicationContext) context).close();
	}

}
