import sys
import math

global N
N = int(sys.stdin.readline())

global firstset
global secondset


firstset  = [2,3,5,7]
secondset = [1,3,7,9]

def checksosu(num):
    anw = 0
    for i in range (1,int(math.sqrt(num))+1):
        if num%i ==0:
            anw+=1
        if anw >1:
            break
    if anw == 1:
        return 1
    else:
        return 0


def sosu(cnt, num):
    if cnt == N-1:
        print(num)
        return
    for i in secondset:
        if checksosu(num*10+i):
            sosu(cnt+1,num*10+i)
    return

for i in firstset:
    sosu(0,i)