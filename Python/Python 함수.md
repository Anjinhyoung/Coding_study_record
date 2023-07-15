# 함수(function)란?
  * 특정 용도의 코드를 한 곳에 모아 놓은 것을 뜻함
  * 함수는 처음 한 번만 작성해 놓으면 나중에 필요할 때 계속 불러 쓸 수 있음
  * 함수를 사용하면 코드의 용도를 구분할 수 있다.
  * ```python
    def 함수이름(매개변수1, 매개변수2, ...):
        Code
    ```
  * '함수이름':사용자가 정의한 함수 이름입니다. ex)printName, addNumber ,... 등등 자신이 원하는 이름으로 지을 수 있다.
  *  '매개변수':함수에 전달되는 값들을 '매개변수'라고 지칭합니다. (함수를 만들 때 꼭 매개변수가 있을 필요는 없습니다.)
  *  ':' 함수이름, 매개변수를 설정했으면 꼭 맨 뒤에 ':'을 붙여줘야 해야한다.
  *  'Code':함수의 동작을 구현하는 코드 (반드시 들여쓰기를 해야 함)


# Hello World 출력 함수 만들기
  * ```python
    def Hello():
        print('Hello world!')
    ```
  * 함수 이름은 'Hello'으로 설정하고, Code는 'Hello World'가 출력하게 만듦.

# Hello()함수 호출하기
  * 함수 아래에다가
    ```
    Hello()
    ```
    함수를 작성하고 실행을 하면
    ```
    Hello World!
    ```
  * Hello World!가 출력된다.
  * 함수를 사용하는 방법을 "함수를 호출한다"라고 말하기도 한다.
  * ### 최종 모습
  ```python
  def Hello():
      print('Hello world!')

  Hello() # Hello함수 출력 
  ```
  * 출력 결과
  ```
  Hello world!
  ```
# 주의사항
 * ```python
   hello() # 함수를 먼저 호출
   
   def hello():  # hello 함수를 만듦
       print('Hello World!')
   ```
 * 함수를 먼저 호출하면 에러가 발생함
 *  파이썬 코드는 위에서 아래로 순차적으로 실행되기 때문에 함수를 먼저 실행하면 안됨
 *  함수를 먼저 만든 뒤에 함수를 호출해야 함

# 매개변수를 이용해서 덧셈 함수 만들기
* ```python
  def add(a,b):
      print(a+b)
  
  add(10,20)
* 출력 결과
* ```
  30
  ```
* add(10,20)에서 10과 20은 함수를 호출할 때 넣는 값 이를 '인수'라고 부름

# 함수의 결과를 반환하기
* ```python
  def add(a,b)
      return a+b # return을 사용하면 값을 함수 바깥으로 반환함(return에 값을 지정하지 않으면 None을 반환함)

  print(add(1,2))
  ```
* 출력결과
* ```
  3
  ```
* return으로 반환하는 값은 반환값이라고 하며 함수를 호출해준 바깥에 결과를 알려주기 위해 사용함

### 또다른 예시

* ```python
  def add(a,b)
      return a+b

  x = add(1,2)
  print(x)
  ```
* 출력결과
* ```
  3
  ```
* return을 사용하면 함수에서 나온 값을 변수에 저장할 수 있음 에시에서는 'x' 변수에 저장함
# 함수에서 여러 개의 값을 반환하기
* 함수에서 값을 여러 개 반환할 때는 ','로 구분해서 지정하면 됨
* ```python
  def add_sub(a,b):
    return a+b, a-b

  x,y = add_sub(10,5)
  print(x)
  print(y)
  print(x,y)
  ```
* 출력결과
* ```
  15
  5
  15 5
  ```
### 또 다른 예시
* ```python
  def add_sub(a,b):
    return a+b, a-b

  x = add_sub(10,5)
  print(x)
* 출력결과
*  ```
   (15,5)
   ```
* add_sub의 결과를 변수 한 개에 저장해서 출력해보면 튜플이 반환이 됨
* 튜플로 반환하는 것은 튜플이 변수 여러 개에 할당되는 특성을 이용하는 것임
# 키워드 인수 사용하기
  * 파이썬에서는 인수의 순서와 용도를 매번 기억하지 않도록 키워드-인수를 제공함
  ```python
  def greet(name, age):
      print(f"안녕하세요, {name}님! {age}세이시네요.")

  greet(name="Alice", age=25)
  greet(age=30, name="Bob")
  ```
  * 출력 결과
  ```
  안녕하세요, Alice님! 25세이시네요.
  안녕하세요, Bob님! 30세이시네요.
  ```
  * 키워드-인수를 사용하면 함수를 호출할 때 인수의 용도가 명확히 보임
  * 키워드-인수를 사용하면 인수의 순서를 맞추지 않아도 키워드에 해당하는 값이 출력하게 됨

# 매개변수에 초기값 지정하기
  * 매개변수의 초깃값은 주로 사용하는 값이 있으면서 가끔 다른 값을 사용해야 할 때 활용
  ```python
  def personal_info(name,age,address='비공개'):
  return name,age,address

  name,age,address = personal_info('홍길동',30)
  print(name)
  print(age)
  print(address)
  ```
  * 출력 결과
  ```
  홍길동
  30
  비공개
  ```
  * ddress는 초깃값이 있으므로 personal_info는 다음과 같이 address 부분을 비워 두고 호출할 수 있음
  ### 또 다른 예시
  ```python
  def personal_info(name,age,address='비공개'):
    return name,age,address

  name,age,address = personal_info('홍길동',30,'송파구')
  print(name)
  print(age)
  print(address)
  ```
  * 출력 결과
  ```
  홍길동
  30
  송파구
  ```
  * 매개변수에 초깃값이 지정되어 있더라도 값을 넣으면 해당 값이 전달

# 초기값이 지정된 매개변수의 위치
  * 초깃값이 지정된 매개변수 다음에는 초깃값이 없는 매개변수가 올 수 없음
  ```python
  def personal_info(name,address='비공개',age):
      return name,age,address

  name,age,address = personal_info('홍길동',30,'송파구')
  print(name)
  print(age)
  print(address)
  ```
  * 출력 결과
  ```
  File "C:\Reset\github.py", line 1
  def personal_info(name,address='비공개',age):
                                             ^^^
  SyntaxError: non-default argument follows default argument
  ```
  * 문법 에러가 발생
  * 왜냐하면 함수를 이렇게 만들어버리면 personal_info('홍길동', 30)으로 함수를 호출했을 때 30이 어디로 들어가야 할지 알 수가 없기 때문
  * 즉, 초깃값이 지정된 매개변수는 뒤쪽에 몰아주면 됨

# 재귀호출 사용하기
  * 함수 안에서 함수 자기자신을 호출하는 방식을 재귀호출(recursive call)이라고 한다.
    ### 재귀호출 사용하기
    ```python
    def hello():
    print('Hello, world!')
    hello()

    hello() # hello() 함수를 호출
    ```
  * 출력 결과
    ```
    Hello, world!
    Hello, world!
    Hello, world!
    ...(생략)
    ```
    * hello 함수 안에서 다시 hello 함수를 호출
    * 왜냐하면 hello() 함수 안에 자기 자신인 'hello()'를 계속 호출 하고 있으니깐 무한 반복이 되는 거다.

    ### 재귀호출에 종료 조건 만들기
    ```python
    def hello(count):
    if count == 0:
        return
    print("Hello, World",count)

    count -=1
    hello(count)

    hello(5)
    ```
    * hello 함수의 반복 횟수를 계산하기 위해 매개변수 count를 지정
    * count가 0이면 hello 함수를 호출하지 않고 끝이 난다.
    * 만약 0이 아니면 'Hello, world!'를 출력하고, count의 값을 1씩 감소시킨 뒤 hello 함수를 호출할 때 감소된 count의 값을 넣어줍니다.
