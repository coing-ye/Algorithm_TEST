import sys

mi,mx = map(int,sys.stdin.readline().split())
MAX = 1000000

totalset = [0]*MAX
solset = [0]*(mx-mi+2)

flag_num = 0

for i in range(MAX):
    totalset[i] = (i+1)*(i+1)
    flag_num = i
    if totalset[i] > mx:
        totalset = totalset[:i]
        break

totalset = totalset[1:]

#약수 개념의 이해, min의 최댓값이 1,000,000의 제곱수라는걸 알면 쉽게 해결 가능.
#시간복잡도 O(NlogN)까지 줄일 수 있다.

for i in totalset:
    if mi%i==0:
        sn = mi//i
    else:
        sn = (mi//i)+1
    for j in range(sn,(mx//i)+1):
        solset[j*i-mi+1]+=1

pownum = 0
solset.pop(0)
for i in range(len(solset)):
    if solset[i] > 0:
        pownum +=1
answer = mx-mi+1-pownum


print(answer)
