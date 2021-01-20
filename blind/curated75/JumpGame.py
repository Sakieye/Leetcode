def canJump(nums) -> bool:
    goal = len(nums) - 1
    for i in range(goal, -1, -1):
        if i + nums[i] >= goal:
            goal = i
    return not goal


n1 = [2, 3, 1, 1, 4]
n2 = [3, 2, 1, 0, 4]
n3 = [1]
n4 = [0, 2]
n5 = [0, 2, 3]
n6 = [3, 0, 8, 2, 0, 0, 1]
print(canJump(n1), canJump(n2), canJump(n3), canJump(n4), canJump(n5), canJump(n6))