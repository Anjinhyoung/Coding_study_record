# 들어가기 앞서서
```
메모리를 관리하는 문제는 언제나 중요한 문제입니다. 프로그램이 정확하게 실행되기 위해서는 컴파일 시에
모든 변수의 주소값이 확정되어야만 했습니다. 하지만, 이를 위해서는 프로그램에 많은 제약이 따르기 때문에
프로그램 실행 시에 자유롭게 할당하고 해제할 수 있는 힙(heap) 이라는 공간이 따로 있습니다.

하지만 이전에 컴파일러에 의해 어느정도 안정성이 보장되는 스택(stack)과는 다르게 힙은 사용자가 스스로 제어해야
하는 부분인 만큼 책임이 따릅니다.
```
# new, delete 사용하기
```C++
new 와 delete 사용
#include <iostream>

int main() {
  int* p = new int;
  *p = 10;

  std::cout << *p << std::endl;

  delete p;
  return 0;
}

출력 결과 10
```
  * int* p = new int; 먼저 이렇게 int 크기의 공간을 할당하여 그 주소값을 p에 집어 넣었음을 알 수 있습니다.
  * 이제 p 위치에 할당된 공간에 *p = 10; 을 통해서 값을 집어넣었고 이를 출력하였습니다. 마지막으로 할당된 공간을 해제하기 위해서
  * delete를 사용해야 한다.
  * delete p를 하게 되면 p에 할당된 공간히 해제됩니다.

# new로 배열 할당하기

```C++
#include <iostream>

int main() {
  int arr_size;
  std::cout << "array size : ";
  std::cin >> arr_size;
  int *list = new int[arr_size];
  for (int i = 0; i < arr_size; i++) {
    std::cin >> list[i];
  }
  for (int i = 0; i < arr_size; i++) {
    std::cout << i << "th element of list : " << list[i] << std::endl;
  }
  delete[] list;
  return 0;
}

실행 결과
array size : 5
1
4
2
6
8
0th element of list : 1
1th element of list : 4
2th element of list : 2
3th element of list : 6
4th element of list : 8
```
  * list에 new 를 이용하여 크기가 arr_size인 int 배열을 생성하였습니다. 배열을 생성할 때
  * []를 이용해 배열의 크기를 넣어주면 된다.
  * 마지막으로 delete[]를 통해서 해제하면 됩니다. 즉 new - delete가 짝을 이루고 new[] - delete[]가 짝을 이루는 것이지요
