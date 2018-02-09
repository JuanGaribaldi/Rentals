package garibaldi_juan.rentals.model;

import java.math.BigDecimal;


public class WeeklyRental extends Rental {

	private static BigDecimal TIME_UNIT_COST = new BigDecimal(60);
	private static long TIME_UNIT = 1000 * 60 * 60 * 24 * 7;
	
	public WeeklyRental() {
		super(TIME_UNIT_COST, TIME_UNIT);
	}

	public WeeklyRental(long rentalStart) {
		super(TIME_UNIT_COST, TIME_UNIT, rentalStart);
	}
	
}
