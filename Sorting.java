import java.time.*; 

public class Sorting {
	
	private static void countingSort(int[] toSort, int range) {
		int count[] = new int[range + 1];
		int out[] = new int[toSort.length];
		for (int i = 0; i < toSort.length; i++) {
			count[toSort[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		for (int i = toSort.length - 1; i >= 0; i--)  
        { 
            out[count[toSort[i]] - 1] = toSort[i]; 
            count[toSort[i]]--; 
        } 
		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = out[i];
		}
	}
	
	private static void quickSort(int[] toSort, int start, int end) {
		if (start < end) {
			int pivot = toSort[end];
			int q = start - 1;
			for (int i = start; i < end; i++) {
				if (toSort[i] < pivot) {
					q++;
					int temp = toSort[i];
					toSort[i] = toSort[q];
					toSort[q] = temp;
				}
			}
			int temp = toSort[q+1];
			toSort[q+1] = toSort[end];
			toSort[end] = temp;
			quickSort(toSort, start, q);
			quickSort(toSort, q + 2, end);
		}
	}
	
	private static Boolean isSorted(int[] check) {
		for (int i = 1; i < check.length; i++) {
			if (check[i - 1] > check[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] sargs) {
		// Convert command line arguments to ints
		int[] args = new int[sargs.length];
		for (int i = 0; i < sargs.length; i++) {
			args[i] = Integer.parseInt(sargs[i]);
		}
		
		// Declare two arrays A and B
		int[] A = new int[args[0]];
		int[] B = new int[args[0]];
		
		// Populate both arrays with the same random integers,
		// i.e. the two arrays are identical
		
		for (int i = 0; i < args[0]; i++) {
            A[i] = B[i] = (int) (Math.random() * args[1]);
        }
		
		//Check that the arrays were properly created
		/*
		for (int i = 0; i < args[0]; i++) {
			System.out.println(A[i] + " " + B[i]);
		}*/
		
		// Call the method countingSort to sort A and time the sort.
		// NOTE: the method could (but does not have to) return the
		// execution time
		
		long countingStartTime = System.currentTimeMillis();
		countingSort(A, args[1]);
		long countingEndTime = System.currentTimeMillis();
		long countingTotal = countingEndTime - countingStartTime;
		
		if (isSorted(A)) {
			System.out.println("CountingSort successful");
		} else {
			System.out.println("CountingSort failed");
		}
		
		
		// Call the method quickSort to sort B and time the sort.
		// NOTE: the method could (but does not have to) return the
		// execution time
		
		long quickStartTime = System.currentTimeMillis();
		quickSort(B, 0, B.length - 1);
		//for (int i = 0; i < B.length; i++) {System.out.println(B[i]);};
		long quickEndTime = System.currentTimeMillis();
		long quickTotal = quickEndTime - quickStartTime;
		
		// Test that array is sorted.
		if (isSorted(B)) {
			System.out.println("QuickSort successful");
		} else {
			System.out.println("QuickSort failed");
		}
		
		// Print the times for the two sorts.
		System.out.println("CountingSort took " + countingTotal + " millis");
		System.out.println("QuickSort took " + quickTotal + " millis");
		if (countingTotal > quickTotal) {
			System.out.println("CountingSort was faster!");
		} else if (quickTotal > countingTotal) {
			System.out.println("QuickSort was faster!");
		} else {
			System.out.println("Tie?!?!?!??!");
		}
	}
}
	

