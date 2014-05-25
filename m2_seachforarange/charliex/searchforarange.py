"""
fixed 14 bugs...I feel so cheap
"""

class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]

    def midSearch(self):
        if self.start > self.end:
            # base case
            return -1
        mid = self.start + (self.end - self.start) / 2
        if (self.A[mid] == self.target):
            return mid
        elif (self.A[mid] > self.target):
            self.end = mid - 1
            return self.midSearch()
        else:
            self.start = mid + 1
            return self.midSearch()

    def searchForLeft(self, found):
        if self.start >= found:
            return
        mid = self.start + (found - self.start) / 2
        if(self.A[mid] == self.target):
            self.searchForLeft(mid)
        else:
            self.start = mid + 1
            self.searchForLeft(found)

    def searchForRight(self, found):
        if self.end <= found:
            return
        mid = found + (self.end - found + 1) / 2
        if(self.A[mid] == self.target):
            self.searchForRight(mid)
        else:
            self.end = mid - 1
            self.searchForRight(found)

    def searchRange(self, A, target):
        if not A:
            return [-1, -1]
        self.A = A
        self.end = len(A) - 1
        self.start = 0
        self.target = target
        found = self.midSearch()
        if found == -1:
            return [-1, -1]
        self.searchForLeft(found)
        self.searchForRight(found)
        return [self.start, self.end]


if __name__ == '__main__':
    s = Solution()
    # print s.searchRange([5, 7, 7, 8, 8, 8], 8)
    print s.searchRange([1, 2, 3], 2)  # [1, 1]
    print s.searchRange([1, 2, 3, 3, 3, 3, 4, 5, 9], 3)  # [2,5]
    print s.searchRange([1, 2, 2], 2) # [1, 2]
