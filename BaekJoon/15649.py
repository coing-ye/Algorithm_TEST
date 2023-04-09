import sys


def recur(a,b,exp,sol):
    if b==0:
        sol.append(exp)
        return
    for i in range(len(a)):
        tempset=a[:i]+a[i+1:]
        #tempset=a
        exp=exp+str(a[i])
        recur(tempset,b-1,exp,sol)
        exp = exp[:-1]
    return sol

a, b = map(int,sys.stdin.readline().split())
numset = []
for i in range(1,a+1):
    numset.append(i)
solset = recur(numset,b,'',[])

for i in solset:
    solexp = ''
    for j in range(0,len(i)-1):
        solexp = solexp + i[j] + ' '
    solexp = solexp + i[-1]
    print(solexp)
