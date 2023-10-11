import math
def solution(brown, yellow):
    answer = [0]*2
    total = brown+yellow
    for i in range(3,int(math.sqrt(total))+1):
        if((i-2)*((total//i)-2) == yellow):
            answer[0] = total//i
            answer[1] = i
            break
            
    return answer
