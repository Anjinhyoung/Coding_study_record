#include<stdio.h>
void main() {
	int data = 10;
	int* pData = &data;
	int* pData2 = 20;


	printf("%p\n", &data);
	printf("%p\n", pData);
	printf("%d\n", *pData);
	printf("%p\n", pData + 1);
	printf("안녕하세요\n");
	printf("%p", pData2);
}
