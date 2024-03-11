package com.example;

public class ArrayMaxFinder {
	/*
	 * 1. Check if the Array is empty or not
	 * 2.      if true, the process leads to an exception throw
	 * 3.      else, continue to the next activity
	 * 4. Initializa 'max' with First Array Element: sets up the initial condition for comparsion.
	 * 5. Loop through Each Array Element Starting from Index 1: 
	 * 6.   Within the loop, a decision node checks if the current element is greater thasn `max`
	 * 7.   if true, update `max` within the current element value
	 * 8.   else , proceed with the loop
	 * 9. Returen `max`: Once all elements have been checked, the process moves to return the `max` value
	 * 10. End: The conclusion of the activity 
	 */
	public int findMaxValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
