# partial
  * 기능 별로 분리해서 구현이 가능
  * 다수 개발자가 개발하는 경우 단위 기능별로 구현하여 한 파일에서 작업할 때 발생할 수 있는 충돌을 막을 수 있다.
  * 분리해서 개발하는 것이지만 동일한 이름의 필드나 함수 등은 불가
  * 기존에 코드에 추가 기능을 작업할 때 기존 클래스의 내부는 변경하지 않고 기능 확장 가능 

```C#
namespace partial
{
  public partial class AA
  {
    private int num;
    public int Number {get; set;}
  }

  public partial clas AA
  {
    // private int num; 은 사용할 수 없다 왜 위에 private int num이 이미 선언되었으니까
    // 명심해라 partial이 있으면 같은 클래스이다.
    public string Name {get; set;}  = "NoName";
  }
}
```
  * 그러면 class만 가능하냐? 인터페이스는? 구조체는?

```C#
partial interface IAA {}
partial interface IAA {}

partial struct sAA{}
partial struct sAA{}
```
  * 물론 가능하다.

# sealed(봉인)
  * 상속으로 계층구조가 복잡하면 나중에 새로운 상속 코드를 구현하려면 어디까지 재정의를 해야 하는지 파악하기 어렵다.
  * 불필요한 재정의를 제어하므로 구조가 명확해 진다.
  * 위에 이유로 구조를 설계할 때는 sealed를 적절하게 사용해야 한다.

```C#
namespace sealed
{
  class SealBase {}

  sealed class SealAA : SealBase{}

  // class BB : SealAA{} // 에러가 난다 왜? SealAA의 class는 봉인 되어있으니까 하지만
  class BB : SealBase{} // 이거는 가능하다.

}
```
  * 또한 추상클래스, 추상 메서드 또는 속성의 구현을 제공하는 클래스에서 상속해야 하므로 봉인 클래스와 함께 abstract 한정자를 사용하면 오류가 발생
