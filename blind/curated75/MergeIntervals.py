def merge(intervals):
    res = []
    for i in sorted(intervals, key=lambda i: i[0]):
        if res and res[-1][1] >= i[0]:
            res[-1][1] = max(res[-1][1], i[1])
        else:
            res.append(i)
    return res


i1 = [[1, 3], [2, 6], [8, 10], [15, 18]]
i2 = [[1, 4], [4, 5]]
i3 = [[1, 2]]
print(merge(i1), merge(i2), merge(i3))
