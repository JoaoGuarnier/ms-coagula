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
	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(Long workerId, Integer days) {
		
//		Map<String,String> uriVariables = new HashMap<>();
//		uriVariables.put("id", workerId.toString());
//		String urlhrworker = workerHost + "/workers/{id}";
//		Worker worker = restTemplate.getForObject(urlhrworker, Worker.class, uriVariables);
//		Payment payment = new Payment(worker.getName(),Double.valueOf(worker.getDailyIncome()), days);
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		Payment payment = new Payment(worker.getName(),Double.valueOf(worker.getDailyIncome()), days);
		return payment;
	}
	
	
	
}
