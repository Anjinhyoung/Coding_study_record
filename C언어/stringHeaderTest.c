#include<stdio.h>
#include<string.h>
void main() {
	char nation[6] = "korea";
	//nation = "japan";
	//scanf_s("%s", nation, sizeof(nation));
	//printf("%s\n", nation);
	//strcpy_s(nation, sizeof(nation), "japan");
	//printf("%s\n", nation);
	//printf("%d\n", strcmp(nation, "japan"));
	//printf("%d\n", strcmp(nation, "apple"));
	//printf("%d\n", strcmp(nation, "data"));
	//printf("%d\n", strcmp(nation, "korea"));

	scanf_s("%s", nation, sizeof(nation));
	if (!strcmp(nation, "korea")) {
		printf("두 값은 같은 값입니다.\n");
	}
}