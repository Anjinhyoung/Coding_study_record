# checked
  * 연산이나 변화에 의한 overflow, underflow 체크

# unchecked
  * 연산이나 변환에 의한 overflow, underflow를 체크 해제

```C#
byte bNum = byte.MaxValue;
checked
{
  bNum += 1;
}
Console.WriteLine($"bNum: {bNum}");

출력 결과
처리되지 않은 예외: System.OverflowException: 산술 연산으로 인해 오버플로가 발생했습니다.
```

```C#
byte byte bNum = byte.MaxValue;
unchecked
{
  bNum +=1;
}
Console.WriteLine($"bNum: {bNum}");

출력 결과
0
```

# 또 다른 사용 예시

```C#
int ChekedNumber(int num)
{
  return checked(num++);
}

```
  * checked() 괄호를 이용해서 처리 가능
