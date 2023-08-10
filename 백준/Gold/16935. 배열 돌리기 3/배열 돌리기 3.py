import sys
from copy import deepcopy
from collections import deque
global N,M
N,M,R = map(int,sys.stdin.readline().strip().split(" "))

global mmap
mmap = list()

global mi5,mj5,mi6,mj6
mi5 = [0,1,0,-1] # 우하좌상
mj5 = [1,0,-1,0]
mi6 = [1,0,-1,0] # 하우상좌
mj6 = [0,1,0,-1]


for _ in range(N):
    tmp = list(map(int,sys.stdin.readline().strip().split(" ")))
    mmap.append(tmp)

command = list(map(int,sys.stdin.readline().strip().split(" ")))


def cmd1():
    global mmap,N,M
    for i in range(N//2):
        for j in range(M):
            tmp = mmap[i][j]
            mmap[i][j] = mmap[N-1-i][j]
            mmap[N-1-i][j] = tmp

def cmd2():
    global mmap,N,M
    for i in range(N):
        for j in range(M//2):
            tmp = mmap[i][j]
            mmap[i][j] = mmap[i][M-1-j]
            mmap[i][M-1-j] = tmp

def cmd3():
    global mmap,N,M
    tmap = deque()
    for i in range(M):
        tmp = []
        for j in range(N-1,-1,-1):
            tmp.append(mmap[j][i])
        tmap.append(tmp)
    mmap = list(tmap)
    N,M = M,N

def cmd4():
    global mmap,N,M
    tmap = deque()
    for i in range(M-1,-1,-1):
        tmp = []
        for j in range(N):
            tmp.append(mmap[j][i])
        tmap.append(tmp)
    mmap = list(tmap)
    N,M = M,N

def cmd5():
    global mmap,N,M
    for i in range(N//2):
        for j in range(M//2):
            q = deque()
            q.append(mmap[i][j])
            ni = i
            nj = j
            for k in range(4):
                ni = ni+(N//2)*mi5[k]
                nj = nj+(M//2)*mj5[k]
                q.append(mmap[ni][nj])
                mmap[ni][nj] = q.popleft()

def cmd6():
    global mmap,N,M
    for i in range(N//2):
        for j in range(M//2):
            q = deque()
            q.append(mmap[i][j])
            ni = i
            nj = j
            for k in range(4):
                ni = ni+(N//2)*mi6[k]
                nj = nj+(M//2)*mj6[k]
                q.append(mmap[ni][nj])
                mmap[ni][nj] = q.popleft()

for i in command:
    if i == 1:
        cmd1()
    elif i == 2:
        cmd2()
    elif i == 3:
        cmd3()
    elif i == 4:
        cmd4()
    elif i == 5:
        cmd5()
    elif i == 6:
        cmd6()

for i in range(N):
    print(" ".join(map(str,mmap[i])))