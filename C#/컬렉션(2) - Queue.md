# 예제 코드
```C#
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace _12_Queue
{
    class Program
    {
        static void Main(string[] args)
        {
            //Queue 기초
            {
                Queue queue = new Queue();

                queue.Enqueue(1);
                queue.Enqueue(2);
                queue.Enqueue(3);
                queue.Enqueue(4);

                PrintQueue(queue, "기초");

                Console.WriteLine("Dequeue():" + queue.Dequeue());
                Console.WriteLine("Dequeue():" + queue.Dequeue());

                PrintQueue(queue, "Dequeue");
                queue.Enqueue(1);
                PrintQueue(queue, "Dequeue");

                int num = (int)queue.Dequeue();
                Console.WriteLine("num:" + num);
            }

            //Queue 초기화 방법, Peek
            {
                int[] arrays = { 0, 1, 2, 4, 5 };
                Queue queue = new Queue(arrays);

                PrintQueue(queue, "arrays");

                Console.WriteLine("Peek():" + queue.Peek());
                PrintQueue(queue, "After peek");
            }

            //Queue활용 - pool
            {
                int add = 0;
                Queue poolQueue = new Queue();
                Random rand = new Random();

                for (int i = 0; i < 20; i++)
                {
                    poolQueue.Enqueue(i);
                }

                int GetNumber()
                {
                    if (poolQueue.Count > 0)
                    {
                        return (int)poolQueue.Dequeue();
                    }
                    else
                    {
                        return 20 + ++add;
                    }
                }

                void ReturnPool(int num)
                {
                    poolQueue.Enqueue(num);
                }

                for (int i = 0; i < 100; i++)
                {
                    int temp = GetNumber();
                    Console.WriteLine("num: " + temp);

                    System.Threading.Thread.Sleep(100);

                    //if(rand.Next(0, 100) % 2 == 0)
                        ReturnPool(temp);
                }
            }

            void PrintQueue(Queue queue, string desc = "")
            {
                Console.WriteLine(desc);

                foreach (var item in queue)
                {
                    Console.Write(" " + item);
                }

                Console.WriteLine();
            }
        }
    }
}
```
# 기본 설명
  * Enquque: queue.Enqueue(1);와 같이 Enqueue 메서드를 사용해 큐에 요소를 추가
  * Dequque: queue.Dequeue();를 통해 큐에서 요소를 제거하고 반환 이때 제거된 요소는 큐에 가장 먼저 추가된 요소



```C#
void PrintQueue(Queue queue, string desc = "")
{
    Console.WriteLine(desc);

    foreach (var item in queue)
    {
        Console.Write(" " + item);
    }

    Console.WriteLine();
}
```
 * PrintQueue() 함수는 Queue를 받아서 해당 Queue의 내용을 출력하는 함수
 * Queue의 각 순회하면서 출력한다


```C#
int[] arrays = { 0, 1, 2, 4, 5 };
Queue queue = new Queue(arrays);

PrintQueue(queue, "arrays");

Console.WriteLine("Peek():" + queue.Peek());
PrintQueue(queue, "After peek");
```
 * 배열로 초기화: Queue queue = new Queue(arrays)를 통해 배열 arrays의 요소로 큐를 초기화할 수  있다.
 * Peek: queue.Peek() 큐에서 요소를 제거하지 않고 첫 번째 요소를 반환


```C#
int add = 0;
Queue poolQueue = new Queue();
Random rand = new Random();

for (int i = 0; i < 20; i++)
{
    poolQueue.Enqueue(i);
}

int GetNumber()
{
    if (poolQueue.Count > 0)
    {
        return (int)poolQueue.Dequeue();
    }
    else
    {
        return 20 + ++add;
    }
}

void ReturnPool(int num)
{
    poolQueue.Enqueue(num);
}

for (int i = 0; i < 100; i++)
{
    int temp = GetNumber();
    Console.WriteLine("num: " + temp);

    System.Threading.Thread.Sleep(100);

    ReturnPool(temp);
}
```
 * Queue 생성: Queue poolQueue = new Queue();로 큐를 생성하고 for 루프를 통해 0부터 19까지의 숫자를 큐에 추가
 * GetNumber 메서드: 큐가 비어있지 않으면 Dequeue를 통해 요소를 제거하고 반환합니다. 큐가 비어있으면 새로운 숫자를 생성하여 반환
 * ReturnPool 메서드: 숫자를 큐에 다시 추가
 * for 루프: 100번 반복하여 GetNumber를 호출하고 결과를 출력
 * 큐를 활용하여 숫자를 관리하는 풀을 구현한 것
