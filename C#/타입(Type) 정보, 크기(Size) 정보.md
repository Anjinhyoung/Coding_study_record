# typeof

```C#
Type intType = typeof(int);
Console.WriteLine(intType);

출력 값

System.Int32
```
  * **typeof** 연산자는 컴파일 타임에 타입의 정보를 가져온다.
  * System.Int32는 .NET 프레임워크와 C#에서 32비트 정수를 나타내는 데이터 타입
  * 이 이름은 네임스페이스와 클래스를 포함하여 타입을 완전히 지정한 것

# sizeof

```C#
int size = sizeof(int);
Console.WriteLine(size);

출력 값

4
```
  * **sizeof** 연산자는 값 형식의 메모리 크기를 바이트 단위로 반환

# GetType()

```C#
int number = 42;
Type type = number.GetType();
Console.WriteLine(type);

출력 값

System.Int32
```
  * **GetType()** 메서드는 런타임에 객체의 타입 정보를 가져온다.

# typeof vs GetType()

  * **typeof**는 타입 이름을 알고 있을 때, 컴파일 타임에 타입 정보를 가져오는 데 사용한다.
  * **GetType()** 은 객체의 인스턴스가 있을 때, 런타임에 해당 객체의 타입 정보를 가져오는 데 사용된다.
