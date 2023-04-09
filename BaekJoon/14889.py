import sys
from itertools import combinations
import math

N = int(sys.stdin.readline())
sset = []
tset = []

global answer
answer = 100*N//2

for i in range(N):
    sset.append(list(map(int,sys.stdin.readline().split())))
    tset.append(i)

comset = list(combinations(tset,N//2))

#모든 순열 조합을 돌 이유가 없다.
#itertools.combinations()는 i 번째와 -1-i 번째가 대칭이므로 절반만 돌면 됨
#사실 재귀로 구하는게 정답이긴 하다. 근데 재귀 너무 많이 풀었다. 귀찮음.

for i in range(len(comset)//2):
    tem1 = list(combinations(comset[i],2))
    tem2 = list(combinations(comset[-1-i],2))

    scor1 = 0
    scor2 = 0
    for i in range(len(tem1)):
        scor1 = scor1 + sset[tem1[i][0]][tem1[i][1]] + sset[tem1[i][1]][tem1[i][0]]
        scor2 = scor2 + sset[tem2[i][0]][tem2[i][1]] + sset[tem2[i][1]][tem2[i][0]]

    answer = min(answer,abs(scor1-scor2))

print(answer)
