
def area_of_a_rectangle(width: float, length: float) -> float:
    
    # Check if the we have the correct parameters types
    if not isinstance(width, (float, int)):
        raise TypeError("Width must be a number")
    if type(length) not in [int, float]:
        raise TypeError("length must be a number")
    
    if (width < 0):
        raise ValueError("Width must a positive number")
    if (length < 0):
        raise ValueError("Length must a positive number")
    
    return width * length; 


def test_area_of_rectangle():
    # Test case 1: Normal Case
    try:
        area1 = area_of_a_rectangle(10, 5)
        print(f"The area of rectangle is: {area1}")
    except Exception as e:
        print(f"Error: ", e)
        
    # Test case 2: Negative width
    try:
        area_of_a_rectangle(-2.0, 6.0)
    except ValueError as e:
        print(f"Value Error: ", e) 
        
    # Test case 3: Negative length
    try:
        area_of_a_rectangle(2.0, -6.0)
    except ValueError as e:
        print(f"Value Error: ", e) 
        
    # Test Case 4: Incorrect Type for width
    try:
        area_of_a_rectangle("10", 5)
    except TypeError as e:
        print(f"Type Error: ", e) 
    
    # Test Case 5: Incorrect Type for height
    try:
        area_of_a_rectangle(10, "5")
    except TypeError as e:
        print(f"Type Error: ", e) 


if __name__ == "__main__":
    # Run the tests
    test_area_of_rectangle()