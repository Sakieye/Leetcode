def insert(intervals, newInterval):
    l = 0
    r = len(intervals) - 1
    for i, interval in enumerate(intervals):
        if interval[1] < newInterval[0]:
            l += 1
        else:
            break

    for i in range(r, -1, -1):
        interval = intervals[i]
        if newInterval[1] < interval[0]:
            r -= 1
        else:
            break
    print(l, r)

    if l > r:
        return intervals[:l] + [newInterval] + intervals[l:]

    intervals[l : r + 1] = [
        [
            min(newInterval[0], intervals[l][0]),
            max(newInterval[1], intervals[r][1]),
        ]
    ]

    return intervals


print(insert([[1, 3], [6, 9]], [2, 5]))
print(insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]))
print(insert([], [5, 7]))
print(insert([[1, 5]], [2, 3]))
print(insert([[1, 5]], [2, 7]))
print(insert([[1, 5]], [6, 8]))
print(insert([[1, 5]], [0, 0]))
print(insert([[3, 5], [12, 15]], [6, 6]))
