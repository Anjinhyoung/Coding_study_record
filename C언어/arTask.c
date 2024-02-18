#include<stdio.h>
void main() {
	//1~10까지 배열에 담고 출력
	//int arData[10] = { 0, };

	//for (int i = 0; i < 10; i++) {
	//	arData[i] = i + 1;
	//	printf("%d ", arData[i]);
	//}

	//10~1까지 중 짝수만 배열에 담고 출력
	int arData[5] = { 0, };
	for (int i = 0; i < 5; i++) {
		arData[i] = (i + 1) * 2;
		printf("%d ", *(arData + i));
	}

}