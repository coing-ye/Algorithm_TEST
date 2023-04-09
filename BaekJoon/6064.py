import sys
import math


def lcm(x,y):
    sqrtx = int(pow(x,1/2))
    sqrty = int(pow(y,1/2))
    divide_x = []
    divide_y = []
    for i in range(1,sqrtx+1):
        if x%i==0:
            divide_x.append(i)
            divide_x.append(x//i)
    for i in range(1,sqrty+1):
        if y%i==0:
            divide_y.append(i)
            divide_y.append(y//i)

    divide_x = sorted(divide_x)
    divide_y = sorted(divide_y)
    gcd_num = 1
    for i in divide_x:
        if i in divide_y:
            gcd_num = i
    lcm_num = gcd_num*(x//gcd_num)*(y//gcd_num)
    return lcm_num

n = int(sys.stdin.readline())
testcase = []
for i in range(0,n):
    testcase.append(list(map(int,sys.stdin.readline().split())))

for case in testcase:
    #max_year = lcm(case[0],case[1])
    max_year = math.lcm(case[0],case[1])
    flag = 0
    #시간복잡도를 nlogn까지 줄이기 위해 약수와 배수와의 관계 이용
    bignum = case[0]

    #1부터 max_year까지 모든 수를 비교하는 것이 아닌, M의 배수만을 비교하여 시간복잡도 감소
    for i in range(0,((max_year-case[2])//bignum)+1):
        tempnum = i*bignum+case[2]
        if tempnum >= case[3]:
            if (tempnum-case[3])%case[1] ==0:
                print(tempnum)
                flag = 1
                break

    if flag ==0:
        print("-1")
