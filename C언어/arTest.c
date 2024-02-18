#include<stdio.h>
void main() {
	int arData[] = {3, 5, 1, 9, 7};
	int length = sizeof(arData) / sizeof(int);

	for (int i = 0; i < length; i++) {
		arData[i] = 5 - i;
	}

	for (int i = 0; i < length; i++) {
		printf("%d ", arData[i]);
	}

	printf("\n%p\n", arData);
	printf("%p\n", &arData[0]);
	printf("%p\n", &arData[1]);
	printf("%d\n", sizeof(arData));
	printf("%d\n", *(arData + 2));
	printf("%d\n", *(arData + 4));
}