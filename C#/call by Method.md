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


# ref vs out
 ## ref
  1. 변수 초기화: **ref**를 사용하여 전달되는 변수는 함수 호출 전에 반드시 **초기화**되어 있어야 한다.
  2. 값의 전달 및 반환: **ref**를 사용하면 함수 내에서 전달된 변수의 값을 읽고 수정할 수 있다. 함수가 반환할 때 전달된 변수의 값이 수정될 수 있다.

 ## out
  1. 변수 초기화: **out**을 사용하여 전달되는 변수는 함수 호출 전에 초기화될 필요가 없다. 함수 내에서 반드시 초기화되어야 한다.
  2. 값의 전달 및 반환: **out**을 사용하면 함수 내에서 변수에 값을 할당하여 반환할 수 있다. 함수가 반환할 때 변수의 값이 초기화되어야 한다.

```C#
out 사용법

using System;

class Program
{
    static void ModifyValue(out int value)
    {
        value = 20;
        Console.WriteLine($"Inside method: {value}");
    }

    static void Main()
    {
        int originalValue;
        ModifyValue(out originalValue);
        
        Console.WriteLine($"After method call: {originalValue}");
    }
}
```
