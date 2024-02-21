#include<stdio.h>
#include<stdlib.h>

#define L 3

typedef struct Fruit {
	char name[200];
	int price;
	char season[200];
}F;

void main() {
	F* fruits = 0;
	int size = 0;
	printf("입력하실 과일의 개수를 입력하세요\n");
	scanf_s("%d", &size);

	fruits = (F*)calloc(size, sizeof(F));
	
	for (int i = 0; i < size; i++) {
		printf("%d번째 과일명 : ", i+1);
		scanf_s("%s", fruits->name, sizeof(fruits->name));
		printf("%s 가격", fruits->name);
		scanf_s("%d", &fruits[i].price);
		printf("%s 시즌", fruits->name);
		scanf_s("%s", fruits->season, sizeof(fruits->season));

		printf("%s, %d, %s\n", fruits->name, fruits[i].price, fruits->season);
	}


	//F fruits[L] = {
	//	{ "사과", 1500, "가을" },
	//	{ "배", 3500, "겨울" },
	//	{ "바나나", 500, "여름" }
	//};

	//for (int i = 0; i < L; i++) {
	//	printf("%s, %d, %s\n", fruits[i].name, fruits[i].price, fruits[i].season);
	//}

	//F apple = { "사과", 1500, "가을" };
	//F pear = { "배", 3500, "겨울" };
	//F banana = { "바나나", 500, "여름" };

	//printf("%s, %d, %s\n", apple.name, apple.price, apple.season);
	//printf("%s, %d, %s\n", pear.name, pear.price, pear.season);
	//printf("%s, %d, %s\n", banana.name, banana.price, banana.season);
}