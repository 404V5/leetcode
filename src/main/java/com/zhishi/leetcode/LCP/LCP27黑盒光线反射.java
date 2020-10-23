package com.zhishi.leetcode.LCP;

/**
 * Created by songpb on 2020/10/23.
 * https://leetcode-cn.com/problems/IQvJ9i/
 */
public class LCP27黑盒光线反射 {
    boolean[] state;// 存储index下标小洞的打开状态：false表示关闭，true表示打开
    int[] clock;// 存储index小洞沿y=x方向将要照射的下一个小洞的index
    int[] anticlock;// 存储index小洞沿y=-x方向将要照射的下一个小洞的index

    LCP27黑盒光线反射(int n, int m) {
        int cnt = 2 * (m + n);
        state = new boolean[cnt];
        clock = new int[cnt];
        anticlock = new int[cnt];
        for (int index = 0; index < cnt; index++) {
            clock[index] = (cnt - index + cnt) % cnt;
            anticlock[index] = (2 * m - index + cnt) % cnt;
            state[index] = false;
        }
    }

    public int open(int index, int direction) {
        int I = index;// 保存起点
        state[index] = true;// 打开小洞
        // 选择下一个反射点
        if (direction == 1)
            index = clock[index];
        else
            index = anticlock[index];
        // 改变反射方向
        direction *= -1;
        // 反射操作尽量不要封装成函数,否则容易超时
        while (state[index] == false) {// 若该点是闭合状态,则继续反射
            // 如果下一个点是角，则光最终会原路返回起点
            if (clock[index] == index || anticlock[index] == index)
                return I;
            // 选择下一个反射点
            if (direction == 1)
                index = clock[index];
            else
                index = anticlock[index];
            // 改变反射方向
            direction *= -1;
        }

        return index;// 若该点是打开状态,则从该点射出
    }

    public void close(int index) {
        state[index] = false;
    }
}
