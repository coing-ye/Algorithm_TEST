import sys
from collections import deque
from itertools import permutations
from copy import deepcopy

global N,M
N,M,K = map(int,sys.stdin.readline().strip().split(" "))
global arr
arr = []
command = []

def rotate(cmd):
    global arr
    r = cmd[0]
    c = cmd[1]
    s = cmd[2]
    size = s*2+1
    si = r-s-1
    sj = c-s-1
    ei = si+size-1
    ej = sj+size-1

    while(size>1):
        deq = deque()
        deq.append(arr[si][sj])
        for j in range(sj+1,ej):
            deq.append(arr[si][j])
            arr[si][j] = deq.popleft()
        for i in range(si,ei):
            deq.append(arr[i][ej])
            arr[i][ej] = deq.popleft()

        for j in range(ej,sj,-1):
            deq.append(arr[ei][j])
            arr[ei][j] = deq.popleft()

        for i in range(ei,si-1,-1):
            deq.append(arr[i][sj])
            arr[i][sj] = deq.popleft()


        # for j in arr:
        #     print(j)
        # print("#####################")
        si = si+1
        ei = ei-1
        sj = sj+1
        ej = ej-1
        size = size-2


for i in range(N):
    tmp = list(map(int,sys.stdin.readline().strip().split(" ")))
    arr.append(tmp)
for i in range(K):
    tmp = list(map(int,sys.stdin.readline().strip().split(" ")))
    command.append(tmp)

pp = []
for i in range(K):
    pp.append(i)

pm = list(permutations(pp,K))


ans  = 10e9
storemap = deepcopy(arr)
for soonsu in pm:
    arr = deepcopy(storemap)
    for i in soonsu:
        rotate(command[i])
    tmp = 10e9
    for r in arr:
        tmp = min(tmp,sum(r))
    ans = min(ans,tmp)
print(ans)