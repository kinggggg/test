package com.zeek.algorithmtest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BFSGraphTest
 * @Description 图的广度优先遍历。前提是图是用邻接表表示的无向图
 * @Author liweibo
 * @Date 2019/12/17 5:21 PM
 * @Version v1.0
 **/
public class BFSGraphTest {

    public int v; // 顶点的个数
    public LinkedList<Integer> adj[]; // 邻接表

    public BFSGraphTest(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {

        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }

    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {

        BFSGraphTest bfsGraphTest = new BFSGraphTest(3);
        bfsGraphTest.addEdge(0, 1);
        bfsGraphTest.addEdge(0, 2);

        System.out.println("done");

    }
}



