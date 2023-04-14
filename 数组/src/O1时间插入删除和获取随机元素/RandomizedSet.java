package O1时间插入删除和获取随机元素;

import java.util.*;

public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> valToIndex;
    Random random;

    public RandomizedSet() {
        nums = new LinkedList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        valToIndex.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val); //获取要删除的数的下标
        int last = nums.get(nums.size() - 1); //获取最后一个数
        nums.set(index, last); //用最后一个数覆盖当前下标
        valToIndex.put(last, index); //更新map
        nums.remove(nums.size() - 1); //删除最后一个数
        valToIndex.remove(val); //删除val
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
