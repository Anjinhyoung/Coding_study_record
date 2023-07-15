# 클래스
 * 프로그래밍 방법을 객체지향 프로그래밍이라고 함 - oop
 * 1. 설계도를 만들어 그 설계도에 의한 제품을 만든다.
   2. 제품은 완제품, 부품일 수 있다. ㅡ> 하나의 제품을 하나의 부품으로 완성 또는 하나의 제품을 두 개 이상의 부품으로 완성
   3. 설계도: 클래스, 완제품(부품):객체, 인스턴스
      * 객채랑 인스턴스는 동일한 의미이다.
 * oop는 조립방식이다.
 * 클래스 만들기 ㅡ> 기능(함수) + 상태(형태, 디자인)(변수)
 * 클래스는 최대 2 가지의 구성 요소를 갖는다:함수, 변수

# 매서드, 속성
* ```python
  class Car:
      def __init__(self, brand, color):
          self.brand = brand  # 자동차 브랜드 속성
          self.color = color  # 자동차 색상 속성
  
      def start_engine(self):
          print(f"{self.color}의{self.brand}가 자동차의 엔진이 시작되고 있습니다.")
          # 자동차의 엔진을 시작하는 메시지를 출력하는 매서드

      def drive(self, distance):
          print(f"{self.color}의{self.brand}가 {distance} 킬로미터 주행하는 중입니다.")
          # # 주행 거리를 출력하는 메시지를 출력하는 매서드

      def stop_engine(self):
          print(f"{self.color}의{self.brand}가 엔진이 중단되었습니다.")
          # 자동차의 엔진을 중지하는 메시지 출력를 출력하는 매서드

  my_car = Car("Tesla", "파란색")  # "Tesla" 브랜드, "파란색" 색상의 자동차 객체 생성
  my_car.start_engine()  # 자동차의 엔진 시작 메서드 호출
  my_car.drive(50)  # 자동차 주행 메서드 호출, 50킬로미터 주행
  my_car.stop_engine()  # 자동차의 엔진 중지 메서드 호출
  ```
