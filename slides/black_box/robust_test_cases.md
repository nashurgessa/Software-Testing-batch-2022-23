
## BlackBox Testing
---




### Practical questions on BVA

1. Consider the program for the determination of nature of roots of a quadratic equation as explained in example 8.1. Design the Robust test case and worst test cases for this program.

***Solution***
a) Robust test cases are 6n+1. Hence, in 3 variable input cases total number of test cases are 19:
| **Test Case** |  **a**   |**b**  |**c**|**Expected Output**|
|---------------|----------|-------|-----|-------------------|
|1|-1|50|50| Invalid Input|
|2|0|50|50|Not quadratic equation|
|3|1|50|50| Real roots|
|4|50|50|50|Imaginary roots|
|5|99|50|50|Imaginary roots|
|6|100|50|50|Imaginary roots|
|7|101|50|50| Invalid input|
|8|50|-1|50| Invalid Input|
|9|50|0|50|Imaginary roots|
|10|50|1|50|Imaginary roots|
|11|50|99|50|Imaginary roots|
|12|50|100|50|Equal roots|
|13|50|101|50|Invalid input|
|14|50|50|-1| Invalid Input|
|15|50|50|0|Real roots|
|16|50|50|1|Real roots|
|17|50|50|99|Imaginary roots|
|18|50|50|100|Imaginary roots|
|19|50|50|101|invalid input|
---


b) In case of worst test case total cases are **5<sup>n</sup>**. Hence, **125** test cases will be generated in worst test cases. The worst test cases are given below:
| **Test Case** |  **a**   |**b**  |**c**|**Expected Output**|
|---------------|----------|-------|-----|-------------------|
|1|0|0|0|Not Quadratic|
|2|0|0|1|Not Quadratic|
|3|0|0|50|Not Quadratic|
|4|0|0|99|Not Quadratic|
|5|0|0|100|Not Quadratic|
|6|0|1|0|Not Quadratic|
|7|0|1|1|Not Quadratic|
|8|0|1|50|Not Quadratic|
|9|0|1|99|Not Quadratic|
|10|0|1|100|Not Quadratic|
|11|0|50|0|Not Quadratic|
|12|0|50|1|Not Quadratic|
|13|0|50|50|Not Quadratic|
|14|0|50|99|Not Quadratic|
|15|0|50|100|Not Quadratic|
|16|0|99|0|Not Quadratic|
|17|0|99|1|Not Quadratic|
|18|0|99|50|Not Quadratic|
|19|0|99|99|Not Quadratic|
|20|0|99|100|Not Quadratic|
|21|0|100|0|Not Quadratic|
|22|0|100|1|Not Quadratic|
|23|0|100|50|Not Quadratic|
|24|0|100|99|Not Quadratic|
|25|0|100|100|Not Quadratic|
|26|1|0|0|Equal Roots|
|27|1|0|1|Imaginary|
|28|1|0|50|Imaginary|
|29|1|0|99|Imaginary|
|30|1|0|100|Imaginary|
|31|1|1|0|Real Roots|
|32|1|1|1|Imaginary|
|33|1|1|50|Imaginary|
|34|1|1|99|Imaginary|
|35|1|1|100|Imaginary|
|36|1|50|0|Real Roots|
|37|1|50|1|Real Roots|
|38|1|50|50|Real Roots|
|39|1|50|99|Real Roots|
|40|1|50|100|Real Roots|
|41|1|99|0|Real Roots|
|42|1|99|1|Real Roots|
|43|1|99|50|Real Roots|
|44|1|99|99|Real Roots|
|45|1|99|100|Real Roots|
|46|1|100|0|Real Roots|
|47|1|100|1|Real Roots|
|48|1|100|50|Real Roots|
|49|1|100|99|Real Roots|
|50|1|100|100|Real Roots|
|51|50|0|0|Equal Roots|
|52|5|0|1|Imaginary|
|53|50|0|50|Imaginary|
|54|50|0|99|Imaginary|
|55|50|0|100|Imaginary|
|56|50|1|0|Real Roots|
|57|50|1|1|Imaginary|
|58|50|1|50|Imaginary|
|59|50|1|99|Imaginary|
|60|50|1|100|Imaginary|
|61|50|50|0|Real Roots|
|62|50|50|1|Real Roots|
|63|50|50|50|Imaginary|
|64|50|50|99|Imaginary|
|65|50|50|100|Imaginary|
|66|50|99|0|Real Roots|
|67|50|99|1|Real Roots|
|68|50|99|50|Imaginary|
|69|50|99|99|Imaginary|
|70|50|99|100|Imaginary|
|71|50|100|0|Real Roots|
|72|50|100|1|Real Roots|
|73|50|100|50|Real Roots|
|74|50|100|99|Imaginary|
|75|50|100|100|Imaginary|
|76|99|0|0|Equal Roots|
|77|99|0|1|Imaginary|
|78|99|0|50|Imaginary|
|79|99|0|99|Imaginary|
|80|99|0|100|Imaginary|
|81|99|1|0|Real Roots|
|82|99|1|1|Imaginary|
|83|99|1|50|Imaginary|
|84|99|1|99|Imaginary|
|85|99|1|100|Imaginary|
|86|99|50|0|Real Roots|
|87|99|50|1|Real Roots|
|88|99|50|50|Imaginary|
|89|99|50|99|Imaginary|
|90|99|50|100|Imaginary|
|91|99|99|0|Real Roots|
|92|99|99|1|Real Roots|
|93|99|99|50|Imaginary|
|94|99|99|99|Imaginary|
|95|99|99|100|Imaginary|
|96|99|100|0|Real Roots|
|97|99|100|1|Real Roots|
|98|99|100|50|Imaginary|
|99|99|100|99|Imaginary|
|100|99|100|100|Imaginary|
|101|100|0|0|Equal Roots|
|102|100|0|1|Imaginary|
|103|100|0|50|Imaginary|
|104|100|0|99|Imaginary|
|105|100|0|100|Imaginary|
|106|100|1|0|Real Roots|
|107|100|1|1|Imaginary|
|108|100|1|50|Imaginary|
|109|100|1|99|Imaginary|
|110|100|1|100|Imaginary|
|111|100|50|0|Real Roots|
|112|100|50|1|Real Roots|
|113|100|50|50|Imaginary|
|114|100|50|99|Imaginary|
|115|100|50|100|Imaginary|
|116|100|99|0|Real Roots|
|117|100|99|1|Real Roots|
|118|100|99|50|Imaginary|
|119|100|99|99|Imaginary|
|120|100|99|100|Imaginary|
|121|100|100|0|Real Roots|
|122|100|100|1|Real Roots|
|123|100|100|50|Imaginary|
|124|100|100|99|Imaginary|
|125|100|100|100|Imaginary|
