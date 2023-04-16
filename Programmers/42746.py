def solution(numbers):
    answer = ''
    tn = []
    for i in numbers:
        plusnum = 4-len(str(i))
        tmpnum = str(i)[0]*plusnum
        tn.append([int(str(i)+tmpnum),plusnum])


    tn.sort(key = lambda x: -x[0])

    for i in tn:
        minusnum = 4-i[1]
        tmp = str(i[0])[:minusnum]
        answer += tmp
    answer = str(int(answer))
    return answer
