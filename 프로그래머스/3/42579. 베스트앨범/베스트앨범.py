import math
import heapq

class song:
    def __init__(self, genre,totalplay,play,num):
        self.genre = genre
        self.totalplay = totalplay
        self.play = play
        self.num = num
    def __lt__(self,other):
        if self.totalplay == other.totalplay:
            if self.play == other.play:
                return self.num < other.num
            else:
                return self.play > other.play
        else:
            return self.totalplay > other.totalplay

def solution(genres, plays):
    answer = []
    genreset = set()
    totalplay = {}
    outsong = {}
    sortarr = []
    for i in range(len(genres)):
        if genres[i] not in genreset:
            genreset.add(genres[i])
            totalplay[genres[i]] = plays[i]
            outsong[genres[i]] = 0
        else:
            totalplay[genres[i]]+=plays[i]
    
    heapq.heapify(sortarr)
    for i in range(len(genres)):
        heapq.heappush(sortarr,song(genres[i],totalplay[genres[i]],plays[i],i))
    
    while len(sortarr)>0:
        tmp = heapq.heappop(sortarr)
        if outsong[tmp.genre] <2:
            outsong[tmp.genre] +=1
            answer.append(tmp.num)
    
    return answer