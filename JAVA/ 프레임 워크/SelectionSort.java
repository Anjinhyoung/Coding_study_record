package day41;


public class SelectionSort {
	public static void main(String[] args) {
		int ar[]= {8,1,2,5,4,3,6,7};
		int min,tmp;
		for(int i=0;i<ar.length-1;i++) {
			min=i;
			for(int j=i+1;j<ar.length;j++) {
			if(ar[min]>ar[j]) {
				tmp=ar[min];
				ar[min]=ar[j];
				ar[j]=tmp;
			}
			}
		}
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
}


