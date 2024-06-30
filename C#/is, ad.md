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
