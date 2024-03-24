package com.example;

class DiscountCalculator {
	
	public static double calculateDiscount(boolean isNewCustomer, 
		boolean hasLoyalityCard, boolean hasCoupon) {

		double discount = 0.0;

		if(isNewCustomer) {
			discount += 15;
			if (hasCoupon && !hasLoyalityCard) {
				discount = 20;
			}
		} else {
			if (hasLoyalityCard) discount += 10;
			if (hasCoupon) discount += 20;
		}

		return discount;

	}
}
