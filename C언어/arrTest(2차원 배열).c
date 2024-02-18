#include<stdio.h>
void main() {
	int arrData[2][3] = { 0, };
	for (int i = 0; i < 2; i++) {//행
		for (int j = 0; j < 3; j++) {//열
			arrData[i][j] = 5;
		}
	}

	for (int i = 0; i < 2; i++) {//행
		for (int j = 0; j < 3; j++) {//열
			printf("%d", arrData[i][j]);
		}
		printf("\n");
	}

}