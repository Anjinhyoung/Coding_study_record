#this
  * C++에서도 나왔지만 여기서 한 번더 설명하자면 **자기 자신**을 가리킨다라고 생각하면 된다.
  * 다음 this의 사용법을 알아보자

```C#
동일한 이름의 파라미터를 사용하는 경우

using System;

class MyClass
{
    private int value;

    public MyClass(int value)
    {
        this.value = value; // this를 사용하여 멤버 변수와 파라미터 이름이 같은 경우를 구분
    }

    public void PrintValue()
    {
        Console.WriteLine($"Value: {this.value}");
    }
}

class Program
{
    static void Main()
    {
        MyClass obj = new MyClass(10);
        obj.PrintValue();
    }
}

```

```C#
자신의 인스턴스를 리턴값으로 가지는 경우

using System;

class MyClass
{
    private int value;

    public MyClass(int value)
    {
        this.value = value;
    }

    public MyClass GetInstance()
    {
        return this; // 자신의 인스턴스를 반환
    }

    public void PrintValue()
    {
        Console.WriteLine($"Value: {this.value}");
    }
}

class Program
{
    static void Main()
    {
        MyClass obj1 = new MyClass(5);
        MyClass obj2 = obj1.GetInstance();

        obj1.PrintValue();
        obj2.PrintValue();
    }
}

```

```C#
생성자를 호출하는 this

using System;

class MyClass
{
    private int value;

    public MyClass() : this(10) // 다른 생성자를 호출하는 this
    {
    }

    public MyClass(int value)
    {
        this.value = value;
    }

    public void PrintValue()
    {
        Console.WriteLine($"Value: {this.value}");
    }
}

class Program
{
    static void Main()
    {
        MyClass obj1 = new MyClass();
        obj1.PrintValue(); // 출력 결과: Value: 10

        MyClass obj2 = new MyClass(20);
        obj2.PrintValue(); // 출력 결과: Value: 20
    }
}

```
