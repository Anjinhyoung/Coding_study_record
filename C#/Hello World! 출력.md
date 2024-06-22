
```C#
using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
```
  * C#의 기본 출력 문법이다.
  * 차근 차근 하나씩 알아보자

```C#
using System
```
  * C#에서 using System은 'System'의 이름공간을 사용하겠다는 선언이다.
  * 이 개념은 C++이랑 비슷하다. like #include <>

```C++
#include <iostream>
using namespace std;

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}

```
  * 이런 식으로 C++의 using namespace를 사용해서 귀찮은 'std::'를 안 쓰듯이 할 수 있게 해준다.
  * 만약에 **using System**이 없다면?

```C#
namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("Hello World!");
        }
    }
}
```
  * 이런식으로 기본 코드 앞에 **System**을 붙여줘야 코드가 작동할 수 있다.

```C#
namespace HelloWorld
```
  * 다음은 **namespace**인데
  * namespace는 **성격이나 하는 일에 따라 클래스, 메소드 등을 하나의 이름으로 묶어 두는 것**이다.
  * 사실 이 부분은 내가 아직 이해를 제대로 하지를 못해서 지금은 뭐라 설명을 못 하겠다;; 나중에 이해하면 다시 적도록 한다.
  
