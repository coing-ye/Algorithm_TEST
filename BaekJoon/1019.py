import sys
import math


#상당히 좋은문제. 구현난이도는 파이썬 기준 아주 낮은편인데, 식세우기가 쉽지 않다.
#특히 0의 처리가 굉장히 까다로운데, 이걸 해결하는 방법에서 난이도가 상당히 갈릴듯
#단위수에 따른 각 숫자의 등장 빈도를 구한다음, 자릿수에 따라 계산을 달리해줘야한다
#풀면서 느낀데 dp로도 가능은 할듯. 근데 재귀 짜기가 너무 싫었다. 단위도 너무 크다
#0~9 까지는 각 숫자가 1씩, 0~99까지는 20, 0~999까진 300, 0~9999까진 4000개씩 나온다.
#여기서 0처리가 굉장히 까다롭다. 책 시작페이지가 1페이지인것도 있고,
#두번째 자리수 부터는 0이 또 카운팅 되기 때문.



N = sys.stdin.readline().split()[0]
solset = [0,0,0,0,0,0,0,0,0,0]

def sumcount(n,digi):
    dc = (digi)*int(math.pow(10,digi-1))
    for i in range(len(solset)):
        solset[i] += dc
    solset[n] = solset[n]+int(math.pow(10,digi))

digit = len(N)



for i in range(digit):
    thisnum = int(N[i])
    thisdigi = digit-1-i



    if thisdigi == 0:
        for j in range(thisnum+1):
            solset[j]+=1
    else:
        for j in range(thisnum):
            sumcount(j,thisdigi)
        if i < digit-1:
            solset[thisnum] += int(N[i+1:])+1



minusnum = int((digit)*'1')

solset[0] = solset[0]-minusnum
solstr = list(map(str,solset))
print(' '.join(solstr))
