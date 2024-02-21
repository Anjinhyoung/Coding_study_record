#include<stdio.h>
#include<stdlib.h>

void main() {
	int* dAr = 0;
	//dAr = (int*)malloc(sizeof(int) * 5);
	dAr = (int*)calloc(5, sizeof(int));
	dAr = (int*)realloc(dAr, sizeof(int) * 8);
	//printf("%d", dAr[0]);
	for (int i = 0; i < 8; i++) {
		dAr[i] = i + 1;
		printf("%d\n", dAr[i]);
	}
	free(dAr);

}