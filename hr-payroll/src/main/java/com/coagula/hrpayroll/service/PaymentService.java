package com.coagula.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coagula.hrpayroll.feignclients.WorkerFeignClient;
import com.coagula.hrpayroll.model.Payment;
import com.coagula.hrpayroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;


	public Payment getPayment(Long workerId, Integer days) {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		Payment payment = new Payment(worker.getName(),Double.valueOf(worker.getDailyIncome()), days);
		return payment;
	}
	
	
	
}
