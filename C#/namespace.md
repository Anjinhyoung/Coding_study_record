# namespace
  *  클래스를 포함한 여러 타입들을 조직화하고 분류하는 데 사용
  *  namespace기초 class, interface, struct, enum, delegate
  *  다음 예시를 보자

```C#
기본 예시

namespace NameAA
{
    public class AA
    {
        public AA()
        {
            Console.WriteLine("NameAA AA Instance");
        }
    }
}

```

  * namespace 키워드를 사용하여 정의
  * 위의 예시에서는 NameAA 네임스페이스 안에 AA 클래스가 정의되어 있다.

```C#
namespace 중첩

namespace NameBB
{
    namespace subBB
    {
        class BB
        {
            public BB()
            {
                Console.WriteLine("NameBB_subBB_BB Instance");
            }
        }
    }
}

```


```C#
별칭 사용

using AA = NameAA.AA;
using NameBB.subBB;
using BBB = NameBBB.subBBB.BBB;

```
  *  예시에서는 NameAA 네임스페이스의 AA 클래스를 AA 별칭으로, NameBBB.subBBB 네임스페이스의 BBB 클래스를 BBB 별칭으로 사용하고 있다.


```C#
전체 코드

using System;

using AA = NameAA.AA; // NameAA 네임스페이스의 AA 클래스를 AA 별칭으로 사용
using NameBB.subBB; // NameBB.subBB 네임스페이스를 사용
using BBB = NameBBB.subBBB.BBB; // NameBBB.subBBB 네임스페이스의 BBB 클래스를 BBB 별칭으로 사용

namespace NameAA
{
    public class AA
    {
        public AA()
        {
            Console.WriteLine("NameAA AA Instance");
        }
    }

    struct MyStruct
    {

    }

    enum MyEnum
    {

    }

    delegate void Print();
}

namespace NameAAA
{
    public class AA
    {
        public AA()
        {
            Console.WriteLine("NameAAA AA Instance");
        }
    }
}

namespace NameBB
{
    namespace subBB
    { 
        class BB 
        {
            public BB()
            {
                Console.WriteLine("NameBB_subBB_BB Instance");
            }
        }
    }
}

namespace NameBBB.subBBB
{
    class BBB
    {
        public BBB()
        {
            Console.WriteLine("NameBBB_subBBB_BBB Instance");
        }
    }
}

namespace _045_Class_namespace
{
    class Program
    {
        static void Main(string[] args)
        {
            // namespace기초
            {
                AA aa1 = new AA(); // NameAA.AA 클래스의 인스턴스 생성
                NameAAA.AA aa2 = new NameAAA.AA(); // NameAAA.AA 클래스의 인스턴스 생성
            }

            // namespace중첩
            {
                BB bb = new BB(); // NameBB.subBB.BB 클래스의 인스턴스 생성
                BBB bbb = new BBB(); // NameBBB.subBBB.BBB 클래스의 인스턴스 생성
            }
        }
    }
}
```
