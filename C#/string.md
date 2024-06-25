# string.Format
  * 문자열을 특정 형식으로 포맷하는데 사용
  * 다음 기본적인 예시를 보자

```C#
정수형 데이터 string.Format

int number = 123;
string result = string.Format("Number: {0}", number);

출력값
"Number: 123"
```

```C#
실수형 데이터 string.Format

double pi = 3.14159;
string result = string.Format("Pi: {0:F2}", pi);

출력값
 "Pi: 3.14"
```

```C#
문자형 데이터 string.Format

char letter = 'A';
string result = string.Format("Letter: {0}", letter);

출력값
"Letter: A"
```

# LastIndexOf
  * C#에서 문자열이나 배열 내에서 특정 문자의 마지막 위치를 찾는 데 사용되는 메서드이다.
  * 다음 예제를 보자

```C#
string example = "Hello, world!";
int index = example.LastIndexOf('o');

index는 8 (문자 'o' 가 마지막으로 나타나는 위치)
```

# substring
  * C#에서 문자열의 일부를 추출하는데 사용되는 메서드

```C#
시작 인덱스만 지정하는 경우 

string example = "Hello, world!";
string result = example.Substring(7);

result = "world!" (인덱스 7부터 끝까지의 문자열을 반환)
```
```C#
시작 인덱스와 길이를 모두 지정하는 경우

string example = "Hello, world!";
string result = example.Substring(7, 5);

result는 "world" (인덱스 7부터 5글자의 문자열을 반환)
```



# Trim
 * C#에서 문자열의 앞뒤에 있는 공백 문자를 제거하는데 사용되는 메서드


```C#
기본 Trim

string example = " Hello, world! ";
string result = example.Trim();

result "Hello, world!" (앞뒤 공백이 제거됨)
```

```C#
TrimStart

string example =  " Hello, world! ";
string result = example.TrimStart();

result는 "Hello, world! " (앞쪽 공백만 제거됨)
```

```C#
특정 문자 집합을 지정하여 제거

string example = "---Hello, world!---";
char[] charsToTrim = {'-'};
string result = example.Trim(charsToTrim);



