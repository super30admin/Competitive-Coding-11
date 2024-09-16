class Solution:
    """
            Problem : 735
            Name    : Shahreen Shahjahan Psyche
            Time    : O(N)
            Space   : O(N) [It could be O(1) if I dont count my output array as an auxiliary array]
            
            Passed All Test Cases in LC : Yes
            
            Approach : # Initialize a stack
                       # Start pushing the asteroids until we get 2 asteroids are approaching towards each other. Which meeans, current one should be -ve
                         and previous one should be +ve
                       # Now, if there is a collision, then we start popping out the asteroids from stack until we get a smaller or equal magnituted's +ve asteroids
                         or the stack is empty
                       # After popping all of them, if the asteroid does not encounter an equal positive asteroid or greater than that, it will get pushed back to                            stack
                       # At the end, return the stack
    
    
    """
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        if not asteroids:
            return []
        
        track = []
        
        for i in range(len(asteroids)):
            # when the stack is empty, just pushing the current value
            if len(track) == 0:
                track.append(asteroids[i])
            else:
                # if my current asteeroid is -ve and the stack top is +ve, that means they are moving towards each other and theeir will be collision
                if asteroids[i] < 0 and track[-1] > 0:
                    flag = False
                    curr = -1
                    # eliminating all the astoroids that are less or equal magnitudee than the current asteroid
                    while len(track) != 0 and abs(asteroids[i]) >= track[-1]  and track[-1] > 0:
                        curr = track.pop()
                        # if the popped value is equal to the magnitude of the current one, then making the flag True and breaking loop
                        if curr == abs(asteroids[i]):
                            flag = True
                            break
                    # cheecking whether current asteroid satisfies to push back in the stack
                    if (len(track) == 0 and flag == False) or (len(track) != 0 and track[-1] < 0 and flag == False):
                        track.append(asteroids[i])  
                # if the astoroids are not coming towards each other, then nothing can be done. So we push the astoroids to the stack
                else:
                    track.append(asteroids[i])
            
        return track
                    
        
