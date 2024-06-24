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


