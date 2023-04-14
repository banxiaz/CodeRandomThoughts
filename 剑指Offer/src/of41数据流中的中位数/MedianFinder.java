package of41数据流中的中位数;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> bottom; //大顶堆
    PriorityQueue<Integer> top; //小顶堆

    public MedianFinder() {
        bottom = new PriorityQueue<>((n1, n2) -> n2 - n1);
        top = new PriorityQueue<>();
    }

    //保证两堆相等或者小顶比大顶多一个
    public void addNum(int num) {
        //最终要加入到小顶堆
        if (bottom.size() == top.size()) {
            bottom.add(num);
            top.add(bottom.poll());
        } else { //最终要加入到大顶堆
            top.add(num);
            bottom.add(top.poll());
        }
    }

    public double findMedian() {
        if (bottom.size() != top.size()) {
            return top.peek();
        } else {
            return (bottom.peek() + top.peek()) / 2.0;
        }
    }
}
