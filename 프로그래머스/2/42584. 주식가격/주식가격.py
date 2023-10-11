from collections import deque
def solution(prices):
    answer = [0]*len(prices)
    stack = deque()
    stack.append([prices[0],0])
    for i in range(1,len(prices)):
        while(len(stack)>0 and prices[i] < stack[-1][0]):
            before = stack.pop()
            answer[before[1]] = i - before[1]
        
        stack.append([prices[i],i])
    
    while(stack):
        now = stack.pop()
        answer[now[1]] = len(prices)-now[1]-1
    
    return answer