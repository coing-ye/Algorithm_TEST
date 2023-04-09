import sys
import copy

N,M,K = map(int,sys.stdin.readline().split())
board_set = []

for i in range(N):
    temp = list(map(int,sys.stdin.readline().split()))
    board_set.append(temp)

answer = -30001

def recurNM(ts,N,M,k,tmp):
    if k==1:
        for i in range(len(ts)):

            global answer
            sum = tmp+board_set[ts[i]//M][ts[i]%M]
            if answer < sum:
                answer = sum

        return

    for i in range(len(ts)):
        tempset = copy.deepcopy(ts[i:])

        if ts[i]%M<M-1:
            #offlist.append(ts[i]+1)
            if ts[i]+1 in tempset:
                tempset.remove(ts[i]+1)

        if ts[i]//M<N-1:
            #offlist.append(ts[i]+M)
            if ts[i]+M in tempset:
                tempset.remove(ts[i]+M)
        #offlist.append(ts[i])
        tempset.remove(ts[i])

        recurNM(tempset,N,M,k-1,tmp+board_set[ts[i]//M][ts[i]%M])

    return


ts = []
for i in range(N):
    for j in range(M):
        ts.append(i*M+j)

recurNM(ts,N,M,K,0)

print(answer)
