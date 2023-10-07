/*
 * Kyle Krstulich
 * 10/6/23
 * ArrayHelper.java
 * 
 * 
    Please implement the library ArrayHelper.java (below), and utilize a client to test that your functions are working...

    indexOf - returns the first occurrence of the integer i in myArray.  If the value is not found in myArray then the function should return -1.

    concat - returns a single integer array which contains values in baseArray followed by values in arrayToConcatenate.



    avg - returns the average value in myArray.



    max - returns the max value in myArray.



    min - returns the min value in myArray.



    shuffle - shuffles the values in myArray in a random order.



    print - prints the values of myArray to StdOut on a single line separated by tab (i.e., use escape sequences).



    initialize - returns an integer array of length n initialized with initialValue.



    flatten - returns a single dimensional array with values of my2DArray within it (make sure this works for ragged arrays*)




    public class ArrayHelper
 */
public class ArrayHelper {

    /*
    Description:

        Searches for the index of the first occurrence of a specific integer value within an integer array. If the value is found, the method returns the index of 
        the value; otherwise, it returns -1.

    Parameters:

        arrayInput (int[]): The integer array in which the search for valueToFind is performed.
        valueToFind (int): The integer value to be found within the array.
    Returns:

        int: The index of the first occurrence of valueToFind within the array, or -1 if the value is not found in the array.

    This method iterates through the elements of the arrayInput and compares each element to the valueToFind. If a matching value is found, the method returns the
    index of that value in the array. If no match is found after iterating through the entire array, the method returns -1 to indicate that the value was not found
    in the array. The original array remains unchanged.
    */
    public static int indexOf(int[] arrayInput, int valueToFind){
        int index = -1;
        int size = arrayInput.length;
        int currentValue;

        for(int i = 0; i < size; i++){
            currentValue = arrayInput[i];

            if(currentValue == valueToFind){
                index = i;
                break;
            }

        }
        return index;
    }

    /*
    Description:

        Concatenates (combines) two integer arrays, originalArray and newArray, into a single integer array, outputArray, where the elements of newArray follow those of originalArray.

    Parameters:

        originalArray (int[]): The original integer array to which newArray will be concatenated.
        newArray (int[]): The integer array to be concatenated to originalArray.

    Returns:

        int[]: A new integer array containing the concatenated elements from originalArray followed by newArray.

    This method takes two integer arrays, originalArray and newArray, and creates a new integer array, outputArray, with a size equal to the sum of the sizes of the two input arrays.
    It uses the System.arraycopy method to copy the elements from originalArray into the beginning of outputArray and the elements from newArray into the remaining portion of outputArray. 
    The result is a new array containing the elements from both input arrays in sequential order. The original arrays originalArray and newArray remain unchanged, and the method returns 
    the concatenated outputArray.
     */
    public static int[] concat(int[] originalArray, int[] newArray){
        int originalSize = originalArray.length;
        int newSize = newArray.length;
        int[] outputArray = new int[originalSize+newSize];

        System.arraycopy(originalArray, 0, outputArray, 0, originalSize);
        System.arraycopy(newArray, 0, outputArray, originalSize, newSize);

        return outputArray;
    }

    /*
    Description:
        
        Calculates and returns the average (arithmetic mean) of all the integer values in an integer array.

    Parameters:

        arrayInput (int[]): The integer array for which the average value will be calculated.

    Returns:

        int: The average (arithmetic mean) of all the integer values in the array.
        
    This method calculates the average of all the integer values in the arrayInput by summing up all the values and dividing the sum by the number of values in the array. 
    The result is an integer representing the average value. Note that if the division results in a fractional value, the result is truncated to an integer, and the fractional 
    part is discarded. The original array remains unchanged.
     */
    public static int avg(int[] arrayInput){
        int size = arrayInput.length;
        int averageValue = 0;

        for(int i = 0; i< size; i++){
            averageValue+= arrayInput[i];
        }
        return averageValue/size;
    }
    
    /*
    Description:

        Finds and returns the maximum (largest) integer value in an integer array.

    Parameters:

        arrayInput (int[]): The integer array in which to find the maximum value.

    Returns:

        int: The maximum (largest) integer value in the array.

    This method iterates through the elements of the arrayInput and keeps track of the current maximum value encountered. It compares each element to the current maximum value, 
    updating the maximum if the current element is greater. After iterating through the entire array, the method returns the maximum value found. The original array remains unchanged.
     */
    public static int max(int[] arrayInput){
        int size = arrayInput.length;
        int maxValue = 0;
        int currentValue = 0;

        for(int i = 0; i < size; i++){
            currentValue = arrayInput[i];

            if (currentValue > maxValue){
                maxValue = currentValue;
            }
            
        }

        return maxValue;
    }

    /*
    Description:

        Finds and returns the minimum (smallest) integer value in an integer array.

    Parameters:

        arrayInput (int[]): The integer array in which to find the minimum value.

    Returns:

        int: The minimum (smallest) integer value in the array.

    This method initializes the minValue variable with the first element of the arrayInput and then iterates through the remaining elements of the array. It compares each element to the current minValue, 
    updating the minValue if the current element is smaller. After iterating through the entire array, the method returns the minimum value found. The original array remains unchanged.
     */
    public static int min(int[] arrayInput){
        int size = arrayInput.length;
        int minValue = arrayInput[0];
        int currentValue = 0;

        for(int i = 0; i < size; i++){
            currentValue = arrayInput[i];

            if (currentValue < minValue){
                minValue = currentValue;
            }
        }
        return minValue;
    }

    /*
    Description:

        Shuffles (randomly reorders) the elements of an integer array using the Fisher-Yates shuffle algorithm.

    Parameters:

        arrayInput (int[]): The integer array to be shuffled.

    Returns:

        int[]: A shuffled version of the input integer array.

    This method applies the Fisher-Yates shuffle algorithm to shuffle the elements of the arrayInput. It iterates through the elements in reverse order, randomly selecting an index between 0 and 
    the current index (inclusive) and swapping the element at the current index with the randomly selected element. This process effectively shuffles the elements into a random order. The original array 
    arrayInput is modified, and the shuffled array is returned.
     */
    public static int[] shuffle(int[] arrayInput){
        int randomIndex,temp;
        int size = arrayInput.length - 1;

        for(int i = size; i >= 0; i--){
            randomIndex = (int) (Math.random() * i) + 1;
            temp = arrayInput[randomIndex];
            arrayInput[randomIndex] = arrayInput[i];
            arrayInput[i] = temp; 
        }

        return arrayInput;
    }

    /*
    Description:

        Prints the elements of an integer array to the command line, separated by spaces, followed by a new line.

    Parameters:

        arrayInput (int[]): The integer array to be printed.

    Returns:
        
        None

    This method takes an integer array arrayInput and prints its elements to the command line. Each element is followed by a space, and the entire array is printed on a single line. After printing all 
    the elements, a new line is added to separate the output from the subsequent content. The method does not modify the array and is solely responsible for printing its contents in a readable format.
     */
    public static void print(int[] arrayInput){
        int size = arrayInput.length;

        for(int i = 0; i < size; i++){
            System.out.print(arrayInput[i] + " ");
        }
        System.out.println();
    }

    /*
    Description:

        Initializes a new integer array of a specified length, setting all elements to a given initial value.

    Parameters:

        length (int): The desired length of the new integer array.
        initialValue (int): The initial integer value to set for all elements in the array.

    Returns:

        int[]: A new integer array of the specified length with all elements initialized to the provided initialValue.

    This method creates a new integer array with a specified length length and initializes all elements in the array to the provided initialValue. It uses a loop to set each element in the array 
    to the specified initial value. The method returns the newly created and initialized array.
     */
    public static int[] init(int length, int initialValue){
        int[] outputArray = new int[length];
        int size = length;
        for(int i = 0; i < size; i++){
            outputArray[i] = initialValue;
        }
        return outputArray;
    }

    /*
    Description:
    
        Flattens a 2D integer array (arrayInput) into a 1D integer array (outputArray) by combining all the elements row-wise.

    Parameters:

        arrayInput (int[][]): The 2D integer array to be flattened.

    Returns:

        int[]: A 1D integer array containing all the elements from arrayInput, arranged in a linier sequence.

    This method takes a 2D integer array arrayInput and flattens it into a 1D integer array outputArray. It does this by initializing outputArray with the elements from the first 
    row of arrayInput. Then, it iterates through the remaining rows of arrayInput and concatenates each row to the existing outputArray using the concat method. The result is a single, 
    linear array that contains all the elements from the input array, arranged sequentially. The original 2D array arrayInput remains unchanged.
     */
    public static int[] flatten(int[][] arrayInput){
        int size = arrayInput.length;
        int index = 0;
        int[] outputArray = arrayInput[0];

        for(int i = 1; i < size; i++){
            outputArray = concat(outputArray, arrayInput[i]); 
        } 


        return outputArray;
    }

    public static void main(String[] args) {
        int[][] multiArray = {{1,2,3},{4,5},{7}};
        int[] flatMultiArray = flatten(multiArray);
        int[] initArray = init(5, 7);
        int[] arrayOne = {1,2,3};
        int[] arrayTwo = {4,5,6};
        int[] arrayOnePlusTwo = concat(arrayOne, arrayTwo);

        print(arrayOnePlusTwo);
        print(initArray);
        print(flatMultiArray);
        flatMultiArray = shuffle(flatMultiArray);
        print(flatMultiArray);
        System.out.println("Max: " + max(flatMultiArray));
        System.out.println("Min: " + min(flatMultiArray));
        System.out.println("Avg: " + avg(flatMultiArray));
        System.out.println("Index at: " + indexOf(arrayOnePlusTwo, 4));
        
    }
    
}
