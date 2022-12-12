package p2_package;

/**
 * 
 * @author zchkf
 *
 */

public class N2_SortDriverClass {

	/**
	 * Default constructor
	 */
	public N2_SortDriverClass()
	{
		
	}
	
	/**
	 * Sorts elements using the bubble sort algorithm
	 * 
	 * @param charArr - character array of items to be sorted
	 * 
	 * @param size - integer value holding the number of characters in the array
	 * 
	 * @return character array of sorted items
	 */
	public static char[] runBubbleSort(char[] charArr, int size)
	{
		boolean isSwap = true; // flag boolean for outter while loop.
		int firstPoint;
		int secondPoint;
		while (isSwap)
		{
			isSwap = false;
			firstPoint = 0;
			secondPoint = 1;
			while(firstPoint < (size - 1)) // make sure there is not index out of bounds error
			{
				if (charArr[firstPoint] > charArr[secondPoint])
				{
					isSwap = true;
					swapValues(charArr, firstPoint, secondPoint);
				}
				firstPoint++;
				secondPoint++;
			}
		}
		return charArr;
	}
	
	/**
	 * Sorts character elements using the insertion sort algorithm
	 * 
	 * @param charArr - character array of items to be sorted
	 * 
	 * @param size - integer value holding the number of characters in the array
	 * 
	 * @return character array of sorted items
	 */
	public static char[] runInsertionSort(char[] charArr, int size)
	{
		int outterIndex = 1;
		int innerIndex;
		char temp;
		while (outterIndex < size) // outter loop runs forward through the array
		{
			innerIndex = outterIndex - 1;
			temp = charArr[outterIndex];
			while (innerIndex >= 0 && charArr[innerIndex] > temp) // inner loop runs backwards through array
			{
				charArr[innerIndex + 1] = charArr[innerIndex];
				innerIndex--;
			}
			charArr[innerIndex+1] = temp;
			outterIndex++;
		}
		return charArr;
	}
	
	/**
	 * Sorts character elements using the selection sort algorithm
	 * 
	 * @param charrArr - character array of items to be sorted
	 * 
	 * @param size - integer value holding the number of characters in the array
	 * 
	 * @return - character array holding list of sorted items
	 */
	public static char[] runSelectionSort(char[] charArr, int size)
	{
		int outterIndex = 0;
		int innerIndex;
		int minIndex;
		while (outterIndex < size)
		{
			minIndex = outterIndex; // sets the smallest index as the first element in the array to begin
			innerIndex = outterIndex + 1;
			while (innerIndex < size) // runs through rest of array to find if there is  a smaller element
			{
				if (charArr[minIndex] > charArr[innerIndex])
				{
					minIndex = innerIndex;
				}
				innerIndex = innerIndex + 1;
			}
			swapValues(charArr, minIndex, outterIndex);
			outterIndex = outterIndex + 1;
		}
		return charArr;
	}
	
	/**
	 * Uses shell's sorting algorithm to sort an array of integers
	 * Shell's sorting algorithm is an optimized insertion algorithm
	 * 
	 * @param charrArr - character array of items to be sorted
	 * 
	 * @param size - integer value holding the number of characters in the array
	 * 
	 * @return - character array holding list of sorted items
	 */
	public static char[] runShellSort(char[] charArr, int size)
	{
		int gap = size / 2;
		int innerIndex;
		int outterIndex;
		char temp;
		while (gap > 0)
		{
			outterIndex = gap;
			while (outterIndex < size)
			{
				temp = charArr[outterIndex];
				innerIndex = outterIndex;
				while(innerIndex >= gap && charArr[innerIndex - gap] > temp)
				{
					charArr[innerIndex] = charArr[innerIndex - gap];
					innerIndex = innerIndex - gap;
				}
				charArr[innerIndex] = temp;
				outterIndex = outterIndex + 1;
			}
			gap = gap / 2;
		}
		return charArr;
	}
	
	/**
	 * Swaps values within given array
	 * 
	 * @param charArray - array of characters used for swapping
	 * 
	 * @param indexOne - integer index for one of the two items to be swapped
	 * 
	 * @param indexOther - integer for the other of the two items to be swapped
	 */
	public static void swapValues(char[] charArray, int indexOne, int indexOther)
	{
		char temp = charArray[indexOne];
		charArray[indexOne] = charArray[indexOther];
		charArray[indexOther] = temp;
	}
}
