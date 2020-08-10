package com.example.offer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);

		OfferRepository offerRepository = context.getBean(OfferRepository.class);
		FeeRepository feeRepository = context.getBean(FeeRepository.class);
		PurchaseRepository purchaseRepository = context.getBean(PurchaseRepository.class);


		Fee feeOne = feeRepository.save(new Fee(BigDecimal.ONE));
		Fee feeTwo = feeRepository.save(new Fee(BigDecimal.TEN));

		Quote  quote = new Quote(BigDecimal.valueOf(12l), Arrays.asList(feeOne, feeTwo));
		Offer offer = new Offer(quote);

		offer = offerRepository.save(offer);

		Purchase purchase = new Purchase(offer, quote);
		purchaseRepository.save(purchase);

		List<Purchase> purchaseList
				= purchaseRepository.findPurchasesByOfferPrice(BigDecimal.valueOf(12l));

		System.out.println("Purchase found :" + purchaseList.get(0).getId());





	}

}