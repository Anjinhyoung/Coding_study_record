#include<stdio.h>
void main() {
	int arrData[2][3] = { 0, };
	for (int i = 0; i < 2; i++) {//Çà
		for (int j = 0; j < 3; j++) {//¿­
			arrData[i][j] = 5;
		}
	}

	for (int i = 0; i < 2; i++) {//Çà
		for (int j = 0; j < 3; j++) {//¿­
			printf("%d", arrData[i][j]);
		}
		printf("\n");
	}

}
