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
