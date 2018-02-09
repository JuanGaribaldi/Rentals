package garibaldi_juan.rentals.model;

import java.math.BigDecimal;

public class HourlyRental extends Rental {

	private static BigDecimal TIME_UNIT_COST = new BigDecimal(5);
	private static long TIME_UNIT = 1000 * 60 * 60;
	
	public HourlyRental() {
		super(TIME_UNIT_COST, TIME_UNIT);
	}

	public HourlyRental(long rentalStart) {
		super(TIME_UNIT_COST, TIME_UNIT, rentalStart);
	}

}
