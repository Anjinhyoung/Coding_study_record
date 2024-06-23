# enum 사용법 

```C#
using System;


namespace Practice
{
    internal class Program
    {
        static void Main(string[] args)
        {
            enum Color
        {
            RED,
            GREEN,
            BLUE
        }
        }
    }
}
```
  * enum은 메인 메서드 안에서 사용할 수 없다.
  * enum은 클래스, 구조체 또는 이름공간의 멤버로 선언되어야 한다.
  * 따라서 올바른 enum 사용법은

```C#
enum 사용법 1
클래스 내부에서 정의하여 클래스의 멤버로 취급

using System;


namespace Practice
{
    internal class Program
    {
        enum Color
        {
            RED,
            GREEN,
            BLUE
        }
        static void Main(string[] args)
        {

        }
    }
}

```

```C#
enum 사용법 2
이름 공간 내부에서 선언하기

using System;


namespace Practice
{
    enum Color
    {
        RED,
        GREEN,
        BLUE
    }
    internal class Program
    {

        static void Main(string[] args)
        {

        }
    }
}
```

# 클래스 내부 선언 VS 이름 공간 내부에서 선언
  * 첫 번째 클래스 내부에서 enum을 선언하는 것은 클래스 내부에 정의되어 해당 클래스 내부에서만 사용 가능
  * 두 번째 이름 공간 내부에서 enum을 선언하는 것은 이름 공간 내부에 속한 모든 클래스에서 사용 가능하다.

# enum 사용법2

 * enum은 기본적으로 정수형 데이터를 기반으로 하지만 다음과 같은 데이터들도 사용할 수 있다.
   ```C#
   1. 정수형: byte, sbyte, short, ushort, int, uint, long, ulong
   2. 문자형: char
   ```
 * 즉, enum의 기본 데이터 형식은 숫자와 문자로 제한

 * 기본적으로는 **int** 형식으로 사용한다.
 * 다음과 같은 예시를 보자
   ```C#
   enum Days
    {
        Monday,    // 0
        Tuesday,   // 1
        Wednesday, // 2
        Thursday,  // 3
        Friday     // 4
    }
   ```
 * Days 열거형(enum)에서 각 상수들은 순서대로 0부터 4까지의 값을 가집니다.
 * 다만 중간에 숫자가 바뀌면 그 숫자 중심으로 바뀐다.
   ```C#
   {
        Monday,    // 0
        Tuesday,   // 1
        Wednesday = 100 // 100
        Thursday,  // 101
        Friday     // 102
    }
   ```
   
 * 또한 기본 int 타입을 다른 타입으로 변경 가능하다.
   ```C#
   enum Days : byte
    {
        Monday,    // 0
        Tuesday,   // 1
        Wednesday = 500 // 500
        Thursday,  // 501
        Friday     // 502
    } 
   ```
 * 추가 예시(이런 것도 가능하다.)
   ```C#
   enum Days : byte
    {
        Monday = 1000   // 1000
        Tuesday,   // 1001
        Wednesday= 500 // 500
        Thursday,  // 501
        Friday     // 502
    } 
   ```   
