#include<stdio.h>
void main() {
	// "" : 빈 문자열
	char fruit[6] = "";
	printf("과일 이름 : ");
	scanf_s("%s", fruit, sizeof(fruit));

	printf("%s는 맛있어!", fruit);
}
