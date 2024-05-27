# explicit

```C++

#include <iostream>

class MyString {
  char* string_content;  // 문자열 데이터를 가리키는 포인터
  int string_length;     // 문자열 길이

  int memory_capacity;

 public:
  // capacity 만큼 미리 할당함.
  MyString(int capacity);

  // 문자열로 부터 생성
  MyString(const char* str);

  // 복사 생성자
  MyString(const MyString& str);

  ~MyString();

  int length() const;
};

MyString::MyString(int capacity) {
  string_content = new char[capacity];
  string_length = 0;
  memory_capacity = capacity;
  std::cout << "Capacity : " << capacity << std::endl;
}

MyString::MyString(const char* str) {
  string_length = 0;
  while (str[string_length++]) {
  }

  string_content = new char[string_length];
  memory_capacity = string_length;

  for (int i = 0; i != string_length; i++) string_content[i] = str[i];
}
MyString::MyString(const MyString& str) {
  string_length = str.string_length;
  string_content = new char[string_length];

  for (int i = 0; i != string_length; i++)
    string_content[i] = str.string_content[i];
}
MyString::~MyString() { delete[] string_content; }
int MyString::length() const { return string_length; }

int main() { MyString s(3); }

출력 결과

Capacity : 3

```
  * 이런 코드가 있다고 가정해봅시다.
  * 만약에 이런 함수가 추가 된다고 생각을 해봅시다.

```C++
void DoSomethingWithString(MyString s) {
  // Do something...
}
```
  * 그렇다면 DoSomethingWithString(MyString("abc")) 이 코드는 컴파일이 될까요?
  * 당연히 되겠지요. MyString 객체를 생성해서 이를 인자로 전달합니다.
  * 그렇다면 MyString 을 명시적으로 생성하지 않을 경우는 어떨까요?
  * DoSomethingWithString("abc")
  * 일단 DoSomethingWithString 함수를 살펴보면 인자로 MyString 을 받고 있습니다. 하지만 "abc" 는 MyString 타입이 아니지요.
  * 그런데 C++ 컴파일러는 꽤나 똑똑해서 "abc" 를 어떻게 하면 MyString 으로 바꿀 수 있는지 생각해봅니다.
  * 그리고 다행이도 MyString 의 생성자들 중에서는

```C++
MyString(const char* str);
```
  * 위와 같이 const char* 로 부터 생성하는 것이 있었습니다. 따라서, DoSomethingWithString("abc") 는 알아서
  * DoSomethingWithString(MyString("abc"))
  * 로 변환되서 컴파일 됩니다. 위와 같은 변환을 **암시적 변환(implicit conversion)** 이라고 부릅니다.
  * 하지만 암시적 변환이 언제나 사용자에게 편리한 것은 아닙니다. 때로는 예상치 못한 경우에 암시적 변환이 일어날 수 도 있습니다.
  * 하지만 다행이도 C++ 에서는 원하지 않는 암시적 변환을 할 수 없도록 컴파일러에게 명시할 수 있습니다.
  * 바로 explicit 키워드를 통해 말이지요.

```C++

#include <iostream>

class MyString {
  char* string_content;  // 문자열 데이터를 가리키는 포인터
  int string_length;     // 문자열 길이

  int memory_capacity;

 public:
  // capacity 만큼 미리 할당함. (explicit 키워드에 주목)
  explicit MyString(int capacity);

  // 문자열로 부터 생성
  MyString(const char* str);

  // 복사 생성자
  MyString(const MyString& str);

  ~MyString();

  int length() const;
  int capacity() const;
};

// .. (생략) ..

void DoSomethingWithString(MyString s) {
  // Do something...
}

int main() {
  DoSomethingWithString(3);  // ????
}


```
  * ![image](https://github.com/Anjinhyoung/Coding-Learning/assets/117788976/74fbc8c9-c73c-48a5-a1cf-765c19bed679)
  * 위와 같이 DoSomethingWithString(3) 부분에서 컴파일 오류가 발생함을 알 수 있습니다. 그 이유는 int capacity 를 인자로 받는 생성자가

```C++
// capacity 만큼 미리 할당함. (explicit 키워드에 주목)
explicit MyString(int capacity);
```


  * 위와 같이 explicit 으로 되어 있기 때문이지요. explicit 은 implicit 의 반대말로, 명시적 이라는 뜻을 가지고 있습니다.
  * 컴파일러에서 이 MyString 생성자를 explicit 으로 선언한다면 이 생성자를 이용한 암시적 변환을 수행하지 못하게 막을 수 있습니다.
  * explicit 은 또한 해당 생성자가 복사 생성자의 형태로도 호출되는 것을 막게 됩니다. 예를 들어서;

```C++
MyString s = "abc";  // MyString s("abc")
MyString s = 5;      // MyString s(5)
```
  * MyString(int capacity); 에 explicit 이 없을 경우, 위 코드는 잘 작동합니다.
  * 왜냐하면 컴파일러가 알아서 적당한 생성자를 골라서 호출되기 때문이지요. 하지만 생각해보면
  * MyString s = 5;  // MyString s(5) 는 마치 s 에 5 를 대입하고 있다는 의미를 전달하게 됩니다.
  * 실제로는 capacity 를 5 로 해주는 것인대도 말이지요. 따라서, explicit 으로 MyString(int capacity) 를 설정하면

```C++
MyString s(5);   // 허용
MyString s = 5;  // 컴파일 오류!
```
  * 위와 같이 명시적으로 생성자를 부를 때 에만 허용할 수 있게 됩니다.


# mutable
  * const 함수 내부에서는 멤버 변수들의 값을 바꾸는 것이 불가능 합니다.
  * 하지만, 만약에 멤버 변수를 mutable 로 선언하였다면 const 함수에서도 이들 값을 바꿀 수 있습니다.



```C++
#include <iostream>

class A {
  int data_;

 public:
  A(int data) : data_(data) {}
  void DoSomething(int x) const {
    data_ = x;  // 불가능!
  }

  void PrintData() const { std::cout << "data: " << data_ << std::endl; }
};

int main() {
  A a(10);
  a.DoSomething(3);
  a.PrintData();
}
```

  * ![image](https://github.com/Anjinhyoung/Coding-Learning/assets/117788976/436e359b-7d00-45e0-a556-6829a9bfa840)
  * 위와 같이 const 함수 안에서 멤버 변수에 값을 대입한다는 오류를 볼 수 있습니다. 하지만 data_ 를 mutable 로 선언하면 어떨까요.

```C++
#include <iostream>

class A {
  mutable int data_;

 public:
  A(int data) : data_(data) {}
  void DoSomething(int x) const {
    data_ = x;  // 가능!
  }

  void PrintData() const { std::cout << "data: " << data_ << std::endl; }
};

int main() {
  A a(10);
  a.DoSomething(3);
  a.PrintData();
}

출력 결과

data: 3
  * 위 처럼 data_ 의 값이 const 함수 안에서 바뀐 것을 알 수 있습니다.
```



# 출처
  * 사이트: 모두의 코드, 페이지: 클래스의 explicit 과 mutable 키워드 , 사이트: https://modoocode.com/253
