import sys


def recur(a,b,exp,sol,sset):
    if b==0:
        temp = sorted(exp)
        if temp not in sset:
            sset.append(temp)
            sol.append(exp)
        return
    for i in range(len(a)):
        exp=exp+str(a[i])
        #비교 어레이의 갯수를 줄이면 시간복잡도도 줄어든다
        tempset = a[i:]
        recur(tempset,b-1,exp,sol,sset)
        exp = exp[:-1]
    return sol

a, b = map(int,sys.stdin.readline().split())
numset = []
for i in range(1,a+1):
    numset.append(i)
solset = recur(numset,b,'',[],[])



for i in solset:
    solexp = ''
    for j in range(0,len(i)-1):
        i = sorted(i)
        solexp = solexp + i[j] + ' '
    solexp = solexp + i[-1]
    print(solexp)
