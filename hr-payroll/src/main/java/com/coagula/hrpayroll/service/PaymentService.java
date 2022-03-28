package com.coagula.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.coagula.hrpayroll.model.Payment;

@Service
public class PaymentService {

	
	public Payment getPayment(Long workerId, Integer days) {
		Payment payment = new Payment("Lebrao",Double.valueOf(200), days);
		return payment;
	}
	
}
