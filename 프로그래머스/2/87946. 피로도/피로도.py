from itertools import permutations
def solution(k, dungeons):
    answer = -1
    combi = []
    for i in range(len(dungeons)):
        combi.append(i)
    hubos = list(permutations(combi,len(dungeons)))
    answer = 0
    for hubo in hubos:
        tmp = 0
        tmpk = k
        for d in list(hubo):
            if tmpk >= dungeons[d][0]:
                tmp +=1
                tmpk -= dungeons[d][1]
                if tmpk < 0:
                    tmpk = 0
        #print(hubo," ",tmp)
        answer = max(answer,tmp)
    return answer