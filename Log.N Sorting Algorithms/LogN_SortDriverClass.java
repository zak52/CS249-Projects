package p3_package;

public class LogN_SortDriverClass 
{
	/**
	 * Default constructor
	 */
	public LogN_SortDriverClass()
	{
		
	}
	
	/**
	 * Compares two strings character by character set to lower case
	 * see which alphabetically greater than the other
	 * 
	 * @param strOne - first String value to be compared
	 * 
	 * @param strTwo - second String value to be compared
	 * 
	 * @return
	 * Alphabetically, if strOne is greater than strTwo return number greater than 0
	 * 
	 * Alphabetically, if strOne is less than strTwo return number less than 0
	 * 
	 * Alphabetically, if strOne is equal to strTwo and length = same return 0
	 * 
	 * Alphabetically, if strOne is equal to strTwo and length is different return
	 * difference in length
	 */
	
	public static int compareStrings(String strOne, String strTwo)
	{
		int strOneLength = strOne.length();
		int strTwoLength = strTwo.length();
		int index;
		if(strOneLength > strTwoLength)
		{
			for(index = 0; index < strTwoLength; index++)
			{
				if(toLowercase(strOne.charAt(index)) != toLowercase(strTwo.charAt(index)))
				{
					return toLowercase(strOne.charAt(index)) - toLowercase(strTwo.charAt(index));
				}
			}
		}
		else
		{
			for(index = 0; index < strOneLength; index++)
			{
				if(toLowercase(strOne.charAt(index)) != toLowercase(strTwo.charAt(index)))
				{
					return toLowercase(strOne.charAt(index)) - toLowercase(strTwo.charAt(index));
				}
			}
		}
		return strOneLength - strTwoLength;
	}
	
	
	/**
	 * Merges String values brought in between a low and high
	 * index segment (inclusive) of an array
	 * 
	 * @param localArry - String array holding unsorted values
	 * 
	 * @param lowIndex - lowest Index of array segment to be managed
	 * 
	 * @param middleIndex - middle index of array segment to be managed
	 * 
	 * @param highIndex - high index of array segment to be managed
	 */
	private static void runMerge(String[] localArry, int lowIndex,
			int middleIndex, int highIndex)
	{
		int leftArraySize = middleIndex - lowIndex + 1;
		int rightArraySize = highIndex - middleIndex;
		
		String[] leftArray = new String[leftArraySize];
		String[] rightArray = new String[rightArraySize];
		int index = 0;
		if (leftArraySize > rightArraySize)
		{
			while(index < leftArraySize)
			{
				if(index < rightArraySize)
				{
					rightArray[index] = localArry[middleIndex + index + 1];
					
				}
				leftArray[index] = localArry[lowIndex + index];
				index++;
			}
		}
		else
		{
			while(index < rightArraySize)
			{
				if(index < leftArraySize)
				{
					leftArray[index] = localArry[lowIndex + index];
					
				}
				rightArray[index] = localArry[middleIndex + index + 1];
				index++;
			}
		}
		int leftIndex = 0;
		int rightIndex = 0;
		index = lowIndex;
		while(leftIndex < leftArraySize && rightIndex < rightArraySize)
		{
			if (compareStrings(leftArray[leftIndex], rightArray[rightIndex]) <= 0)
			{
				localArry[index] = leftArray[leftIndex];
				leftIndex++;
			}
			else
			{
				localArry[index] = rightArray[rightIndex];
				rightIndex++;
			}
			index++;
		}
		while(leftIndex < leftArraySize)
		{
			localArry[index] = leftArray[leftIndex];
			leftIndex++;
			index++;
		}
	
		while(rightIndex < rightArraySize)
		{
			localArry[index] = rightArray[rightIndex];
			index++;
			rightIndex++;
			
		}
		
	}
	/**
	 * String data sorted using merge sort algorithm
	 * Calls runMergeSorthelper
	 * 
	 * @param localArray - String array holding unsorted values
	 * 
	 * @param size - integer value holding number of values in array
	 */
	public static void runMergeSort(String[] localArray, int size)
	{
		runMergeSortHelper(localArray, 0, size - 1);
	}
	
	/**
	 * Merge sort helper, recursively breaks given array
	 * segment down to small segments between low and high index
	 * 
	 * @param localArray - String array holing unsorted values
	 * 
	 * @param lowIndex - lowest index of array segment to be managed
	 * 
	 * @param highIndex - highest index of array segment to be managed
	 */
	private static void runMergeSortHelper(String[] localArray, int lowIndex,
			int highIndex)
	{
		int midWay;
		if ( lowIndex < highIndex)
		{
			midWay = (lowIndex + highIndex) / 2;
			runMergeSortHelper(localArray, lowIndex, midWay);
			runMergeSortHelper(localArray, midWay+1, highIndex);
			runMerge(localArray, lowIndex, midWay, highIndex);
			
		}
	}
	
	/**
	 * Partitions array using the first value as the partition
	 * 
	 * @param localArray - String array holding unsorted values
	 * 
	 * @param lowIndex - low index of array segment to be partitioned
	 * 
	 * @param highIndex - high index of array segment to be partitioned
	 * 
	 * @return - integer index of partition pivot
	 */
	private static int runPartition(String[] localArray, int lowIndex, int highIndex)
	{
		int pivotIndex = lowIndex;
		int workingIndex = lowIndex;
		int index;
		for(index = workingIndex + 1; index < highIndex; index++)
		{
			if(compareStrings(localArray[pivotIndex], localArray[index]) >= 0 )
			{
				workingIndex++;
				swapValues(localArray, workingIndex, index);
				
			}
		}
		workingIndex++;
		swapValues(localArray, workingIndex, pivotIndex);
		return workingIndex;
		
	}
	/**
	 *  Data sorted using quick sort algorithm
	 *  
	 * @param localArray - String array holding unsorted values
	 * 
	 * @param size - integer value holding the number of values in the array 
	 */
	public static void runQuickSort(String[] localArray, int size)
	{
		runQuickSortHelper(localArray, 0, size - 1);
	}
	
	
	/**
	 *  Helper method run with parameters
	 *  that support recursive access
	 *  
	 * @param localArray - String array holding unsorted values
	 * 
	 * @param indexOne - low index of the segment of the array
	 * to be processed
	 * 
	 * @param indexOther - high index of the segment of the array
	 * to be processed
	 */
	private static void runQuickSortHelper(String[] localArray, int indexOne,
			int indexOther)
	{
		if (indexOne < indexOther)
		{
			int partitionNumber = runPartition(localArray, indexOne, indexOther);
			runQuickSortHelper(localArray, indexOne, partitionNumber - 1 );
			runQuickSortHelper(localArray, partitionNumber + 1, indexOther);
		}
	}
	
	/**
	 * Swaps values within given array
	 * 
	 * @param localArray - array of Strings used for swapping
	 * 
	 * @param indexOne - integer index for one of the two items to be swapped
	 * 
	 * @param indexOther - integer index for the other of the two items to be swapped
	 */ 
	private static void swapValues(String[] localArray, int indexOne,
			int indexOther)
	{
		String temp = localArray[indexOne];
		localArray[indexOne] = localArray[indexOther];
		localArray[indexOther] = temp;
	}
	
	/**
	 * If character is upper case letter, changes letter to lower case; otherwise, 
	 * returns character unchanged
	 * 
	 * @param testChar - character value to be tested and possibly modified
	 * 
	 * @return - character value modified as specified
	 */
	private static char toLowercase(char testChar)
	{
		if (testChar <= 'Z' && testChar >= 'A')
		{
			testChar = (char) (testChar - 'A');
			testChar = (char) (testChar + 'a');
		}
		return testChar;
	}
}

