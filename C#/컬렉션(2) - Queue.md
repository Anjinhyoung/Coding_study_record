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
