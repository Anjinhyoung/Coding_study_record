#include<stdio.h>
void main() {
	int data = 10;
	int* pData = &data;

	printf("%p\n", &data);
	printf("%p\n", pData);
	printf("%d\n", *pData);
	printf("%p\n", pData + 1);
}