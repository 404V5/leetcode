package com.zhishi.leetcode.normal;

import java.util.Arrays;

/**
 * Created by songpb on 2020/9/17.
 * https://leetcode-cn.com/problems/redundant-connection-ii/
 */
public class 冗余连接贰685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    //[[1,2], [2,3], [3,4], [4,1], [1,5]]
    public static void main(String[] args) {
        冗余连接贰685 test = new 冗余连接贰685();
        int[][] a = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        System.out.println(Arrays.toString(test.findRedundantDirectedConnection(a)));
        int[][] b = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(test.findRedundantDirectedConnection(b)));
    }
}

class UnionFind {
    int[] ancestor;

    public UnionFind(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}
