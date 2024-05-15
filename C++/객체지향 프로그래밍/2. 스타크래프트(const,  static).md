# 생성자 초기화 리스트

```C++
#include <iostream>

class Marine {
  int hp;                // 마린 체력
  int coord_x, coord_y;  // 마린 위치
  int damage;            // 공격력
  bool is_dead;

 public:
  Marine();              // 기본 생성자
  Marine(int x, int y);  // x, y 좌표에 마린 생성

  int attack();                       // 데미지를 리턴한다.
  void be_attacked(int damage_earn);  // 입는 데미지
  void move(int x, int y);            // 새로운 위치

  void show_status();  // 상태를 보여준다.
};

Marine::Marine() : hp(50), coord_x(0), coord_y(0), damage(5), is_dead(false) {}

Marine::Marine(int x, int y)
    : coord_x(x), coord_y(y), hp(50), damage(5), is_dead(false) {}

void Marine::move(int x, int y) {
  coord_x = x;
  coord_y = y;
}
int Marine::attack() { return damage; }
void Marine::be_attacked(int damage_earn) {
  hp -= damage_earn;
  if (hp <= 0) is_dead = true;
}
void Marine::show_status() {
  std::cout << " *** Marine *** " << std::endl;
  std::cout << " Location : ( " << coord_x << " , " << coord_y << " ) "
            << std::endl;
  std::cout << " HP : " << hp << std::endl;
}

int main() {
  Marine marine1(2, 3);
  Marine marine2(3, 5);

  marine1.show_status();
  marine2.show_status();
}

출력 결과

 *** Marine *** 
 Location : ( 2 , 3 ) 
 HP : 50
 *** Marine *** 
 Location : ( 3 , 5 ) 
 HP : 50

```
  * 예전에 만들었던 Marine 클래스와 달라진 것은 딱 하나인데, 바로 생성자에서 특이한 것을 도입했다는 것입니다.
  * Marine::Marine() : hp(50), coord_x(0), coord_y(0), damage(5), is_dead(false) {}
  * 위 코드는 함수 본체에 아무것도 없습니다.
  * 기존의 생성자는 바로 아래 코드처럼 생겼습니다.

```C++
Marine::Marine() {
  hp = 50;
  coord_x = coord_y = 0;
  damage = 5;
  is_dead = false;
}
```
  * 기존의 생성자는 함수 안에서 멤버 변수들의 초기화를 하고 있었는데 새롭게 도입된
  * Marine::Marine() : hp(50), coord_x(0), coord_y(0), damage(5), is_dead(false) {} 이 코드는
  * 기존에 함수 안에서 멤버 변수들의 초기화 작업을 하고 있습니다.
  * 이것을 **초기화 리스트**라고 하는데 생성자 호출과 동시에 멤버 변수들을 초기화해줍니다.
  * 초기화 리스트에서 한 가지 흥미로운 점은 '(생성자 이름) : var1(arg1), var2(arg2) {}' 이런 초기화 리스트가 있다고 가정을 해봅시다.
  * 여기서 var 들은 클래스의 멤버 변수들을 지칭하고, arg 는 그 멤버 변수들을 무엇으로 초기화 할 지 지칭하는 역할을 합니다.
  * 초기화 리스트는 var1 과 arg1 의 이름이 같아도 되는데, 실제로 아래의 예제는 정상적으로 작동합니다.

```C++
Marine::Marine(int coord_x, int coord_y)
    : coord_x(coord_x), coord_y(coord_y), hp(50), damage(5), is_dead(false) {}
```
  * 위 코드가 정상적으로 작동하는 이유는 coord_x ( coord_x ) 에서 바깥쪽의 coord_x 는 무조건 멤버 변수를 지칭하게 되는데, 이 경우 coord_x 를 지칭하는 것이고,
  * 괄호 안의 coord_x 는 원칙상 Marine 이 인자로 받은 coord_x 를 우선적으로 지칭하는 것이기 때문입니다.
  * 따라서 실제로, 인자로 받은 coord_x 가 클래스의 멤버 변수 coord_x 를 초기화 하게 됩니다.

```C++
Marine::Marine(int coord_x, int coord_y) {
  coord_x = coord_x;
  coord_y = coord_y;
  hp = 50;
  damage = 5;
  is_dead = false;
}
```
  * 위 코드는 컴파일러가 두 coord_x 모두 인자로 받은 coord_x 로 구분해서 오류가 나겠지요.
  * 그러면 왜 도대체 초기화 리스트를 사용해야 되냐고 물을 수 있습니다.
  * 그냥 함수 안에서 초기화하는 거랑 초기화 리스트를 사용하는 거에서 별로 큰 차이점이 없다는 말이죠
  * 하지만 실제로 약간 차이가 있습니다.

``` C++
int a = 10; // 초기화 리스트 사용

int a;
a = 10; // 함수 안에서 초기화
```

  * 만약에 int 가 대신에 클래스 였다면, **전자의 경우 복사 생성자 가 호출되는데, 후자의 경우 디폴트 생성자가 호출된 뒤 대입이 수행된다는 이야기 이겠지요**
  * 따라서 초기화 리스트를 사용하는 것이 조금 더 효율적인 작업이라는 사실을 알 수 있지요.
  * 또한 '생성과 동시에 초기화 되어야 하는 것들' 이 몇 가지 있었습니다. 대표적으로 레퍼런스와 상수가 있지요.


```C++
#include <iostream>

class Marine {
  int hp;                // 마린 체력
  int coord_x, coord_y;  // 마린 위치
  bool is_dead;

  const int default_damage;  // 기본 공격력

 public:
  Marine();              // 기본 생성자
  Marine(int x, int y);  // x, y 좌표에 마린 생성

  int attack();                       // 데미지를 리턴한다.
  void be_attacked(int damage_earn);  // 입는 데미지
  void move(int x, int y);            // 새로운 위치

  void show_status();  // 상태를 보여준다.
};
Marine::Marine()
    : hp(50), coord_x(0), coord_y(0), default_damage(5), is_dead(false) {}

Marine::Marine(int x, int y)
    : coord_x(x), coord_y(y), hp(50), default_damage(5), is_dead(false) {}

void Marine::move(int x, int y) {
  coord_x = x;
  coord_y = y;
}
int Marine::attack() { return default_damage; }
void Marine::be_attacked(int damage_earn) {
  hp -= damage_earn;
  if (hp <= 0) is_dead = true;
}
void Marine::show_status() {
  std::cout << " *** Marine *** " << std::endl;
  std::cout << " Location : ( " << coord_x << " , " << coord_y << " ) "
            << std::endl;
  std::cout << " HP : " << hp << std::endl;
}

int main() {
  Marine marine1(2, 3);
  Marine marine2(3, 5);

  marine1.show_status();
  marine2.show_status();

  std::cout << std::endl << "마린 1 이 마린 2 를 공격! " << std::endl;
  marine2.be_attacked(marine1.attack());

  marine1.show_status();
  marine2.show_status();
}

출력 결과

 *** Marine *** 
 Location : ( 2 , 3 ) 
 HP : 50
 *** Marine *** 
 Location : ( 3 , 5 ) 
 HP : 50

마린 1 이 마린 2 를 공격! 
 *** Marine *** 
 Location : ( 2 , 3 ) 
 HP : 50
 *** Marine *** 
 Location : ( 3 , 5 ) 
 HP : 45

```
  * 위 마린 클래스는 프로그래머들이 실수로 마린의 공격력이 이상하게 변하는 것을 막기 위해서 '기본 공격력'이라는 상수 멤버를 도입해서
  * 딱 고정 시켜 버리고 마음 편하게 프로그래밍 할 수 있도록 하였습니다. 따라서 이를 위해 생성자에서 초기화 리스트를 도입해서
  * default_damage 를 생성과 동시에 초기화 할 수 있도록 하였습니다.

```C++
#include <iostream>

class Marine {
  int hp;                // 마린 체력
  int coord_x, coord_y;  // 마린 위치
  bool is_dead;

  const int default_damage;  // 기본 공격력

 public:
  Marine();              // 기본 생성자
  Marine(int x, int y);  // x, y 좌표에 마린 생성
  Marine(int x, int y, int default_damage);

  int attack();                       // 데미지를 리턴한다.
  void be_attacked(int damage_earn);  // 입는 데미지
  void move(int x, int y);            // 새로운 위치

  void show_status();  // 상태를 보여준다.
};
Marine::Marine()
    : hp(50), coord_x(0), coord_y(0), default_damage(5), is_dead(false) {}

Marine::Marine(int x, int y)
    : coord_x(x), coord_y(y), hp(50), default_damage(5), is_dead(false) {}

Marine::Marine(int x, int y, int default_damage)
    : coord_x(x),
      coord_y(y),
      hp(50),
      default_damage(default_damage),
      is_dead(false) {}

void Marine::move(int x, int y) {
  coord_x = x;
  coord_y = y;
}
int Marine::attack() { return default_damage; }
void Marine::be_attacked(int damage_earn) {
  hp -= damage_earn;
  if (hp <= 0) is_dead = true;
}
void Marine::show_status() {
  std::cout << " *** Marine *** " << std::endl;
  std::cout << " Location : ( " << coord_x << " , " << coord_y << " ) "
            << std::endl;
  std::cout << " HP : " << hp << std::endl;
}

int main() {
  Marine marine1(2, 3, 10);
  Marine marine2(3, 5, 10);

  marine1.show_status();
  marine2.show_status();

  std::cout << std::endl << "마린 1 이 마린 2 를 공격! " << std::endl;
  marine2.be_attacked(marine1.attack());

  marine1.show_status();
  marine2.show_status();
}

출력 결과

 *** Marine *** 
 Location : ( 2 , 3 ) 
 HP : 50
 *** Marine *** 
 Location : ( 3 , 5 ) 
 HP : 50

마린 1 이 마린 2 를 공격! 
 *** Marine *** 
 Location : ( 2 , 3 ) 
 HP : 50
 *** Marine *** 
 Location : ( 3 , 5 ) 
 HP : 40

```
  * 이 예제는 생성자를 하나를 더 추가했습니다.

```C++

Marine::Marine(int x, int y, int default_damage)
    : coord_x(x),
      coord_y(y),
      hp(50),
      default_damage(default_damage),
      is_dead(false) {}

```
  * 이전에는 default_damage 에 초기화 리스트로 5 를 전달하였는데, 이 생성자의 경우 어떤 값을 전달할 지 인자로 받은 다음에 그 내용을 상수에 넣어주었습니다.
  * 이 경우는 const int default_damage = (인자로 받은 default_damage); 를 실행한 것과 마찬가지 이기 때문에 잘 작동됨을 알 수 있습니다.


