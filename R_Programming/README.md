제작가이드 :
1. 파이썬 pip를 활용하여 numpy와 pandas 라이브러리를 설치한다.
2. 파이썬을 활용하여 fish.csv 파일을 로드한다.
3. 로드한 도미와 빙어 데이터를 x축은 length, y축은 weight로 하여 matplot으로 시각화한다.
4. 도미와 빙어 데이터를 1차원 배열 length, weight로 합친 뒤 2차원 배열로 만들고 shape을 확인할 수 있다.
[ [길이, 무게], [길이, 무게], ... ]
5. 도미와 빙어를 구분할 수 있게 도미를 찾는 타겟 데이터를 만든다.
도미 – 1, 빙어 – 0 으로 구분!!
6. shuffle을 이용하여 데이터를 섞는다.
7. 테스트 데이터와 훈련 데이터로 구분한다. 
train_input, train_target, test_input, test_target
8. 훈련 데이터를 x축은 length, y축은 weight로 하여 matplot으로 시각화한다.