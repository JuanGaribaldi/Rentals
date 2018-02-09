package garibaldi_juan.rentals.model.exceptions;

public class FamilyRentalsWrongSizeException extends Exception {

	public FamilyRentalsWrongSizeException(Integer rentalsAmount) {
		super(String.format("Wrong amount of rentals added on a Family rental plan. %1d", rentalsAmount));
	}
}
