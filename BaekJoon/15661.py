import sys
from itertools import combinations
import math
import copy

N = int(sys.stdin.readline())
sset = []
tset = []

global answer
answer = 100*N

def counterset(oset,inset):
    tmpset = copy.deepcopy(oset)
    for i in inset:
        tmpset.remove(i)
    return tmpset


for i in range(N):
    sset.append(list(map(int,sys.stdin.readline().split())))
    tset.append(i)


for i in range(1,N//2):
    comset = list(combinations(tset,i+1))
    for j in range(len(comset)):
        comcounter = counterset(tset,comset[j])

        tem1 = list(combinations(comset[j],2))
        tem2 = list(combinations(comcounter,2))
        scor1 = 0
        scor2 = 0
        for k in range(len(tem1)):
            scor1 = scor1 + sset[tem1[k][0]][tem1[k][1]] + sset[tem1[k][1]][tem1[k][0]]
        for k in range(len(tem2)):
            scor2 = scor2 + sset[tem2[k][0]][tem2[k][1]] + sset[tem2[k][1]][tem2[k][0]]
        answer = min(answer,abs(scor1-scor2))

print(answer)




#print(sset)


"""
comset = list(combinations(tset,N//2))


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
"""
