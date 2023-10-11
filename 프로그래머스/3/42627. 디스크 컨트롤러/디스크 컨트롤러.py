import heapq
import math

class task:
    def __init__(self,start,spend):
        self.start = start
        self.spend = spend
        self.end = start+spend
    def __lt__(self,other):
        if self.spend == other.spend:
            return self.start < other.start
        else:
            return self.spend < other.spend 

def solution(jobs):
    answer = 0
    hq = []
    #jobs = [[1,4],[7,9],[1000,3]]
    
    totalnum = len(jobs)
    
    for job in jobs:
        hq.append(task(job[0],job[1]))    
    heapq.heapify(hq)
    
    nowtime = 0
    while(hq):
        ta = heapq.heappop(hq)
        if nowtime < ta.start:
            heapq.heappush(hq,ta)
            hq.sort(key = lambda x:(x.spend,x.start))
            flag= 0
            while(flag ==0):
                for i in range(len(hq)):
                    if nowtime >= hq[i].start:
                        ta = hq.pop(i)
                        flag = 1
                        break
                if flag ==0:
                    nowtime +=1
            heapq.heapify(hq)
        
        
        if nowtime >= ta.start:
            tasktime = nowtime - ta.start + ta.spend
            nowtime += ta.spend
        else:
            nowtime = ta.end
            tasktime = ta.spend
            
        answer += tasktime

        
    
    
    
    answer = answer//totalnum
    return answer