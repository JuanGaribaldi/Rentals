package garibaldi_juan.rentals.model;

import java.math.BigDecimal;

public class DailyRental extends Rental {

	private static BigDecimal TIME_UNIT_COST = new BigDecimal(20);
	private static long TIME_UNIT = 1000 * 60 * 60 * 24;
	
	public DailyRental() {
		super(TIME_UNIT_COST, TIME_UNIT);
	}

	public DailyRental(long rentalStart) {
		super(TIME_UNIT_COST, TIME_UNIT, rentalStart);
	}
	
}
