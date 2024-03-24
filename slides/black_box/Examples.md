### Answer for the Example 3.2

---

#### Output Domain (O):

- O1 = {"Fail"}
- O2 = {"Third Division"}
- O3 = {"Second Division"}
- O4 = {"First Division"}
- O5 = {"Distinction"}
- O6 = {"Invalid Score"}

#### Input Domain (I):

- I1: {m < 0}

- I1: {0 ≤ m ≤ 39}

- I2: {40 ≤ m ≤ 49}

- I3: {50 ≤ m ≤ 59}

- I4: {60 ≤ m < 79}

- I5: {80 ≤ m ≤ 100}

- I7: {m > 100}

### Test Cases in Tabular Format

| Test Case ID | Input Score (x) | Expected Output |
| ------------ | --------------- | --------------- |
| TC0          | -1              | Invalid Score   |
| TC1          | 20              | Fail            |
| TC2          | 45              | Third Division  |
| TC3          | 55              | Second Division |
| TC4          | 65              | First Division  |
| TC5          | 85              | Distinction     |
| TC6          | 101             | Invalid Score   |

**Implementation**

```java
public class GradingSystem {

    public static String gradeStudent(int score) {
        if (score < 0 || score > 100) {
            return "Invalid Score";
        } else if (score <= 39) {
            return "Fail";
        } else if (score <= 49) {
            return "Third Division";
        } else if (score <= 59) {
            return "Second Division";
        } else if (score <= 79) {
            return "First Division";
        } else {
            return "Distinction";
        }
    }
}
```



**JUnit Test Cases for Grading System**

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GradingSystemTest {

    @Test
    void testInvalidScoreNegative() {
        assertEquals("Invalid Score", GradingSystem.gradeStudent(-5), "Score -5 should be considered an Invalid Score.");
    }

    @Test
    void testFailGrade() {
        assertEquals("Fail", GradingSystem.gradeStudent(20), "Score 20 should result in Fail.");
    }

    @Test
    void testThirdDivisionGrade() {
        assertEquals("Third Division", GradingSystem.gradeStudent(45), "Score 45 should result in Third Division.");
    }

    @Test
    void testSecondDivisionGrade() {
        assertEquals("Second Division", GradingSystem.gradeStudent(55), "Score 55 should result in Second Division.");
    }

    @Test
    void testFirstDivisionGrade() {
        assertEquals("First Division", GradingSystem.gradeStudent(65), "Score 65 should result in First Division.");
    }

    @Test
    void testDistinctionGrade() {
        assertEquals("Distinction", GradingSystem.gradeStudent(85), "Score 85 should result in Distinction.");
    }

    @Test
    void testInvalidScoreAboveRange() {
        assertEquals("Invalid Score", GradingSystem.gradeStudent(105), "Score 105 should be considered an Invalid Score.");
    }
}
```



### Answer for the Example 3.3

**The inputs should adhere to the following constraints:**

- Months range from 1 to 12.
- Days range from 1 to 31.
- Years range from 1900 to 2025.
- The program should output either the previous day's date or indicate if the input date is invalid.

### Answer for Part (a): Equivalence Class Test Cases

#### Input Domain Equivalence Classes

1. We may have another set of test cases which are based on input domain.

   I1={month: 1 ≤ m ≤ 12}

   I2={month: m < 1}

   I3={month: m > 12}

   I4={day: 1 ≤ D ≤ 31}

   I5={day: D < 1}

   I6={day: D > 31}

   I7={year: 1900 ≤ Y ≤ 2025}

   I8={year: Y < 1900}

   I9={year: Y > 2025}

![image-20240317170738934](C:\Users\SFY\AppData\Roaming\Typora\typora-user-images\image-20240317170738934.png)

#### Output Domain Equivalence Classes

1. **Previous Date:** Any valid input date should output the correct previous date, considering month boundaries and leap years.

2. **Invalid Input Date:** Any date input that falls outside the valid ranges or is not a valid calendar date.

   O1={<D,M,Y>: Previous date if all are valid inputs}

   O2={<D,M,Y>: Invalid date if any input makes the date invalid}

![image-20240317170914678](C:\Users\SFY\AppData\Roaming\Typora\typora-user-images\image-20240317170914678.png)

### Answer for Part (b): Implementation

Here's a simple Java program that calculates the previous day's date. This program does not account for all the intricacies of a complete date handling library but serves as a basic example.

```
javaCopy codeimport java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PreviousDateCalculator {

    public static void main(String[] args) {
        // Example input
        String inputDate = "1/3/2021"; // Format: d/M/yyyy
        calculatePreviousDate(inputDate);
    }

    public static void calculatePreviousDate(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        
        try {
            LocalDate date = LocalDate.parse(inputDate, formatter);
            // Validate year within range
            if (date.getYear() < 1900 || date.getYear() > 2025) {
                System.out.println("Invalid input date");
                return;
            }
            
            LocalDate previousDate = date.minusDays(1);
            System.out.println("Previous date: " + previousDate.format(formatter));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid input date");
        }
    }
}
```

This program uses Java's `LocalDate` and `DateTimeFormatter` classes to handle the date parsing and subtraction, providing a straightforward approach to calculating the previous date. The main focus is on checking the year range and catching any parsing errors to handle invalid dates. Note that this approach inherently validates the day and month since `LocalDate.parse()` throws a `DateTimeParseException` for invalid day-month combinations.



Implementation testing cases (based on the outputs domains).

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreviousDateCalculatorTest {

    @Test
    public void testValidPreviousDate() {
        // Testing a valid date
        assertEquals("28/2/2021", PreviousDateCalculator.calculatePreviousDate("1/3/2021"),
            "Calculating the previous date of March 1, 2021, should return February 28, 2021.");
    }

    @Test
    public void testInvalidDate() {
        // Testing an invalid date (out of range year)
        assertEquals("Invalid input date", PreviousDateCalculator.calculatePreviousDate("1/1/2026"),
            "Input date with year out of range should return 'Invalid input date'.");
    }

    @Test
    public void testLeapYear() {
        // Testing a valid leap year date
        assertEquals("29/2/2020", PreviousDateCalculator.calculatePreviousDate("1/3/2020"),
            "Calculating the previous date of March 1, 2020, a leap year, should return February 29, 2020.");
    }

    @Test
    public void testInvalidFormatDate() {
        // Testing an invalid date format
        assertEquals("Invalid input date", PreviousDateCalculator.calculatePreviousDate("31/02/2021"),
            "Input date with invalid day-month combination should return 'Invalid input date'.");
    }
}
```



