# 컬랙션
  * C#에서 지원하는 자료구조 클래스
  * 종류는 Queue, Stack, ArrayList, Hashtable 등
  * object 형식을 사용하여서 **박싱**과 **언박싱**이 발생 성능이 떨어지는 이슈가 있다.
  * 대용량 데이터를 처리하기 위해서는 적절한 자료구조를 사용해야 그렇지 않은 경우 엄청난 비용(속도, 메모리 낭비)등의 손실을 발생하므로 **중요도**가 높다.

# Generic(제네릭) 타입과 Non - Generic 타입 
 1. Generic: 박싱과 언박싱이 발생하지 않음. 성능면에서 훨씬 좋음
    * 데이터를 저장하는 시점에 데이터 타입을 지정(박싱 발생하지 않음)
    * 데이터를 사용하는 시점에 데이터 타입을 지정했으므로 형변환(언박싱) 하지 않아도 됨
 2. Non - Generic: 박싱과 언박싱이 과정에서 부하가 발생함 (메모리 낭비와 속도 저하)
    * 데이터를 저장하는 시점에 object로 형변환이 됨 박싱
    * 데이터를 사용하는 시점에 원래의 타입으로 변환 언박



 # BitArray
  * C#에서 제공되는 데이터 구조 중 하나로 비트(bit)의 배열을 효율적으로 다루기 위한 클래스

```c#
예제 코드

using System;
using System.Collections;

namespace _10_BitArray
{
    public static class BitArrayExtention
    {
        public static int ToInt(this BitArray bt)
        {
            int temp = 0;

            for (int i = 0; i < bt.Count; i++)
            {
                if(bt[i])
                {
                    temp |= 1 << (bt.Count - 1 - i);
                }
            }

            return temp;
        }

        public static BitArray Reverse(this BitArray bt)
        {
            BitArray temp = new BitArray(bt.Count);
            for (int i = 0; i < bt.Count; i++)
            {
                temp.Set(bt.Count - 1 - i, bt.Get(i));
            }

            return temp;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            //BitArray기초
            {
                //1110 0000
                BitArray bitArray = new BitArray(8);
                PrintBit(bitArray);

                bitArray.Set(0, true);
                bitArray.Set(1, true);
                bitArray.Set(2, true);
                PrintBit(bitArray, "Set");

                int getNum = bitArray.ToInt();
                Console.WriteLine("getNum: " + getNum);

                BitArray temp = bitArray.Reverse();
                PrintBit(temp, "Reverse");
            }

            {
                //0000 0100
                BitArray bitArray = new BitArray(new byte[] { 4 });
                PrintBit(bitArray, "new byte");

                bitArray = bitArray.Reverse();
                PrintBit(bitArray, "Reverse");
                Console.WriteLine("getNum: " + bitArray.ToInt());
            }

            {
                //bool[] result = new BitArray(10000, true).Cast<bool>().ToArray();
                bool[] result = new bool[10000];
                new BitArray(10000, true).CopyTo(result, 0);
                foreach (var item in result)
                {
                    Console.Write($" {item} ");
                }
            }

            void PrintBit(BitArray bitArray, string desc = "")
            {
                Console.WriteLine(desc);

                foreach (bool item in bitArray)
                {
                    Console.Write((item == true) ? "1" : "0");
                }
                Console.WriteLine();
            }
        }
    }
}
```
 * **using System.Collection**
   * 기본적인 자료구조 클래스를 포함하는 네임스페이스이다.

```C#
void PrintBit(BitArray bitArray, string desc = "")
{
    Console.WriteLine(desc);

    foreach (bool item in bitArray)
    {
        Console.Write((item == true) ? "1" : "0");
    }
    Console.WriteLine();
}
```
 * **PrintBit() 함수**
   * PrintBit() 함수는 BitArray를 받아서 해당 BitArray의 내용을 출력하는 함수
   * bitArray의 각 원소(bool 값)을 순회하면서 1 또는 0으로 변환하여 출력한다.


 ```C#
public static int ToInt(this BitArray bt)
{
    int temp = 0;

    for (int i = 0; i < bt.Count; i++)
    {
        if(bt[i])
        {
            temp |= 1 << (bt.Count - 1 - i);
        }
    }

    return temp;
}
```
 * **확장 함수 ToInt()**
   * ToInt() 메서드는 BitArray를 정수형(int)으로 변환하는 확장 메서드이다.
   * bt를 순회하면서 true인 원소에 해당하는 비트 위치에 1을 설정한다.
   * 비트를 설정한 후 최종적으로 이 값을 정수형으로 반환한다.


```C#
public static BitArray Reverse(this BitArray bt)
{
    BitArray temp = new BitArray(bt.Count);
    for (int i = 0; i < bt.Count; i++)
    {
        temp.Set(bt.Count - 1 - i, bt.Get(i));
    }

    return temp;
}

```
 * **리버스 확장 함수 Reverse()**
  * Reverse() 메서드는 BitArray의 순서를 반대로 뒤집는 확장 메서드이다.
  * 새로운 BitArray 객체 temp를 생성한 후, 기존 bt의 원소를 거꾸로 설정하여 temp에 복사한다.
  * 반환된 temp는 bt의 원소 순서가 반대로 된 새로운 BitArray이다.
