package garibaldi_juan.rentals.model;

import java.math.BigDecimal;

public class Rental {
	protected BigDecimal cost;
	protected long       timeDivider;
	protected long       rentalStart;
	protected long       rentalEnd;

	public Rental() {
		
	}
	
	public Rental(BigDecimal cost, long timeDivider) {
		this(cost, timeDivider, System.currentTimeMillis());
	}

	public Rental(BigDecimal cost, long timeDivider, long rentalStart) {
		this.cost = cost;
		this.timeDivider = timeDivider;
		this.rentalStart = rentalStart;
		System.out.println("Rental - cost = " + cost + " - timeDivider = " + timeDivider + " - rentalStart = " + rentalStart);
	}
	
	public void setEndDate(long endDate) {
		this.rentalEnd = endDate;
	}
	
	public BigDecimal calculateCost() {
		BigDecimal result = BigDecimal.ZERO;
		
		long rentalLength;
		
		if (rentalEnd != 0) {
			rentalLength = rentalEnd - rentalStart;
		} else {
			rentalLength = System.currentTimeMillis() - rentalStart;
		}
		
		System.out.println(rentalLength + " - " + timeDivider);

		if (rentalLength > 0 && rentalLength % timeDivider == 0) {
			rentalLength = rentalLength / timeDivider;
		} else {
			rentalLength = (rentalLength / timeDivider) + 1;			
		}
		
		result = cost.multiply(new BigDecimal(rentalLength));

		System.out.println(cost + " * " + rentalLength + " = " + result);
		
		return result;
	}
}
