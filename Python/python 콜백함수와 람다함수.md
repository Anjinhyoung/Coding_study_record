# 콜백함수
  * 직접 호출하는 것이 아닌 다른 함수에 의해 호출되는 함수
  * 예시
  * ```python
    def callback_func(func):
    for i in range(5):
        func()

    def print_hello():
      print("안녕하세요 파이썬!")

    callback_func(print_hello)
    ```
  * 출력 결과
  * ```python
    안녕하세요 파이썬!
    안녕하세요 파이썬!
    안녕하세요 파이썬!
    안녕하세요 파이썬!
    안녕하세요 파이썬!
    ```
  * print_hello() 함수는 단순히 "안녕하세요 파이썬!"을 출력하는 문장이다.
  * callback_func(func) 함수는 'func'라는 매개변수를 for문에 의해서 5번이 반복이 된다.
  * callback_func()함수의 매개변수를 print_hello 함수로 설정하면 "안녕하세요 파이썬!"이 5번이 반복이 된다.
  * 주의사항: 매개변수를 함수로 설정할 때 '()'부분은 빼줘야 한다.
  ## 추가 예시
  * ```python
    def callback_func(func,num):
    for i in range(num):
        func(i)

    def print_hello(num):
        print("안녕하세요! 파이썬",num)

    def print_hi(num):
        print("하이!파이썬!",num)

    callback_func(print_hello,3)
    callback_func(print_hi,5)
    ```
  * 출력 결과
  * ```
    안녕하세요! 파이썬 0
    안녕하세요! 파이썬 1
    안녕하세요! 파이썬 2

    하이!파이썬! 0
    하이!파이썬! 1
    하이!파이썬! 2
    하이!파이썬! 3
    하이!파이썬! 4
    ```
# 람다함수  
  * 단일문으로 표현되는 익명함수
  * 코드상에서 한번만 사용되는 기능이 있을 때, 굳이 함수를 만들지 않고 일회성으로 만들어 사용하는 함수
  ## 예시
  * ```python
    plus_ten = lambda x: x + 10
    print(plus_ten(1))
    ```
  * 출력 결과
  * ```
    11
    ```
  * lambda x: x + 10은 매개변수 x 하나를 받고, x에 10을 더해서 반환한다는 뜻
  * 
  ## 람다 표현식 자체를 호출하기
  * ```python
    plus_ten = (lambda x: x + 10)(1)
    print(plus_ten)
    ```
  * 출력 결과
  * ```
    11
    ```
  # 주의사항
  * 람다 표현식 안에서는 변수를 만들 수 없다
  # 람다 함수에 여러 개의 객체 넣기
  * 예시
  * ```python
    li = [1, 2, 3, 4, 7, 9, 10, 14, 15, 19, 20]
    per = list(map(lambda n: n * 0.01, li))

    print(per)
    ```
  * 출력 결과
  * ```
    [0.01, 0.02, 0.03, 0.04, 0.07, 0.09, 0.1, 0.14, 0.15, 0.19, 0.2]
    ```
  * map은 리스트 등의 반복 가능한 객체를 여러 개 넣을 수도 있다.
