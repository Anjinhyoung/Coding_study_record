# var 사용법

```C#
using System;

namespace var_using
{
  interanl class Program
  {
    static void Main(String[] args)
    {
      var numVar = 100; // list C++ auto
      var numFvar = 10.0;

      Console.WriteLine($"numVar:{numVar}");
      Console.WriteLine($"numFVar:{numFVar}");
    }
  }
}

출력 결과
numVar:100
numFVar:0.01
```

  * 간단한 var 사용법이다.
  * 정수형도 아니고 실수형도 아니고 그 모든 타입을 가질 수 있는 var 이것은
  * C++의 auto라고 생각하면 된다.
  * 하지만 이런 편리한 var 사용법도 몇 가지 제약사항이 있다.

# var의 제약
  ### 1. 초기화 필요
  ```C#
  var x; // 컴파일 오류
  var y = 5; // 유효, y는 int 타입으로 유추됨
  ```
  * var로 선언된 변수는 선언과 동시에 초기화되어야한다.

  ### 2. null값의 사용 불가능
  ```C#
  var numNull = null; 
  ```
  * C#에서는 var을 사용할 때 컴파일러가 초기화식의 타입을 기반으로 변수의 타입을 추론
  * 그러나 'null'은 타입을 정확히 추론을 할 수가 없어 var이랑 같이 사용할 수 없다.
  ### 2-1. null의 사용법
  ```C#

int? nullableInt = null;
double? nullableDouble = null;
  ```

  ### 2-2. null의 사용법2
  ```C#
int? num = null;
double? dNum = 100.01;
```
  * 타입 옆에 '?'를 붙이면 꼭 null 값만 넣을 수 있는 게 아니다. 그 타입에 맞는 값도 넣을 수 있다.
  * 다만 주의할 점은 타입 옆에 '?'로 설정한 변수를 다른 변수에 대입할 경우 **double DNUM  =  (dobule)dNum** 이렇게 명시적으로 형 변환을 해줘야 한다.



  ### 3. Only 지역 변수로만
  ```C#
  class MyClass
{
    // 멤버 변수로는 var를 사용할 수 없음
    // var myVar; // 컴파일 오류

    // 명시적으로 타입을 지정해야 함
    private int myInt;
    private string myString;
}
```
  * var 키워드는 로컬 변수(메서드 내에서 선언된 변수)에서만 사용할 수 있다.
  *  멤버 변수(클래스나 구조체의 필드)로는 var를 사용할 수 없다.
  *  멤버 변수를 선언할 때는 반드시 명시적으로 타입을 지정해주어야 한다.




  ### 4. 반환 타입으로도 불가능
  ```C#
public var GetValue()
{
    return 42; // 컴파일 오류: 함수 반환 타입을 명시적으로 지정해야 한다
}

public int GetValue()
{
    return 42; 
}
```
  * 함수의 반환 타입은 반드시 명시적으로 지정해줘야 한다.

  ### 5. 파라미터도 불가
  ```C#
public void PrintValue(var value)
{
    Console.WriteLine(value); // 컴파일 오류
}

public void PrintValue(int value)
{
    Console.WriteLine(value); 
}
```
  * 함수의 파라미터도 반드시 명시적으로 지정해줘야 한다.
