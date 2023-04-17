#https://school.programmers.co.kr/learn/courses/30/lessons/42839
#Brute Force > 소수 찾기
from itertools import permutations
def verify(num):
    if num < 2:
        return False
    snum = 0
    for i in range(1,int(pow(num,1/2))+1):
        if snum>2:
            break
        if num%i == 0:
            snum+=2
    if snum == 2:
        return True
    else:
        return False

def solution(numbers):
    answer = 0
    numset = set()
    numlist = []
    for i in numbers:
        numlist.append(i)
    numlist.sort(reverse = True)
    maxnum = int(''.join(numlist))

    for i in range(1,len(numbers)+1):
        ts = permutations(numlist,i)
        for j in ts:
            numset.add(int(''.join(j)))

    numset = list(numset)
    for i in numset:
        if verify(i) == True:
            answer+=1


    return answer
