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
  * ddress는 초깃값이 있으므로 personal_info는 다음과 같이 address 부분을 비워 두고 호출할 수 있습니다.
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
  * 매개변수에 초깃값이 지정되어 있더라도 값을 넣으면 해당 값이 전달됩니다.

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
