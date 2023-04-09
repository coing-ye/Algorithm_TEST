from itertools import permutations
import sys

N = int(sys.stdin.readline())
numlist = []
for i in range(1,N+1):
    numlist.append(i)

def printsol(sollist):
    solsen = ''
    for i in range(len(sollist)):
        solsen += str(sollist[i])
        if i < len(sollist)-1:
            solsen += ' '
    return solsen

for i in permutations(numlist,N):
    print(printsol(i))
