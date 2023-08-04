import sys
from collections import deque
from copy import deepcopy
sys.setrecursionlimit(10**9)

def isf (now, cnt, state):
    global anw 
    visited[now] = 1
    #print(state, visited, gmap[now])
    if cnt== 4:
        #print(state)
        anw = 1
        return
    else:
        for i in range(len(gmap[now])):
            next = gmap[now][i]
            if visited[next] == 1:
                continue
            else:
                isf(next,cnt+1,state+str(next))
                visited[next] = 0
            if anw == 1:
                break
        visited[now]= 0

    return


N,M = map(int,sys.stdin.readline().split(" "))
gmap = [ deque() for i in range(N) ]
global visitied




for i in range(M):
    f,b = map(int,sys.stdin.readline().split(" "))

    gmap[f].appendleft(b)

    gmap[b].appendleft(f)




anw = 0
visited = [0]*N
for i in range(N):
    isf(i,0,str(i))
    
    if anw == 1:
        break
    

print(anw)