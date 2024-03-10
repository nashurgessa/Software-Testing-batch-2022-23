
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


if __name__ == "__main__":
    area = area_of_a_rectangle(2, 3.0)
    print(area)