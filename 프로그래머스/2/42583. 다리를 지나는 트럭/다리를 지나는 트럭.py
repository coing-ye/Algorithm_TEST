from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    totaltruck = len(truck_weights)
    after_truck = deque()
    on_bridge = deque([0]*bridge_length)
    wait_truck = deque(truck_weights)
    
    onweight = 0
    time = 0
    
    while len(after_truck) < totaltruck:
       #print(time,": ",after_truck," / ",on_bridge," / ",wait_truck)
        
        front = on_bridge.popleft()
        if front > 0:
            after_truck.append(front)
            onweight -= front
            
        if len(wait_truck) > 0:    
            next_truck = wait_truck[0]
        else:
            next_truck = 0
            
        if (onweight+next_truck) <= weight:
            onweight += next_truck
            if(len(wait_truck)>0):
                on_bridge.append(wait_truck.popleft())
            else:
                on_bridge.append(0)
        else:
            on_bridge.append(0)
        time +=1
    #print(time,": ",after_truck," / ",on_bridge," / ",wait_truck)   
    answer = time
    
    return answer