package medium;

import java.util.*;

public class Medium0622DesignCircularQueue {
    class MyCircularQueue {

        Integer frontIdx = null;
        Integer rearIdx = null;
        int size;
        int[] arr;
        public MyCircularQueue(int k) {
            size = k;
            arr = new int[size];
            Arrays.fill(arr, -1);
        }

        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }

            if (isEmpty()){
                frontIdx = 0;
                rearIdx = 0;
                arr[0] = value;
            }
            else{
                if (rearIdx == size - 1){
                    rearIdx = 0;
                    arr[0] = value;
                }
                else{
                    rearIdx = rearIdx + 1;
                    arr[rearIdx] = value;
                }
            }
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            if(rearIdx == frontIdx){
                arr[frontIdx] = -1;
                rearIdx = null;
                frontIdx = null;
            }
            else{
                arr[frontIdx] = -1;
                if (frontIdx == size - 1){
                    frontIdx = 0;
                }
                else{
                    frontIdx = frontIdx + 1;
                }
            }


            return true;
        }

        public int Front() {
            if (isEmpty()){
                return - 1;
            }
            return arr[frontIdx];
        }

        public int Rear() {
            if (isEmpty()){
                return - 1;
            }
            return arr[rearIdx];
        }

        public boolean isEmpty() {
            return frontIdx == null;
        }

        public boolean isFull() {
            if (frontIdx != null){
                if (frontIdx - rearIdx == 1 || frontIdx == 0 && rearIdx == size - 1){
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

}