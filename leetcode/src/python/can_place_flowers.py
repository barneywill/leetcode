from typing import List

class CanPlaceFlowers:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        flower_cnt = 0
        last_flower = -2
        for i, v in enumerate(flowerbed):
            if v == 1:
                if i - last_flower - 1 > 1:
                    flower_cnt += self.getFlowerCnt(i - last_flower - 1)
                    if (flower_cnt >= n):
                        return True
                last_flower = i
        if len(flowerbed) - last_flower > 1:
            flower_cnt += self.getFlowerCnt(len(flowerbed) - last_flower)
        return flower_cnt >= n

    def getFlowerCnt(self, num: int) -> int:
        return int((num + 1) / 2) - 1

if __name__ == '__main__':
    instance = CanPlaceFlowers()
    print(instance.getFlowerCnt(1)) # 1
    print(instance.getFlowerCnt(2)) # 1
    print(instance.getFlowerCnt(3)) # 1
    print(instance.getFlowerCnt(4)) # 1
    print(instance.getFlowerCnt(5)) # 1
    print(instance.canPlaceFlowers([1,0,0,0,1], 1)) # True
    print(instance.canPlaceFlowers([1,0,1,0,1,0,1], 0)) # True
    print(instance.canPlaceFlowers([0,0,1,0,1], 1)) # True
    print(instance.canPlaceFlowers([1,0,0,0,1,0,0], 2)) # True