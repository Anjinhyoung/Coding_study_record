#include<stdio.h>
void main() {
	int arrData[2][3] = { {2, 3, 4}, {5, 6, 7} };
	for (int i = 0; i < 6; i++) {
		if (i % 3 == 0) { printf("\n"); }
		printf("%d", arrData[i / 3][i % 3]);
	}
}
