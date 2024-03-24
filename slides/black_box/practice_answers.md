**Answers**

### 1. 

#### a. Test Cases using Boundary Value Analysis (BVA) and Equivalence Class Testing

#### Boundary Value Analysis (BVA)

For BVA, consider the boundaries around the comparisons. Assume the range of inputs is such that double values can reasonably be compared, focusing on the boundaries where the comparisons change outcome.

* **Case 1:** `A = B = C`: This checks the boundary where all three values are equal.
* **Case 2:** `A = B < C`: Checks the boundary where `A` and `B` are equal and less than `C`.
* **Case 3:** `A < B = C`: Checks the boundary where `B` and `C` are equal and greater than `A`.
* **Case 4:** `A = C < B`: Checks the boundary where `A` and `C` are equal and less than `B`.
* **Case 5:** Values just above and below these equalities to see the switch in logic, e.g., `A = B + ε, C = B - ε` and variations thereof, with ε being a small value.


#### Equivalence Class Testing

Divide inputs into classes where the program is expected to behave similarly for each class.

* **Class 1:** `A > B and A > C` (A is the largest).
* **Class 2:** `B > A and B > C` (B is the largest).
* **Class 3:** `C > A and C > B` (C is the largest).
* **Class 4:** All numbers are equal.

### b. Test Cases for 100% Statement Coverage

To achieve 100% statement coverage, you need to ensure each statement in the program is executed at least once. Based on the structure of the provided program, the following test cases would suffice:

* **Test Case 1:** `A > B > C` (This will cover the path where A is the largest.)
* **Test Case 2:** `C > A > B` (This covers the paths where C is checked against A and then C against B, ensuring all branches are covered.)
* **Test Case 3:** `B > C > A` (Ensures the case where the else branch leading to B being printed is covered.)

These test cases ensure that all `if` conditions and their respective branches (`else`) are executed.

### c. Decision Table for the Program

The decision table represents different conditions and actions based on those conditions. Here, conditions are comparisons between `A`, `B`, and `C`, and actions are the output of the largest number.

| Condition 1 | Condition 2 | Condition 3 | Action  |
| ----------- | ----------- | ----------- | ------- |
| A > B       | A > C       |             | Print A |
| A > B       | A <= C      |             | Print C |
| A <= B      |             | C > B       | Print C |
| A <= B      |             | C <= B      | Print B |

* **Condition 1:** Is A greater than B?
* **Condition 2:** Is A greater than C? (Only checked if A > B)
* **Condition 3:** Is C greater than B? (Checked if A is not greater than B)
