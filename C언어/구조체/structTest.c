#include<stdio.h>
#include<string.h>

struct Animal {
	char name[200];
	int age;
	char feed[200];
};

void main() {
	//struct Animal dog = { "Max", 10, "°³²­" };
	struct Animal dog;
	strcpy_s(dog.name, sizeof(dog.name), "max");
	dog.age = 20;
	strcpy_s(dog.feed, sizeof(dog.feed), "°³²­");

	printf("%s, %d, %s", dog.name, dog.age, dog.feed);
}
