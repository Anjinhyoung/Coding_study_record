# 참조자 도입
```C++
#include <iostream>

int main() {
  int a = 3;
  int& another_a = a;

  another_a = 5;
  std::cout << "a : " << a << std::endl;
  std::cout << "another_a : " << another_a << std::endl;

  return 0;
}
}

a : 5
another_a : 5
```
 * a의 참조자를 anther_a로 정의하였다. 이 때 참조자를 정하는 방법은, 가리키고자 하는 타입 뒤에 '&'를 붙이면 됩니다.
 * 위 코드 처럼 int 형 변수의 참조자를 만들고 싶을 때에는 int&를, double의 참조자를 만드려면 double& 로 하면 됩니다.
 * 심지어 int* 와 같은 포인터 타입의 참조자를 만드려면 int*& 로 쓰면 됩니다.
 * 위와 같이 선언함으로써 우리는 another_a 는 a 의 참조자다! 라고 공표하게 되었습니다.
 * 이 말은 즉슨 another_a 는 a 의 또다른 이름 이라고 컴파일러에게 알려주는 것입니다.
 * 따라서 another_a 에 어떠한 작업을 수행하든 이는 사실상 a 에 그 작업을 하는 것과 마찬가지 입니다.

## 래퍼런스 주의점
```C++
int& another_a; // 이와 같은 문장은 불가능
int* p; // 이와 같은 문장은 가능
```
 **래퍼런스가 한 번 별명이 되면 절대로 다른 이의 별명이 될 수 없다.(아주 중요!!!)**

 ```C++
int a = 10;
int &another_a = a; // another_a 는 이제 a 의 참조자!

int b = 3;
another_a = b; // ??

참고로

&another_a = b; // 이 문장은 불가능하다.
```
 * 아래와 같은 코드를 살펴봅시다. 마지막에 another_a = b; 문장은 어떤 의미 일까요? another_a 보고 다른 변수인 b 를 가리키라고 하는 것일까요?
 * **아닙니다!!!**
 * 이는 그냥 a 에 b 의 값을 대입하라는 의미 입니다. 앞서 말했듯이 another_a 에 무언가를 하는 것은 사실상 a 에 무언가를 하는 것과 동일하다고 했으므로
 * 이 문장은 그냥 a = b 와 동치 입니다.
   
```C++
다만 포인터는 변경이 가능하다.
int a = 10;
int* p = &a; // p 는 a 를 가리킨다.

int b = 3;
p = &b // 이제 p 는 a 를 버리고 b 를 가리킨다
```
## 함수 인자로 래퍼런스 받기
```C++
#include <iostream>

int change_val(int &p) {
  p = 3;

  return 0;
}
int main() {
  int number = 5;

  std::cout << number << std::endl;
  change_val(number);
  std::cout << number << std::endl;
}

실행 결과
5
3
```
  * 위 코드는 포인트를 사용해서 number를 change_val 안에 전달한 코드를 참조자를 이용해서 바꿔본 것입니다.
  * 근데 int& p는 안 된다고 배웠는데 가능하게 되네요?
  * 사실 p가 정의되는 순간은 change_vale(number)로 호출할 때 이므로 사실상 int& p = number가 실행된다고 생각하면 됩니다.
  * p 에게 너는 앞으로 number 의 새로운 별명이야 라고 알려주게 됩니다.
  * 여기서 중요한 점은 포인터가 인자일 때와는 다르게 number 앞에 & 를 붙일 필요가 없다는 점입니다.
  * 이는 참조자를 정의할 때 그냥 int& a = b 와 같이 한 것과 일맥상통합니다.

```C++
// 참조자 이해하기

#include <iostream>

int main() {
  int x;
  int& y = x;
  int& z = y;

  x = 1;
  std::cout << "x : " << x << " y : " << y << " z : " << z << std::endl;

  y = 2;
  std::cout << "x : " << x << " y : " << y << " z : " << z << std::endl;

  z = 3;
  std::cout << "x : " << x << " y : " << y << " z : " << z << std::endl;
}

출력 결과

x : 1 y : 1 z : 1
x : 2 y : 2 z : 2
x : 3 y : 3 z : 3

```
  * 먼저 위와 같이 x의 참조자로 y를 정의하였습니다. 이제 y는 x의 또다른 별명이 되는 겁니다.
  * 그러면 이제 z를 보기 전에 궁금한 점이 있을 수 있습니다.
  * **"" 아까 어떤 타입 T 의 참조자 타입은 T& 래매. 그런데 여기서 y 가 int& 니까 y 의 참조자 타입은 int&& 가 되야 하지 않을까? ""**
  * 좋은 질문 입니다. 하지만 참조자의 참조자 라는 말의 의미를 생각해보면 사실 말이 되지는 않습니다.
  * 굳이 별명의 별명을 만들 필요는 없으니깐요! 실제로 C++ 문법 상 참조자의 참조자를 만드는 것은 금지되어 있습니다.
  * int& z = y; 문장은 x의 참조자를 선언해라와 같은 의미가 됩니다.
  * 따라서 y와 z 모두 x의 참조자가 됩니다.
