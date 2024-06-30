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

# Combine, Remove
  * **Combine, Remove**은 보통 delegate와 관련된 작업에서 사용되는 메서드로 여러 개의 delegate르 하나로 결합하거나
  * 결합을 해제하는 데 사용된다. 이를 통해 여러 메서드를 호출하는 multicast delegate를 만들 수 있다.
  * 다음 예시를 보자

```C#
DelegatePrint dPrint1 = PrintHello;
dPrint1 += PrintValue;
dPrint1 += PrintHello;
dPrint1 += PrintHello;
dPrint1();
```
  * 이런 식으로 **+=** 연산자를 이용하여 여러 메서드를 하나의 delegate에 추가하는 방식으로 사용하고 있다.
  * 하지만 Combine을 사용하면 더 간단하게 할 수 있다.

```C#
멀티 캐스트 Combine 방법 1

DelegatePrint combineDelegate = (DelegatePrint)Delegate.Combine(new DelegatePrint[] {PrintValue, PrintHello, PrintValue});
combineDelegate();
```
 * (DelegatePrint)로 캐스팅 변환하는 이유는 Delegate.Combine이 반환하는 타입이 System.Delegate 타입이기 때문이다.
 *  C#에서는 이 반환된 delegate를 다시 원래의 delegate 타입으로 캐스팅해야 제대로 사용할 수 있다.

```C#
멀티 캐스트 Combine 방법 2

DelegatePrint aa = PrintHello;
DelegatePrint bb = PrintValue;
DelegatePrint cc = PrintHello;

DelegatePrint combineDelegate2 = (DelegatePrint)Delegate.Combine(aa, bb, cc);
combineDelegate2();
```

```C#
멀티 캐스트 Remove 방법

DelegatePrint combineDelegate3 = (DelegatePrint)Delegate.Remove(combineDelegate,bb);
combineDelegate3();
```
