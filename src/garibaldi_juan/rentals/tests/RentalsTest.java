package garibaldi_juan.rentals.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import garibaldi_juan.rentals.model.*;
import garibaldi_juan.rentals.model.exceptions.FamilyRentalsWrongSizeException;

public class RentalsTest {

	@Test
	public void HourlyRental_NoEndDateTest() {
		HourlyRental rental = new HourlyRental();
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(5), result);
	}

	@Test
	public void HourlyRental_WithConstructorStartDateTest() {
		HourlyRental rental = new HourlyRental(System.currentTimeMillis());
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.MINUTE, 61);
		rental.setEndDate(endDate.getTimeInMillis());
		
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(10), result);
	}

	@Test
	public void HourlyRental_WithMethodEndDateTest() {
		HourlyRental rental = new HourlyRental();
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.MINUTE, 61);
		rental.setEndDate(endDate.getTimeInMillis());
		
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(10), result);
	}

	@Test
	public void DailyRental_NoEndDateTest() {
		DailyRental rental = new DailyRental();
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(20), result);
	}

	@Test
	public void DailyRental_WithConstructorStartDateTest() {
		DailyRental rental = new DailyRental(System.currentTimeMillis());
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.HOUR_OF_DAY, 25);
		rental.setEndDate(endDate.getTimeInMillis());
		
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(40), result);
	}

	@Test
	public void DailyRental_WithMethodEndDateTest() {
		DailyRental rental = new DailyRental();
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.HOUR_OF_DAY, 25);
		rental.setEndDate(endDate.getTimeInMillis());
		
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(40), result);
	}

	@Test
	public void WeeklyRental_NoEndDateTest() {
		WeeklyRental rental = new WeeklyRental();
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(60), result);
	}

	@Test
	public void WeeklyRental_WithConstructorEndDateTest() {
		WeeklyRental rental = new WeeklyRental(System.currentTimeMillis());
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.DAY_OF_YEAR, 8);
		rental.setEndDate(endDate.getTimeInMillis());
		
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(120), result);
	}

	@Test
	public void WeeklyRental_WithMethodEndDateTest() {
		WeeklyRental rental = new WeeklyRental();
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.DAY_OF_YEAR, 8);
		
		rental.setEndDate(endDate.getTimeInMillis());
		BigDecimal result = rental.calculateCost();
		
		assertEquals(new BigDecimal(120), result);
	}

	@Test
	public void FamilyRental_OneOfEachWrongSizeLowerTest() {
		DailyRental dailyRental = new DailyRental();
		HourlyRental hourlyRental = new HourlyRental();
		WeeklyRental weeklyRental = new WeeklyRental();
		
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		rentals.add(dailyRental);
		rentals.add(hourlyRental);
		
		boolean failed = false;

		FamilyRental rental = new FamilyRental();
		try {
			rental.setRentals(rentals);
		} catch (FamilyRentalsWrongSizeException e) {
			failed = true;
		}
		
		assertTrue(failed);
	}

	@Test
	public void FamilyRental_OneOfEachWrongSizeHigherTest() {
		DailyRental dailyRental = new DailyRental();
		HourlyRental hourlyRental = new HourlyRental();
		WeeklyRental weeklyRental = new WeeklyRental();
		
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		rentals.add(dailyRental);
		rentals.add(dailyRental);
		rentals.add(hourlyRental);
		rentals.add(hourlyRental);
		rentals.add(weeklyRental);
		rentals.add(weeklyRental);
		
		boolean failed = false;
		
		FamilyRental rental = new FamilyRental();
		try {
			rental.setRentals(rentals);
		} catch (FamilyRentalsWrongSizeException e) {
			e.printStackTrace();
			failed = true;
		}
		
		assertTrue(failed);
	}

	@Test
	public void FamilyRental_OneOfEachNoEndDateTest() {
		DailyRental dailyRental = new DailyRental();
		HourlyRental hourlyRental = new HourlyRental();
		WeeklyRental weeklyRental = new WeeklyRental();
		
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		rentals.add(dailyRental);
		rentals.add(hourlyRental);
		rentals.add(weeklyRental);
		
		FamilyRental rental = new FamilyRental();
		try {
			rental.setRentals(rentals);
		} catch (FamilyRentalsWrongSizeException e) {
			e.printStackTrace();
			assertFalse(true);
		}
		
		BigDecimal result = rental.calculateCost();
		
		BigDecimal expectedResult = new BigDecimal(85);
		expectedResult = expectedResult.multiply(new BigDecimal(0.7));

		assertEquals(expectedResult, result);
	}

	@Test
	public void FamilyRental_OneOfEachWithEndDateTest() {
		DailyRental dailyRental = new DailyRental();
		HourlyRental hourlyRental = new HourlyRental();
		WeeklyRental weeklyRental = new WeeklyRental();
		
		Calendar dailyEndDate = Calendar.getInstance();
		dailyEndDate.add(Calendar.HOUR_OF_DAY, 25);
		dailyRental.setEndDate(dailyEndDate.getTimeInMillis());

		Calendar hourlyEndDate = Calendar.getInstance();
		hourlyEndDate.add(Calendar.MINUTE, 61);
		hourlyRental.setEndDate(hourlyEndDate.getTimeInMillis());

		Calendar weeklyEndDate = Calendar.getInstance();
		weeklyEndDate.add(Calendar.DAY_OF_YEAR, 8);
		weeklyRental.setEndDate(weeklyEndDate.getTimeInMillis());

		ArrayList<Rental> rentals = new ArrayList<Rental>();
		rentals.add(dailyRental);
		rentals.add(hourlyRental);
		rentals.add(weeklyRental);
		
		FamilyRental rental = new FamilyRental();
		try {
			rental.setRentals(rentals);
		} catch (FamilyRentalsWrongSizeException e) {
			e.printStackTrace();
			fail();
		}
		
		BigDecimal result = rental.calculateCost();
		
		BigDecimal expectedResult = new BigDecimal(170);
		expectedResult = expectedResult.multiply(new BigDecimal(0.7));

		assertEquals(expectedResult, result);
	}

}
