# is 키워드
  * is 키워드는 **객체**가 특정 **타입**인지 확인할 때 사용한다.

```C#
사용 예제

class Base {}
class AA : Base { }
class BB : Base { }
```
  * 이런 식으로 기반 클래스와 파생 클래스가 있다고 가정하자

```C#
Base b1 = new AA();

if (b1 is AA)
{
    Console.WriteLine("b1은 AA의 객체");
}

Base b2 = new Base();
if (b2 is AA)
{
    Console.WriteLine("b2는 AA의 객체");
}
else
{
    Console.WriteLine("b2는 Base의 객체");
}
```

# object 키워드
 * object 키워드는 모든 데이터 타입의 기본 타입
 * 모든 클래스는 object로 부터 상속을 받는다.
 * object는 키워드는 박싱과 언박싱을 통해 값 형식을 참조 형식으로 변환하거나 그 반대로 변환할 때 사용한다.

```C#
int a = 100;  // 스택 영역에 저장
object o = a; // 박싱 => a의 값을 힙에 저장
int c = (int)0; // 언박싱 => o에 저장된 값을 스택에 저장
```

# as 키워드
 * as 키워드는 객체를 특정 타입으로 **형변환**(캐스팅)할 때 사용한다.
 * 캐스팅에 실패하면 null을 반환한다.
 * as 키워드는 참조형식에만 사용할 수 있다.

```C#
object oBase = new Base();
object oAA = new AA();

AA aa1 = oAA as AA;
if (aa1 != null)
{
    Console.WriteLine("oAA 캐스팅 성공");
}

AA aa2 = oBase as AA;
if (aa2 != null)
{
    Console.WriteLine("oBase 캐스팅 성공");
}
else
{
    Console.WriteLine("oBase 캐스팅 불가");
}
