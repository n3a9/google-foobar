import math


def solution(n):
    
    lookup_table = dict()
    lookup_table[(0, 0)] = 1
    
    def getLongestStaircase(n):
        return (-1 + math.sqrt(1 + 8 * n)) // 2
        
    def MinBricksForStairs(stairLength):
        return (stairsLength ** 2 + stairLength) / 2
        
    def P(n, k):
        if (n, k) in lookup_table.keys():
            return lookup_table[(n, k)]
        if k > 0 and k <= n:
            tmp = P(n, k - 1) + P(n - k, k)
            lookup_table[(n, k)] = tmp
            return tmp
        if k > n:
            tmp = P(n, n)
            lookup_table[(n, k)] = tmp
            return tmp
        if n != 0 and k == 0:
            tmp = 0
            lookup_table[(n, k)] = tmp
            return tmp
        return 0
    
    
    res = 0
    for stairsLength in range(2, int(getLongestStaircase(n) + 1)):
        remains = n - MinBricksForStairs(stairsLength)
        res += P(remains, stairsLength)
    return res
