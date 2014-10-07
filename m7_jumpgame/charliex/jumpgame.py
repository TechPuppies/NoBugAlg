"""
So Good
Cannot be better
"""

class Solution:
    # @param A, a list of integers
    # @return a boolean

    def canJump(self, A):
        canReach = 0
        for k, v in enumerate(A):
            if canReach >= k:
                canReach = max(k + v, canReach)
        return (canReach >= len(A) - 1)


    def canJump2(self, A):
        """
        canJump2 should be better than canJump with cut
        but actually is not on leetcode, don't know why
        """
        canReach = 0
        for k, v in enumerate(A):
            if canReach >= k:
                canReach = max(k + v, canReach)
                if canReach >= len(A) - 1:
                    return True
            else:
                return False


if __name__ == '__main__':
    s = Solution()
    print s.canJump(range(25000)[::-1])
