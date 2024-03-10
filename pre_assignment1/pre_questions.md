### Pre-assignment Tasks
---
1. What is exception handling? Explain with example.
2. List the benefits of writing Test first.
3. Discuss the difference between traditional methodologies where coding precedes testing and Test-Driven development(TDD) methodology where the test cases are written before the actual implementation code.
---
4. **(a).** Robust implementation in different prograaming language: Implement a robust method or function to calculate the area of a rectangle using two inputs: width and length. You are required to provide implementations in both **Java** and **Python**. After implementing, briefly discuss the key aspects that make your code robust.
**(b).** Inside the main method of each implementation, write test cases to demonstrate the functionality of your method. Include scenarios that show normal operation, as well as cases that should trigger your error handling. This will help illustrate how your code behaves under various conditions.

5. Implement test cases for an Array Element Counter

```java
public class ArrayElementCounter {
	public int countOccurrences(int[] array, int element) {
		int count = 0;
		for (int i : array) {
			if (i == element) {
				count++;
			}
		}
		return count;
	}
}
```

> **The test cases should cover the following:**
> - **Normal Case:** Test with an array containing several elements, including the target element.
> - **No Occurrence:** Test with an array that does not contain the target element.
> - **Multiple Occurrences:** Test with an array where the target element occurs multiple times.
> - **Empty Array:** Test with an empty array to ensure no errors occur.
> - **Negative and Zero Values:** Test with an array containing negative numbers and zero, including these as target elements.

6. Write comprehensive test case of basic Calculator class for the divide, methods of the Calculator class. The test cases should cover both normal and edge cases and for the divide method, include a test case for divison by zero.

7. Inventory Management System




---
**Answers**
1. **What is exception handling? Explain with example.** 
> Exception handling in programming is a mechanism that deals with **runtime errors**, maintaining the normal flow of the application. An exception is an event that occurs during the execution of a program that **disrupts the normal flow of instructions**. Exception handling ensures that the code can handle these **errors gracefully without crashing**.

> In Java, exception handling is managed through five keywords: **`try`**, **`catch`**, **`finally`**, **`throw`**, and **`throws`**.
> (1) **try:** The try block contains a set of statements where an exception can occur. 
> (2) **catch:** The catch block is used to handle the exception. It must be used after the try block only. You can have multiple catch blocks for different types of exceptions. 
> (3) **finally:** The finally block is used to execute a set of statements, regardless of whether an exception is caught or not. It is often used to close resources like files or databases. 
> (4) **throw:** This keyword is used to explicitly throw an ***exception*** from a ***method*** or any block of code. 
> (5) **throws:** The throws keyword is used in ***method signatures*** to declare the exceptions that a method might throw.

**syntax**
```java

try {
	// statement
} catch(args e) {
	// statement, throw
} finally {
	// statement
}
```

2. **Benefits of Writing Test First**
> 1. Early Bug Detection
> 2. Design Quality
> 3. Refactoring and Code Maintenance
> 4. Clear Requirementrs


3. 
> Test-Driven Development (TDD) is a software development methodology where test cases are written before the actual implementation code. In TDD, developers first define the specifications and requirements through tests, then write code to pass these tests. This differs from traditional methodologies where coding precedes testing.

> ***Challenges and Considerations Challenges or Limitations:***
> - **Time-Consuming:** Initially, TDD can be more time-consuming, as writing tests before implementation requires additional upfront effort.
> - **Learning Curve:** There's a learning curve associated with adopting TDD, especially for teams used to traditional development methods.
> - **Complex Scenarios:** In complex scenarios, defining tests upfront can be challenging, potentially limiting the effectiveness of TDD.