import sys

N = int(sys.stdin.readline())
daylist = []
heightlist=[]

for i in range(N):
    stat  = list(map(int,sys.stdin.readline().split()))
    daylist.append(stat[0])
    heightlist.append(stat[1])


heightlist = sorted(heightlist,reverse=True)
sumvalue = 0

for i in range(N):
    if i==0:
        sumvalue = heightlist[i]
    else:

        #tmp = max(sum(daylist[:i]),heightlist[i])
        #sumvalue = sumvalue + tmp
        sumvalue = sumvalue + sum(daylist[:i])+heightlist[i]
    print(sumvalue)
