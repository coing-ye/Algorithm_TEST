#https://school.programmers.co.kr/learn/courses/30/lessons/12909
#스택/큐 > 올바른 괄호

from collections import deque
def solution(s):
    answer = True

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print('Hello Python')
    brack =  deque()
    for i in s:
        brack.append(i)
        if i == ')' and len(brack)>1:
                if brack[-2] == '(':
                    brack.pop()
                    brack.pop()

    if brack:
        return False
    else:
        return True
