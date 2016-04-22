import java.util.Arrays;

/**
 * Quick Sort - this src code i have attached gif image this will explain about the how quick sort works.
 * 
 * @author gireesh_sk
 *
 */
public class Main {
	public static void main(String[] args) {

		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("Un Sorted Array : " + Arrays.toString(input));
		
		
		
		QuickSort quickSort = new QuickSort();
		quickSort.sort(input);
		
		
		System.out.println("Sorted Array :  " + Arrays.toString(input));

	}
}

/**
 * @author gireesh_sk
 *
 */
class QuickSort {
	private int intput[];
	private int lenght;

	public void sort(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			System.out.println("List is empty!!");
			return;
		}

		this.intput = numbers;
		this.lenght = numbers.length;
		
		
		quickSort(0,lenght -1);

	}

	/**
	 * 
	 * This method implement quick sort by calling recursively
	 * 
	 * @param low
	 * @param high
	 */
	private void quickSort(int low, int high) {

		int i = low;
		int j = high;

		// pivot is the middle index
		int pivot = intput[(low + high) / 2];

		// divide into 2 arrays
		while (i <= j) {
			/**
			 * * As shown in above image, In each iteration, we will identify a
			 * * number from left side which is greater then the pivot value,
			 * and * a number from right side which is less then the pivot value.
			 * Once * search is complete, we can swap both numbers.
			 */
			
			while(intput[i] < pivot){
				i++;
			}
			
			while (intput[j] > pivot) {
				j--;
			}
			
			if(i <= j){
				swap(i, j);
				// move the index to next position on both sides
				i++;
				j--;
			}
			
		}
		
		//calls quick sort method recursively.
		
		if(low < j){
			quickSort(low, j);
		}
		
		if(i < high){
			quickSort(i, high);
		}
			

	}
	
	
	private void swap(int i,int j){
		int temp=intput[i];
		intput[i] = intput[j];
		intput[j] = temp;
	}
}
