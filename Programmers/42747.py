#https://school.programmers.co.kr/learn/courses/30/lessons/42747
#Sorting > H-Index

def solution(citations):
    answer = 0
    citations.sort()
    print(citations)
    totalnum = len(citations)
    cit_dict = {}
    overnum = totalnum
    for i in citations:
        cit_dict[i] = citations.count(i)

    for i in range(0,citations[-1]):
        if i<=overnum:
            answer  = i
        if i in citations:
            overnum = overnum - cit_dict[i]

    return answer
