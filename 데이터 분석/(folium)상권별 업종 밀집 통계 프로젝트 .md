# folium 활용
```python
import folium
# 만약에 shop_seoul_edu_computer 기억이 나지 않으면 "(데이터 전처리)상권별 업종 밀집 통계 프로젝트 .ipynb" 보고 오자
shop_seoul_edu_computer.index
```

* 출력 결과
```
Int64Index([   442,   2687,   3678,   3872,   5517,   5806,   5943,   6191,
              9063,  10578,
            ...
            497805, 497806, 498048, 498478, 499049, 499152, 499153, 499154,
            499155, 499156],
           dtype='int64', length=215)
```

```python
data  =  shop_seoul_edu_computer
edu_map = folium.Map(location = [data['위도'].mean(), data['경도'].mean()] , zoom_start=12)

for i in data.index:
    # 코리아IT아카데미 - 서울시 강남구 역삼동...
    edu_name = data.loc[i,'상호명'] + '-' + data.loc[i, '도로명주소']
    popup = folium.Popup(edu_name, max_width=500)
    folium.Marker(location = [data.loc[i,'위도'],data.loc[i,'경도']], popup = popup).add_to(edu_map)
edu_map

# 이 코드를 통해 서울에 있는 컴퓨터 학원을 지도로 통해 볼 수 있다.
```

* 출력 결과
![컴퓨터 학원](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/b7810c9f-1266-4ec6-a502-06fae2c23a04)

###   문제
*  상권업종중분류명이 '커피점/카페'인 데이터 중 '구군'이 '강남구'인 데이터만 지도에 표기
```python
shop_seoul_coffee = shop_seoul[shop_seoul['상권업종중분류명'] == '커피점/카페']
shop_seoul_coffee
```
* 출력 결과

![카페 출력 결과](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/9e922ccb-2296-4904-8d67-b6dc71c43799)

```python
data = shop_seoul_coffee[shop_seoul_coffee['시군구명'] == '강남구']
data
# 되게 많다... 2000개나 있네.....
```
* 출력 결과 
![커피 강남점 출력 결과](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/f3c0ba68-344c-4080-b6d3-a604f622a824)


```python
data = shop_seoul_coffee[shop_seoul_coffee['시군구명'] == '강남구']
coffee_map = folium.Map(location=[data['위도'].mean(), data['경도'].mean()],zoom_start=14)

for i in data.index:
    coffee_name = data.loc[i,'상호명'] + '-'+  data.loc[i,'도로명주소']
    popup = folium.Popup(coffee_name, max_width=500)
    folium.Marker(location=[data.loc[i,'위도'], data.loc[i, '경도']], popup=popup).add_to(coffee_map)

coffee_map
# 강남구에 있는 커피점들 지도로 표시
```


* 출력 결과(스크린샷으로 찍어서 올릴려고 했는데 데이터가 너무 많아서 렉이 심하게 걸린다...)
* 자칫 보면 서울에 있는 커피점을 표시한 거일 수도 있겠지만 '강남구'에만 있는 커피점만 표기한거다...

![강남 커피점 ](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/0b82cec3-ce07-45c6-b296-0a7df1e3764d)






