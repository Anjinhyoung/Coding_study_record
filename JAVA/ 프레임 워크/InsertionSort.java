package day41;

public class InsertionSort {
	public static void main(String[] args) {
			int ar[]= {8,1,2,5,4,3,6,7};
			int tmp;
			int idx;
			for(int i=1;i<ar.length;i++) {
				idx=i;
				for(int j=i-1;j>=0;j--) {
					if(ar[idx]<ar[j]) {
						tmp=ar[idx];
						ar[idx]=ar[j];
						ar[j]=tmp;
						idx=j;					}
					else {
						break;					}
				}
			}
			for(int i=0;i<ar.length;i++) {
				System.out.print(ar[i]+" ");
			}
	}
}

