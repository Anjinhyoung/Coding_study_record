# 주의 사항

참고로 C++ 표준에서는 문자열 클래스 (string) 을 지원하므로 여러분이 직접 문자열 클래스를 만들어서 사용할 일은 거의 없을 것이고, 그 성능 역시 C++ 에서 제공하는 문자열 클래스를 이용하는 것이 훨씬 빠를 것입니다.

# 문자열 클래스 만들기
  * 기존 C 언어에서는 문자열을 나타내기 위해 널 종료 문자열(Null-terstd::minating string)이라는 개념을
  * 도입해서 문자열 끝에 NULL 문자를 붙여 문자열을 나타내는 방식을 사용하였습니다.
  * 하지만 C 언어 문자열을 사용하는데에는 번거로움이 많았는데, 예를 들어서 만들어진 문자열의 크기를 바꾼다던지,
  * 문자열 뒤에 다른 문자열을 붙인다던지 등의 작업들은 상당히 프로그래머 입장에서는 귀찮을 수 밖에 없습니다.
  * 이와 같은 작업들을 문자열 클래스를 따로 만들어서 클래스 차원에서 지원해주면 상당히 편할 텐데 말이지요.
  * 그래서 우리는 직접 문자열 클래스를 만들고자 합니다.

# MyString 클래스 만들기

  *  우리가 만들 MyString 클래스에 멤버 변수로 무엇이 필요할지 생각해봅시다.
  *  1. 문자열 데이터가 저장된 공간을 가리키는 포인터 
     2. 문자열 데이터의 길이
  * 왜 객체에 문자열 데이터를 직접 보관하는 것이 아니라,
  * 그 저장된 공간을 가리키는 포인터를 보관하냐고 물을 수 있습니다.
  * 이렇게 하는 이유는 나중에 문자열 데이터의 크기가 바뀔 때,
  * 저장된 공간을 가리키는 방식으로 하면 그 메모리를 해제한 뒤에,
  * 다시 할당할 수 있지만 직접 보관하면 그럴 수 없기 때문이죠.

  * 또한, 문자열 데이터의 길이를 보관하는 이유는 문자열 길이를 사용할 일이 굉장히 많은데,
  * 그 때 마다 계속 길이를 구하는 것은 상당히 불필요한 일이기 때문입니다.
  * 따라서 길이를 한 번 구해놓고 길이가 바뀔 때 까지 변경하지 않는 방법이 유용할 것입니다.
  * 그럼, 위 내용을 바탕으로 한번 MyString 을 구성해보도록 하겠습니다.


```C++
class MyString {
  char* string_content;  // 문자열 데이터를 가리키는 포인터
  int string_length;     // 문자열 길이
};
```

 * 그러면 생성자는 어떨까요?


```C++
// 문자 하나로 생성
MyString(char c);

// 문자열로 부터 생성
MyString(const char* str);

// 복사 생성자
MyString(const MyString& str);
```

  * 일단 제가 구현하고자 요구했던 내용들을 충족시키기 위해서는 위와 같은 생성자들을 만들어야 합니다.
  * 그러면 이제 생성자를 구체화 시킬려면 어떻게 해야 할까요?
  * C 형식의 문자열을 그대로 보관한다면, 문자열의 끝 부분을 쉽게 체크할 수 있다는 장점이 있지만 이 문제는 우리가 string_length 라는 변수를 같이 도입함으로써 해결할 수 있게 되었습니다.
  * 따라서, 저희 MyString 클래스에서는 실제 문자에만 해당하는 내용만을 string_content 에 보관하도록 하겠습니다.

```C++
MyString::MyString(char c) {
  string_content = new char[1];
  string_content[0] = c;
  string_length = 1;
}
MyString::MyString(const char* str) {
  string_length = strlen(str);
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++) string_content[i] = str[i];
}
MyString::MyString(const MyString& str) {
  string_length = str.string_length;
  for (int i = 0; i != string_length; i++)
    string_content[i] = str.string_content[i];
}
MyString::~MyString() { delete[] string_content; }
```
 * 위와 같이 3 개의 생성자들을 정의하였고, string_content 를 동적 할당으로 처리하였기 때문에
 * 반드시 소멸자에서 이를 동적해제하는 것을 처리해줘야만 합니다.
 * **내부 멤버 변수의 값을 바꾸지 않는다면 함수를 꼭 상수로 정의하세요.**
 * length 함수 역시 string_length 의 값을 읽기만 하므로 처럼 상수 함수로 정의하였습니다.
 * 아래는 전체 코드입니다.

```C++
#include <iostream>

// string.h 는 strlen 때문에 include 했는데, 사실 여러분이 직접 strlen
// 과 같은 함수를 만들어서 써도 됩니다.
#include <string.h>

class MyString {
  char* string_content;  // 문자열 데이터를 가리키는 포인터
  int string_length;     // 문자열 길이

 public:
  // 문자 하나로 생성
  MyString(char c);

  // 문자열로 부터 생성
  MyString(const char* str);

  // 복사 생성자
  MyString(const MyString& str);

  ~MyString();

  int length() const;

  void print() const;
  void println() const;
};

MyString::MyString(char c) {
  string_content = new char[1];
  string_content[0] = c;
}
MyString::MyString(const char* str) {
  string_length = strlen(str);
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++) {
    string_content[i] = str[i];
  }
}
MyString::MyString(const MyString& str) {
  string_length = str.string_length;
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++)
    string_content[i] = str.string_content[i];
}
MyString::~MyString() { delete[] string_content; }
int MyString::length() const { return string_length; }

void MyString::print() const {
  for (int i = 0; i != string_length; i++) {
    std::cout << string_content[i];
  }
}
void MyString::println() const {
  for (int i = 0; i != string_length; i++) {
    std::cout << string_content[i];
  }

  std::cout << std::endl;
}
int main() {
  MyString str1("hello world!");
  MyString str2(str1);

  str1.println();
  str2.println();
}

출력 결과

hello world!
hello world!

```

# assign 함수
 * assign 함수는 '지정하다' 라는 뜻을 가진 함수로, 우리가 흔히 생각하는 '=' 과 동일한 역할을 하게 됩니다.
 * 예를 들어서 우리의 MyString 변수 str 에서 str.assign("abc"); 를 하게 된다면 str 에는 원래 있었던 문자열이 지워지고 abc 가 들어가게 되겠지요.
 * 그렇다면 우리는 다음과 같은 두 개의 assign 함수를 준비할 수 있습니다.
 * MyString& assign(const MyString& str);
 * MyString& assign(const char* str);
 * assign 함수는 다음과 같이 구현될 수 있습니다.

```C++
MyString& MyString::assign(const MyString& str) {
  if (str.string_length > string_length) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str.string_length];
  }
  for (int i = 0; i != str.string_length; i++) {
    string_content[i] = str.string_content[i];
  }

  // 그리고 굳이 str.string_length + 1 ~ string_length 부분은 초기화
  // 시킬 필요는 없다. 왜냐하면 거기 까지는 읽어들이지 않기 때문이다.

  string_length = str.string_length;

  return *this;
}
MyString& MyString::assign(const char* str) {
  int str_length = strlen(str);
  if (str_length > string_length) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str_length];
  }
  for (int i = 0; i != str_length; i++) {
    string_content[i] = str[i];
  }

  string_length = str_length;

  return *this;
}

```

 * string 의 크기가 작으면 동적 할당을 수행하는데 큰 시간이 필요하지 않겠지만,
 * 우리의 MyString 클래스는 어떤 크기의 문자열에 대해서도 좋은 성능을 보여주어야만 하기 때문에 위 처럼 인자로 입력받는 문자열의 크기가,
 * 원래 문자열의 크기 보다 작다면 굳이 동적 할당을 할 필요가 없게 되죠.
 * 따라서 그 경우에는 그냥 그대로 복사하게 됩니다. 하지만, 인자로 입력받는 문자열의 크기가 더 크다면,
 * 현재까지는 이전에 동적으로 할당된 메모리 바로 뒤에 메모리를 추가하는 방법은 없으므로, 새로 동적할당을 해줘야만 합니다.
 * 그런데 이렇나 방식으로 구현하는데에는 약간의 문제가 있습니다.

```C++
MyString str1("very very very long string");
str1.assign("short string");
str1.assign("very long string");
```
 * 맨 처음에 str1 에 아주 긴 문자열을 할당하였습니다. 예를 들어서 그 문자열의 길이가 1000 바이트 라고 생각해봅시다.
 * (물론 위 소스에서는 겨우 몇 바이트 이겠지만 아무튼 아주 긴 문자열이라 생각합시다)
 *  그런 다음에 str1 에 다시 짧은 문자열을 assign 하였다고 가정합니다.
 *  우리의 assign 함수에 따르면 이미 긴 문자열이 할당 되어 있을 경우, 더 짧은 문자열을 assign 한다면 특별히 동적 할당을 새로할 필요 없이 그냥 string_length 를 줄이고 그냥 짧은 문자열로 덮어 씌우게 됩니다.
 *  그런데 문제는 다시 str1 에 긴 문자열을 assign 시에 발생하게 됩니다 (이번의 긴 문자열은 이전의 아주 긴 문자열 보다는 약간 짧다고 생각합니다). 비록 str1 에 이미 1000 바이트에 달하는 공간이 할당되어 있는데도 불구하고 현재 짧은 문자열이 있기 때문에
 *  새롭게 긴 문자열을 assign 시에 이미 1000 바이트가 할당되어 있다는 사실을 알 수 없게 됩니다.
 *  따라서, assign 함수는 문자열에 짧은 문자열을 위한 작은 크기에 공간만이 할당되어 있다고 생각하여 메모리를 해제하고 다시 많은 양의 메모리를 할당하는 매우 비효율 적인 작업을 하게 됩니다.
 * ![image](https://github.com/Anjinhyoung/Coding-Learning/assets/117788976/fe58d318-c87b-4b5b-bbe3-13e22d5f4b66)
 *  따라서 이러한 비효율 적인 막기 위해서는 얼마나 많은 공간이 할당되어 있는지 알 수 있는 정보를 따로 보관하는 것이 좋을 것이라 생각됩니다.
 * 이를 위해 memory_capacity 라는, 현재 할당된 메모리 공간의 크기를 나타내는 새로운 변수를 추가하였습니다.




```C++

MyString& MyString::assign(const MyString& str) {
  if (str.string_length > memory_capacity) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str.string_length];
    memory_capacity = str.string_length;
  }
  for (int i = 0; i != str.string_length; i++) {
    string_content[i] = str.string_content[i];
  }

  // 그리고 굳이 str.string_length + 1 ~ string_length 부분은 초기화
  // 시킬 필요는 없다. 왜냐하면 거기 까지는 읽어들이지 않기 때문이다.

  string_length = str.string_length;

  return *this;
}
MyString& MyString::assign(const char* str) {
  int str_length = strlen(str);
  if (str_length > memory_capacity) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str_length];
    memory_capacity = str_length;
  }
  for (int i = 0; i != str_length; i++) {
    string_content[i] = str[i];
  }

  string_length = str_length;

  return *this;
}

```

 * 이렇게 하게 된다면, 앞선 그림에서 나타나는 상황과 같은 문제를 방지할 수 있게 됩니다.
 * 이렇게 capacity 를 도입함으로써 여러가지 새로운 함수들을 추가할 수 있게 되었습니다.
 * 예를 들어서, 할당할 문자열의 크기를 미리 예약해 놓는 reserve 함수와 현재 문자열의 할당된 메모리 크기를 나타내는 capacity 함수를 만들 수 있습니다. 이들은 다음과 같습니다.

```C++

int MyString::capacity() { return memory_capacity; }
void MyString::reserve(int size) {
  if (size > memory_capacity) {
    char *prev_string_content = string_content;

    string_content = new char[size];
    memory_capacity = size;

    for (int i = 0; i != string_length; i++)
      string_content[i] = prev_string_content[i];

    delete[] prev_string_content;
  }

  // 만일 예약하려는 size 가 현재 capacity 보다 작다면
  // 아무것도 안해도 된다.
}

```
* 참고로 reserve 함수의 경우, 만일 할당하려는 크기가 현재의 할당된 크기보다 작다면 굳이 할당할 필요가 없게 됩니다.
* 따라서 위와 같이 size 가 memory_capacity 보다 클 경우에만 할당하도록 처리하였습니다. 과연 잘 작동하는지 살펴볼까요.

```C++

#include <iostream>

// string.h 는 strlen 때문에 include 했는데, 사실 여러분이 직접 strlen
// 과 같은 함수를 만들어서 써도 됩니다.
#include <string.h>

class MyString {
  char* string_content;  // 문자열 데이터를 가리키는 포인터
  int string_length;     // 문자열 길이
  int memory_capacity;   // 현재 할당된 용량

 public:
  // 문자 하나로 생성
  MyString(char c);

  // 문자열로 부터 생성
  MyString(const char* str);

  // 복사 생성자
  MyString(const MyString& str);

  ~MyString();

  int length() const;
  int capacity() const;
  void reserve(int size);

  void print() const;
  void println() const;

  MyString& assign(const MyString& str);
  MyString& assign(const char* str);
};

MyString::MyString(char c) {
  string_content = new char[1];
  string_content[0] = c;
  memory_capacity = 1;
  string_length = 1;
}
MyString::MyString(const char* str) {
  string_length = strlen(str);
  memory_capacity = string_length;
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++) {
    string_content[i] = str[i];
  }
}

MyString::MyString(const MyString& str) {
  string_length = str.string_length;
  memory_capacity = str.string_length;
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++) {
    string_content[i] = str.string_content[i];
  }
}

MyString::~MyString() { delete[] string_content; }
int MyString::length() const { return string_length; }

void MyString::print() const {
  for (int i = 0; i != string_length; i++) {
    std::cout << string_content[i];
  }
}
void MyString::println() const {
  for (int i = 0; i != string_length; i++) {
    std::cout << string_content[i];
  }

  std::cout << std::endl;
}

MyString& MyString::assign(const MyString& str) {
  if (str.string_length > memory_capacity) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str.string_length];
    memory_capacity = str.string_length;
  }
  for (int i = 0; i != str.string_length; i++) {
    string_content[i] = str.string_content[i];
  }

  // 그리고 굳이 str.string_length + 1 ~ string_length 부분은 초기화
  // 시킬 필요는 없다. 왜냐하면 거기 까지는 읽어들이지 않기 때문이다.

  string_length = str.string_length;

  return *this;
}
MyString& MyString::assign(const char* str) {
  int str_length = strlen(str);
  if (str_length > memory_capacity) {
    // 그러면 다시 할당을 해줘야만 한다.
    delete[] string_content;

    string_content = new char[str_length];
    memory_capacity = str_length;
  }
  for (int i = 0; i != str_length; i++) {
    string_content[i] = str[i];
  }

  string_length = str_length;

  return *this;
}
int MyString::capacity() const { return memory_capacity; }
void MyString::reserve(int size) {
  if (size > memory_capacity) {
    char* prev_string_content = string_content;

    string_content = new char[size];
    memory_capacity = size;

    for (int i = 0; i != string_length; i++)
      string_content[i] = prev_string_content[i];

    delete[] prev_string_content;
  }

  // 만일 예약하려는 size 가 현재 capacity 보다 작다면
  // 아무것도 안해도 된다.
}
int main() {
  MyString str1("very very very long string");
  str1.reserve(30);

  std::cout << "Capacity : " << str1.capacity() << std::endl;
  std::cout << "String length : " << str1.length() << std::endl;
  str1.println();
}

출력 결과

Capacity : 30
String length : 26
very very very long string

```
