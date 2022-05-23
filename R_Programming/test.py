#1. 파이썬 pip를 활용하여 numpy와 pandas 라이브러리를 설치한다.
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

#2. 파이썬을 활용하여 fish.csv 파일을 로드한다.
bream_length = pd.read_csv("bream_length.csv", header=None)
bream_weight = pd.read_csv("bream_weight.csv", header=None)

smelt_length = pd.read_csv("smelt_length.csv", header=None)
smelt_weight = pd.read_csv("smelt_weight.csv", header=None)

#3. 로드한 도미와 빙어 데이터를 x축은 length, y축은 weight로 하여 matplot으로 시각화한다.
# plt.scatter(bream_length, bream_weight)
# plt.scatter(smelt_length, smelt_weight)
# plt.xlabel("length")
# plt.ylabel("weight")
# plt.show()

#4. 도미와 빙어 데이터를 1차원 배열 length, weight로 합친 뒤 2차원 배열로 만들고 shape을 확인할 수 있다.
fish_length = np.concatenate([bream_length, smelt_length])
fish_weight = np.concatenate([bream_weight, smelt_weight])

fish_data = np.column_stack((fish_length, fish_weight))

#5. 도미와 빙어를 구분할 수 있게 도미를 찾는 타겟 데이터를 만든다.
target_fish = [1]*35 + [0]*14

input_arr = np.array(fish_data)
target_arr = np.array(target_fish)

#6. shuffle을 이용하여 데이터를 섞는다.
np.random.seed(42)
index = np.arange(49)
np.random.shuffle(index)

#7. 테스트 데이터와 훈련 데이터로 구분한다.
train_input = input_arr[index[:35]]
train_target = target_arr[index[:35]]

test_input = input_arr[index[35:]]
test_target = target_arr[index[35:]]

#8. 훈련 데이터를 x축은 length, y축은 weight로 하여 matplot으로 시각화한다.
plt.scatter(train_input[:, 0], train_input[:, 1])
plt.scatter(test_input[:, 0], test_input[:, 1])
plt.xlabel("length")
plt.ylabel("weight")
plt.show()