# Rentals

  This project was created to fulfill the following request:
  
  A company rents bikes under following options:

  1. Rental by hour, charging $5 per hour
  2. Rental by day, charging $20 a day
  3. Rental by week, changing $60 a week
  4. Family Rental, is a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% of the total price

  Assigment:
  1. Implement a set of classes to model this domain and logic
  2. Add automated tests to ensure a coverage over 85%
  3. Use GitHub to store and version your code
  4. Apply all the recommended practices you would use in a real project
  5. Add a README.md file to the root of your repository to explain: your design, the development practices you applied and how run the tests.

# Design
  My design consists of the following classes:
  
  * Rental: the parent class consisting of the cost of the time unit -hour, day or week-, the start date and end date of the rental, the constructors and methods used to set the and date and the calculateCost method.
  * HourlyRental, DailyRental and WeeklyRental only specify the constructors, cost and time unit to be used on calculateCost.
  * FamilyRental: overrides Rental's calculateCost method, as the Family rental has between 3 and 5 rentals, so to get the cost we have to sum each of the individual rentals' cost and then multiply that sum by 0.7 to get the 30% discount applied.
  * FamilyRentalsWrongSizeException: this exception was created to signal the possibility of adding an incorrect amount of rentals to a family rental.
  * RentalsTest: class containing all of the tests to be applied. Currently achieves a 93.8% coverage.

# Tests
To run the tests:

* Use Eclipse's option Coverage As -> Coverage Configurations... 
* Configure the test to "Run all test in the selected project, package or source folder:" garibaldi_juan.rentals.tests
* Select JUnit4 as the Test runner
* Apply the configuration
* Click the Coverage button

# P.S
During the setup of the project you might have to configure the JRE used as the JDK -specifically the 1.8.0_162 version- due to a missing library -tools.jar- error.
