# call by value
  * 함수나 메서드에 인수를 전달할 때 사용하는 기본적인 전달 방식 중 하나
  * 이 방법에서는 인수로 전달된 변수의 **값**이 함수에 전달된다.
  * 즉, 함수 내부에서는 인수의 복사본을 사용하며, 함수 내부에서 그 값을 변경해도 원래 변수의 값은 영향을 받지 않는다.

```C#
using System;

class Program
{

    static void ModifyValue(int value)
    {
        value = 20;
        Console.WriteLine($"Inside method: {value}");
    }

    static void Main()
    {
        int originalValue = 10;
        Console.WriteLine($"Before method call: {originalValue}");
        
        ModifyValue(originalValue);
        
        Console.WriteLine($"After method call: {originalValue}");
    }
}

출력 결과
method call: 10
method: 20
method call: 10
```

# call by reference
  * 함수에 인수를 전달할 때 변수의 메모리 주소를 전달하는 방법

```C#

using System;

class Program
{
    static void ModifyValue(ref int value)
    {
        value = 20;
        Console.WriteLine($"Inside method: {value}");
    }

    static void Main()
    {
        int originalValue = 10;
        Console.WriteLine($"Before method call: {originalValue}");
        
        ModifyValue(ref originalValue);
        
        Console.WriteLine($"After method call: {originalValue}");
    }
}

method call: 10
method: 20
method call: 20
```
