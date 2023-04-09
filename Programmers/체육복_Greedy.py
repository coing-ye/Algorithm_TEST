def solution(n, lost, reserve):
    answer = 0
    student = [0]*(n+2)

    dupli = []
    for i in lost:
        if i in reserve:
            dupli.append(i)
    for i in dupli:
        if i in lost:
            lost.remove(i)
        if i in reserve:
            reserve.remove(i)

    cantparti = len(lost)
    for i in reserve:
        student[i] = 1
    lost.sort()

    for i in lost:
        if student[i-1] ==1 or student[i+1] == 1:
            if student[i-1] == 1:
                student[i-1] = 0
                cantparti = cantparti - 1
            else:
                student[i+1] = 0
                cantparti = cantparti -1
    answer = n-cantparti
    return answer
