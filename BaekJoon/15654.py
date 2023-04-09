import sys
import copy

#깊은 복사, 얕은복사 개념 알아야 더 제대로 풀수 있따.
def recur(a,b,exp,sol):
    if b ==0 :
        sol.append(copy.deepcopy(exp))
        return

    for i in range(len(a)):
        exp.append(a[i])
        tempset = a[:i]+a[i+1:]
        recur(tempset,b-1,exp,sol)
        exp.pop(-1)


    return sol

a, b = map(int,sys.stdin.readline().split())
numset = sorted(list(map(int,sys.stdin.readline().split())))



solset = recur(numset,b,[],[])



for i in solset:
    sentence = ''
    for j in i:
        sentence = sentence + str(j)+ ' '
    print(sentence)
