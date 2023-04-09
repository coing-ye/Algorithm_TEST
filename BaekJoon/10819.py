import sys
from itertools import permutations

N = int(sys.stdin.readline())
numlist = list(map(int,sys.stdin.readline().split()))

def givenfunc(nl):
    sol = 0
    for i in range(len(nl)-1):
        sol += abs(nl[i]-nl[i+1])
    return sol

perlist  = permutations(numlist,N)

tmp = 0
for i in perlist:
    tmp = max(tmp,givenfunc(i))
print(tmp)
