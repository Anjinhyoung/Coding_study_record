# folium
  * leaflet.js 기반으로 만들어진 라이브러리
  * 지도 위에 데이터를 표현해주는 대표적인 파이썬 지도 시각화 라이브러리

  ### folium 설치
  ```python
  !pip install folium
  ```

  ### folium 사용하기
  ```python
  import folium
  # folium.Map(location=[위도, 경도],zoom_start=배열, ...)
  map_folium = folium.Map(location=[37.50007,127.03559],zoom_start=17)
  map_folium
  ```

  * 출력 결과(클릭해서 확대해서 보시길 바란다... 너무 작다)
![folium-1](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/637ee2d0-28c9-4938-a077-e9814a8cd293)

  ### folium 활용하기
  ```python
  # Marker(): location 속성으로 지정한 위치에 마커를 생성
  # popup(): 마커를 클릭했을 때 표시할 문자열 설정
  # add_to(): 작성된 마커를 지도에 추가

  popup = folium.Popup('코리아IT아카데미', max_width=200)
  map_folium = folium.Map(location=[37.50007, 127.03559], zoom_start=17)
  folium.Marker(location=[37.50007, 127.03559], popup=popup).add_to(map_folium)
  map_folium
  ```

  * 출력 결과
    ![folium-2](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/8a629a8b-6824-4104-91ce-66af959bebde)



  ### folium 활용하기2
  ```python
  map_folium = folium.Map(location=[37.56652479270633, 126.9779129116262],zoom_start=15)

  popup = folium.Popup('서울특별시청', max_width=200)
  folium.Marker(location=[37.56652479270633, 126.9779129116262], popup=popup).add_to(map_folium)

  popup = folium.Popup('덕수궁', max_width=200)
  folium.Marker(location=[37.56585320879458, 126.97514572197248], popup=popup).add_to(map_folium)

  popup = folium.Popup('서울지방경찰청', max_width=200)
  folium.Marker(location=[37.57504045678939, 126.97195576938117], popup=popup).add_to(map_folium)

  popup = folium.Popup('광화문', max_width=200)
  folium.Marker(location=[37.57617987638928, 126.97694467807803], popup=popup).add_to(map_folium)

  popup = folium.Popup('영풍문고-종로본점', max_width=200)
  folium.Marker(location=[37.56999947440024, 126.98228391170936], popup=popup).add_to(map_folium)

  map_folium
  ```

  * 출력 결과

    ![folium-3](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/c4d5fbd6-7288-42b4-836d-899176da91ab)


 ### folium 활용하기3
  ```python
  map_folium = folium.Map(location=[37.56652479270633, 126.9779129116262], zoom_start=15)

  popup = folium.Popup('서울특별시청', max_width=200)
  folium.Marker(location=[37.56652479270633, 126.9779129116262], popup=popup,icon=folium.Icon(color='red',icon='star')).add_to(map_folium)

  popup = folium.Popup('덕수궁', max_width=200)
  folium.Marker(location=[37.56585320879458, 126.97514572197248], popup=popup,icon=folium.Icon(color='pink',icon='ok')).add_to(map_folium)

  popup = folium.Popup('서울지방경찰청', max_width=200)
  folium.Marker(location=[37.57504045678939, 126.97195576938117], popup=popup,icon=folium.Icon(color='orange',icon='user')).add_to(map_folium)

  popup = folium.Popup('광화문', max_width=200)
  folium.Marker(location=[37.57617987638928, 126.97694467807803], popup=popup,icon=folium.Icon(color='blue',icon='star')).add_to(map_folium)

  popup = folium.Popup('영풍문고-종로본점', max_width=200)
  folium.Marker(location=[37.56999947440024, 126.98228391170936], popup=popup,icon=folium.Icon(color='green',icon='star')).add_to(map_folium)

  map_folium
  ```
 * 출력 결과
 ![folium-4](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/b4010d69-b67e-4a78-b566-e8bf64024786)


 ### folium 활용하기4
 ```python
 # CircleMarker(): 원의 범위를 마커로 생성

 map_folium = folium.Map(location=[37.56652479270633, 126.9779129116262], zoom_start=15)

 popup = folium.Popup('서울특별시청', max_width=200)
 folium.CircleMarker(location=[37.56652479270633, 126.9779129116262], popup=popup,
               radius=100, color='red', fill_color='#EC407A').add_to(map_folium)

 map_folium
```
* 출력 결과


  ![folium-5](https://github.com/Anjinhyoung/TIL-Today-I-Learned/assets/117788976/a30cc3aa-b133-40b8-9caf-377dad0d9db5)





