package garibaldi_juan.rentals.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import garibaldi_juan.rentals.model.exceptions.FamilyRentalsWrongSizeException;

public class FamilyRental extends Rental {

	private ArrayList<Rental> rentals;

	public FamilyRental() {
		
	}

	public FamilyRental(ArrayList<Rental> rentals) throws FamilyRentalsWrongSizeException {
		if (rentals.size() < 3 || rentals.size() > 5) {
			throw new FamilyRentalsWrongSizeException(rentals.size());
		}
		this.rentals = rentals;
	}


	@Override
	public BigDecimal calculateCost() {
		BigDecimal result = BigDecimal.ZERO;
		
		for (Rental rental : rentals) {
			result = result.add(rental.calculateCost());
		}
		
		result = result.multiply(new BigDecimal(0.7));
		
		return result;
	}
	
	public void setRentals(ArrayList<Rental> rentals) throws FamilyRentalsWrongSizeException {
		if (rentals.size() < 3 || rentals.size() > 5) {
			throw new FamilyRentalsWrongSizeException(rentals.size());
		}
		
		this.rentals = rentals;
	}

}
