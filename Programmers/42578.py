#https://school.programmers.co.kr/learn/courses/30/lessons/42578
#해시 > 의상
from itertools import combinations
def solution(clothes):
    answer = 0
    setting = {}
    species = []
    for i in range(len(clothes)):
        if clothes[i][1] in setting:
            setting[clothes[i][1]] +=1
        else:
            setting[clothes[i][1]] = 1
            species.append(clothes[i][1])

    tmp = 1
    for i in species:
        tmp  = tmp * (setting[i]+1)
    answer += tmp
    answer = answer - 1


    return answer
