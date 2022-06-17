import java.util.Scanner;

class BinarySearch {
	 public static void binarySearch(int arr[], int first, int last, int key){  
		   int mid = (first + last)/2;  

		   while( first <= last ){  
		      if ( arr[mid] < key ){  
		        first = mid + 1;     
		      }else if ( arr[mid] == key ){  
		        System.out.println("Angka ditemukan di index: " + mid);  
		        break;  
		      }else{  
		         last = mid - 1;  
		      }  
		      mid = (first + last)/2;  
		   }  
		   if ( first > last ){  
		      System.out.println("Angka tidak ditemukan!");  
		   }  
		 }  

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		int arraySize = 0;
		int valueToFind;

		System.out.print("Masukkan jumlah angka yang ingin di input : ");
		arraySize = scan.nextInt();
		int[] data = new int[arraySize];

		System.out.format("Input %d angka : \n", arraySize);
		for (int i = 0; i < arraySize; i++) {
			data[i] = scan.nextInt();
		}

		System.out.print("Angka yang ingin dicari : ");
		valueToFind = scan.nextInt();
		int last = data.length - 1;

		BinarySearch.binarySearch(data, 0, last, valueToFind);
	}
}