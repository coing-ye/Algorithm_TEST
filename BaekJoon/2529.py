import sys
import copy

N = int(sys.stdin.readline())
condition = list(sys.stdin.readline().split())



#백트랙킹 문제
#은근 까다로운데 머리로 풀어서 그런듯. 역시 재귀는 종이에 써가며 풀어야한다.
largenum = 0
smallnum = int('9'*(N+1))
bs = []

for i in range(10):
    bs.append(i)



def isbiggerthanX(x,compareset):
    if x < compareset[0]:
        return compareset

    for i in range(len(compareset)):
        if compareset[i]>x:
            return compareset[i:]


def issmallerthanX(x,compareset):
    if x>compareset[-1]:
        return compareset
    for i in range(len(compareset)):
        if compareset[i]>x:
            return compareset[:i]



def recur(tset,lset,digit,sol):
    if digit == N:
        for i in tset:
            sol = sol+str(i)
            #print(sol)
            global largenum
            global smallnum
            if int(sol) > int(largenum):
                largenum = sol
            if int(sol) < int(smallnum):
                smallnum = sol
            sol = sol[:-1]

        return

    for i in range(len(tset)):
        #남아있는 숫자 모음 lset을 얕은 복사하면 값이 엉키므로 숫자가 바뀔때마다 새로 깊은복사 해야함
        #현재 숫자는 당연히 사용됐다고 치고 남은 숫자 모음에서 뺀다.
        #왜냐면 이 문제는 사용한 숫자는 재사용 불가니까

        tmpset = copy.deepcopy(lset)
        tmpset.remove(tset[i])

        #애초에 조건에 안맞는건 재귀 안돌린다.
        if condition[digit] == '<':
            #사용가능한 숫자 중에 현재 숫자보다 큰값이 존재하면 다음 digit으로 재귀
            #아니라면 그냥 해당 숫자는 넘어간다(끝까지 가지도 않는다).
            if tset[i] < tmpset[-1]:
                recur(isbiggerthanX(tset[i],tmpset),tmpset,digit+1,sol+str(tset[i]))
        elif condition[digit] == '>':
            #사용가능한 숫자 중에 현재 숫자보다 작은값이 존재하면 다음 digit으로 재귀
            #아니라면 그냥 해당 숫자는 넘어간다(끝까지 가지도 않는다).
            if tset[i] > tmpset[0]:
                recur(issmallerthanX(tset[i],tmpset),tmpset,digit+1,sol+str(tset[i]))

    return

recur(bs,bs,0,'')
print(largenum)
print(smallnum)
