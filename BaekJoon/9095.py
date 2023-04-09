import sys

gset = [3,2,1]
def allset(com,n,exp,sol):
    if n==0:
        sol.append(exp)
        return
    elif n<0:
        return

    for i in com:
        exp = exp+str(i)
        allset(com,n-i,exp,sol)
        exp = exp[0:-1]
    return sol

N = int(sys.stdin.readline())
inputcase = []
for _ in range(N):
    inputcase.append(int(sys.stdin.readline()))

for i in inputcase:
    print(len(allset(gset,i,'',[])))
