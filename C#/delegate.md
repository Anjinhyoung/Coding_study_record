# delegate
  * C#의 delegate는 C와 C++의 함수 포인터와 비슷한 개념으로, 메서드를 참조할 수 있는 형식을 정의하는 데 사용된다.
```C#
delegate 형식 선언하기

delegate void DelegatePrint();

이 delegate 반환형은 void이고 매개변수가 없는 메서드를 참조할 수 있다.
```
  * 그 다음으로는 delegate에 참조할 수 있는 메서드가 필요하다.

```C#
static void PrintHello()
{
   Console.WriteLine("PrintHello");
}

static void PrintValue()
{
   Console.WriteLine("PrintValue");
}

이 메서드들은 반환형이 void이고 매개변수가 없어서 DelegatePrint delegate 형식과 일치한다.
```
  * 그 다음 Main 메서드에서는 DelegatePrint 형식의 delegate 인스턴스를 선언하고
  * 초기화를 해주고 선언하면 Delegate활용은 끝났다.

```C#
DelegatePrint dPrint = PrintHello;
dPrint();

출력 결과
PrintHello
```

# delegate 주의 사항 

```C#
delegate void DelegatePrint();
```
  * 이런 식으로 반환 값은 void 매개 변수가 없는 delegate를 만들었을 경우 그의 맞는 함수에 초기화를 해줘야 한다.
  * 이게 무슨 말이냐면

```C#
static void PrintHello()
{
    Console.WriteLine("PrintHello");
}

이 함수는 DelegatePrint()에 대해서 참조할 수 있다 똑같이 반환 타입은 void 매개 변수가 없으니까

===================================

static void PrintSum(int a, int b)
{
    Console.WriteLine("PrintSum: " + (a + b));
}

하지만 이 함수는 DelegatePrint()에 대해서 참조할 수 없다. 반환 타입은 똑같지만 매개 변수가 있으니까
이 함수에 대해 delegate에 대해 참조 할려면 똑같이 만들어 주면 된다.

delegate void DelegatePrintSum(int a, int b); 이런 식으로 
```

# 전체 코드
```C#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _039_Method_delegate
{
    class Program
    {
        delegate void DelegatePrint();

        static void PrintHello()
        {
            Console.WriteLine("PrintHello");
        }

        static void PrintValue()
        {
            Console.WriteLine("PrintValue");
        }

        delegate void DelegatePrintSum(int a, int b);
        static void PrintSum(int a, int b)
        {
            Console.WriteLine("PrintSum: " + (a + b));
        }

        static void TestDelegate(int a, int b, DelegatePrintSum dSum)
        {
            Console.WriteLine("a: " + a + "  b: " + b);

            if (dSum != null)
            {
                Console.Write("TestDelegate ");
                dSum(a, b);
            }
        }

        static void Main(string[] args)
        {
            {
                //int num
                DelegatePrint dPrint = null;
                dPrint = PrintHello;
                dPrint();

                dPrint = PrintValue;
                dPrint();
            }

            {
                Console.WriteLine("멀티 캐스트 +=");

                DelegatePrint dPrint1 = PrintHello;
                dPrint1 += PrintValue;
                dPrint1 += PrintHello;
                dPrint1 += PrintHello;
                dPrint1();

                Console.WriteLine("멀티 캐스트 -=");
                dPrint1 -= PrintValue;
                dPrint1();
            }

            {
                Console.WriteLine("멀티 캐스트 Combine");
                DelegatePrint combineDelegate = (DelegatePrint)Delegate.Combine(new DelegatePrint[] { PrintValue, PrintHello, PrintValue });
                combineDelegate();

                Console.WriteLine("멀티 캐스트 Combine2");
                DelegatePrint aa = PrintHello;
                DelegatePrint bb = PrintValue;
                DelegatePrint cc = PrintHello;

                DelegatePrint combineDelegate2 = (DelegatePrint)Delegate.Combine(aa, bb, cc);
                combineDelegate2();

                Console.WriteLine("멀티 캐스트 Remove");
                DelegatePrint combineDelegate3 = (DelegatePrint)Delegate.Remove(combineDelegate2, bb);
                combineDelegate3();
            }

            DelegatePrintSum dPrintSum = PrintSum;
            dPrintSum(10, 10);

            {
                void Sum(int a, int b)
                {
                    Console.Write("Sum:" + (a + b));
                }

                TestDelegate(10, 20, Sum);
            }
        }
    }
}

```
