package com.zhishi.leetcode.normal;

import java.util.Random;

/**
 * Created by songpb on 2020/11/7.
 * https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
 */
public class 区间和的个数327 {
    /**
     * 方法一：归并排序
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
    /**
     * 方法二：线段树
     */
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        long sum = 0;
//        long[] preSum = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; ++i) {
//            sum += nums[i];
//            preSum[i + 1] = sum;
//        }
//
//        Set<Long> allNumbers = new TreeSet<Long>();
//        for (long x : preSum) {
//            allNumbers.add(x);
//            allNumbers.add(x - lower);
//            allNumbers.add(x - upper);
//        }
//        // 利用哈希表进行离散化
//        Map<Long, Integer> values = new HashMap<Long, Integer>();
//        int idx = 0;
//        for (long x : allNumbers) {
//            values.put(x, idx);
//            idx++;
//        }
//
//        SegNode root = build(0, values.size() - 1);
//        int ret = 0;
//        for (long x : preSum) {
//            int left = values.get(x - upper), right = values.get(x - lower);
//            ret += count(root, left, right);
//            insert(root, values.get(x));
//        }
//        return ret;
//    }
//
//    public SegNode build(int left, int right) {
//        SegNode node = new SegNode(left, right);
//        if (left == right) {
//            return node;
//        }
//        int mid = (left + right) / 2;
//        node.lchild = build(left, mid);
//        node.rchild = build(mid + 1, right);
//        return node;
//    }
//
//    public int count(SegNode root, int left, int right) {
//        if (left > root.hi || right < root.lo) {
//            return 0;
//        }
//        if (left <= root.lo && root.hi <= right) {
//            return root.add;
//        }
//        return count(root.lchild, left, right) + count(root.rchild, left, right);
//    }
//
//    public void insert(SegNode root, int val) {
//        root.add++;
//        if (root.lo == root.hi) {
//            return;
//        }
//        int mid = (root.lo + root.hi) / 2;
//        if (val <= mid) {
//            insert(root.lchild, val);
//        } else {
//            insert(root.rchild, val);
//        }
//    }
    /**
     * 方法三：动态增加节点的线段树
     */
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        long sum = 0;
//        long[] preSum = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; ++i) {
//            sum += nums[i];
//            preSum[i + 1] = sum;
//        }
//
//        long lbound = Long.MAX_VALUE, rbound = Long.MIN_VALUE;
//        for (long x : preSum) {
//            lbound = Math.min(Math.min(lbound, x), Math.min(x - lower, x - upper));
//            rbound = Math.max(Math.max(rbound, x), Math.max(x - lower, x - upper));
//        }
//
//        SegNode2 root = new SegNode2(lbound, rbound);
//        int ret = 0;
//        for (long x : preSum) {
//            ret += count(root, x - upper, x - lower);
//            insert(root, x);
//        }
//        return ret;
//    }
//
//    public int count(SegNode2 root, long left, long right) {
//        if (root == null) {
//            return 0;
//        }
//        if (left > root.hi || right < root.lo) {
//            return 0;
//        }
//        if (left <= root.lo && root.hi <= right) {
//            return root.add;
//        }
//        return count(root.lchild, left, right) + count(root.rchild, left, right);
//    }
//
//    public void insert(SegNode2 root, long val) {
//        root.add++;
//        if (root.lo == root.hi) {
//            return;
//        }
//        long mid = (root.lo + root.hi) >> 1;
//        if (val <= mid) {
//            if (root.lchild == null) {
//                root.lchild = new SegNode2(root.lo, mid);
//            }
//            insert(root.lchild, val);
//        } else {
//            if (root.rchild == null) {
//                root.rchild = new SegNode2(mid + 1, root.hi);
//            }
//            insert(root.rchild, val);
//        }
//    }

    /**
     * 方法四：树状数组
     */
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        long sum = 0;
//        long[] preSum = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; ++i) {
//            sum += nums[i];
//            preSum[i + 1] = sum;
//        }
//
//        Set<Long> allNumbers = new TreeSet<Long>();
//        for (long x : preSum) {
//            allNumbers.add(x);
//            allNumbers.add(x - lower);
//            allNumbers.add(x - upper);
//        }
//        // 利用哈希表进行离散化
//        Map<Long, Integer> values = new HashMap<Long, Integer>();
//        int idx = 0;
//        for (long x: allNumbers) {
//            values.put(x, idx);
//            idx++;
//        }
//
//        int ret = 0;
//        BIT bit = new BIT(values.size());
//        for (int i = 0; i < preSum.length; i++) {
//            int left = values.get(preSum[i] - upper), right = values.get(preSum[i] - lower);
//            ret += bit.query(right + 1) - bit.query(left);
//            bit.update(values.get(preSum[i]) + 1, 1);
//        }
//        return ret;
//    }
    /**
     * 方法五：平衡二叉搜索树
     */
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        long sum = 0;
//        long[] preSum = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; ++i) {
//            sum += nums[i];
//            preSum[i + 1] = sum;
//        }
//
//        BalancedTree treap = new BalancedTree();
//        int ret = 0;
//        for (long x : preSum) {
//            long numLeft = treap.lowerBound(x - upper);
//            int rankLeft = (numLeft == Long.MAX_VALUE ? (int) (treap.getSize() + 1) : treap.rank(numLeft)[0]);
//            long numRight = treap.upperBound(x - lower);
//            int rankRight = (numRight == Long.MAX_VALUE ? (int) treap.getSize() : treap.rank(numRight)[0] - 1);
//            ret += rankRight - rankLeft + 1;
//            treap.insert(x);
//        }
//        return ret;
//    }
}

class SegNode {
    int lo, hi, add;
    SegNode lchild, rchild;

    public SegNode(int left, int right) {
        lo = left;
        hi = right;
        add = 0;
        lchild = null;
        rchild = null;
    }
}

class SegNode2 {
    long lo, hi;
    int add;
    SegNode2 lchild, rchild;

    public SegNode2(long left, long right) {
        lo = left;
        hi = right;
        add = 0;
        lchild = null;
        rchild = null;
    }
}

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
}

class BalancedTree {
    private class BalancedNode {
        long val;
        long seed;
        int count;
        int size;
        BalancedNode left;
        BalancedNode right;

        BalancedNode(long val, long seed) {
            this.val = val;
            this.seed = seed;
            this.count = 1;
            this.size = 1;
            this.left = null;
            this.right = null;
        }

        BalancedNode leftRotate() {
            int prevSize = size;
            int currSize = (left != null ? left.size : 0) + (right.left != null ? right.left.size : 0) + count;
            BalancedNode root = right;
            right = root.left;
            root.left = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }

        BalancedNode rightRotate() {
            int prevSize = size;
            int currSize = (right != null ? right.size : 0) + (left.right != null ? left.right.size : 0) + count;
            BalancedNode root = left;
            left = root.right;
            root.right = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }
    }

    private BalancedNode root;
    private int size;
    private Random rand;

    public BalancedTree() {
        this.root = null;
        this.size = 0;
        this.rand = new Random();
    }

    public long getSize() {
        return size;
    }

    public void insert(long x) {
        ++size;
        root = insert(root, x);
    }

    public long lowerBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x == node.val) {
                return x;
            }
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public long upperBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public int[] rank(long x) {
        BalancedNode node = root;
        int ans = 0;
        while (node != null) {
            if (x < node.val) {
                node = node.left;
            } else {
                ans += (node.left != null ? node.left.size : 0) + node.count;
                if (x == node.val) {
                    return new int[]{ans - node.count + 1, ans};
                }
                node = node.right;
            }
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
    }

    private BalancedNode insert(BalancedNode node, long x) {
        if (node == null) {
            return new BalancedNode(x, rand.nextInt());
        }
        ++node.size;
        if (x < node.val) {
            node.left = insert(node.left, x);
            if (node.left.seed > node.seed) {
                node = node.rightRotate();
            }
        } else if (x > node.val) {
            node.right = insert(node.right, x);
            if (node.right.seed > node.seed) {
                node = node.leftRotate();
            }
        } else {
            ++node.count;
        }
        return node;
    }
}


