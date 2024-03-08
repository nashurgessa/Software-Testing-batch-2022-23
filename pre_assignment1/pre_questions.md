### Pre-assignment Tasks
---
1. List the benefits of writing Test first.
2. Discuss the difference between traditional methodologies where coding precedes testing and Test-Driven development(TDD) methodology where the test cases are written before the actual implementation code.
3. What is exception handling? Explain with example.
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