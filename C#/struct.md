# struct(구조체)
  * 구조체는 값 형식으로 데이터와 관련된 기능을 그룹화하여 하나의 단위로 관리하기 위한 형식

```C#
간단한 예제

using System;

struct Point
{
    public int X { get; set; }
    public int Y { get; set; }

    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }

    public void Display()
    {
        Console.WriteLine($"Point: ({X}, {Y})");
    }
}

class Program
{
    static void Main()
    {
        Point p1 = new Point(10, 20);
        p1.Display();

        Point p2 = p1; 
        p2.X = 30;

        p1.Display(); 
        p2.Display(); 
    }
}
```

# public struct vs struct
  1. public struct
     * 'public': 이 접근 제어자는 구조체가 어디서나 접근 가능함을 의미한다. 즉 이 구조체를 정의한어셈블리(프로젝트) 뿐만 아니라 다른 어셈블리에서도 이 구조체에 접근할 수 있다.

 ```C#
public struct Point
{
    public int X { get; set; }
    public int Y { get; set; }

    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }
}

```

  2. struct
     * '기본 접근 수준': 구조체 앞에 접근 제어자가 명시되지 않은 경우, 기본적으로 'internal'접근 수준을 갖는다. 이는 해당 구조체가 정의된 어셈브리 내에서만 접근 가능하고, 다른 어셈블리에서는 접근할 수 없음을 의미

```C#
struct Rectangle
{
    public int Width { get; set; }
    public int Height { get; set; }

    public Rectangle(int width, int height)
    {
        Width = width;
        Height = height;
    }
}
```

# 구조체 멤버 변수 초기화 방법

```C#
생성자를  이용한 초기화

public struct MyPoint
{
    public int x;
    public int y;

    public MyPoint(int x2, int y2)
    {
        x = x2;
        y = y2;
    }
}
```


```C#
개별 멤버 변수 초기화

public struct MyPoint
{
    public int x;
    public int y;
}


MyPoint point2;
point2.x = 100;
point2.y = 200;
```


```C#
배열 요소 초기화

public struct sBook
{
    public int id;
    public string title;
    public string author;
}

// 사용 예시
sBook[] arrayBooks = new sBook[3];

arrayBooks[0].id = 0;
arrayBooks[0].title = "aa";
arrayBooks[0].author = "aaa";
```

```C#
public struct MyPoint
{
    public int x;
    public int y;
}


MyPoint point = new MyPoint { x = 10, y = 10 };
```


  
