package leetcode.editor.entity;

public class UnionFind {
    private int[] id;
    private int count;
    private int[] sz;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int[] getSz() {
        return this.sz;
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (p != id[p]) id[p] = find(id[p]);
        return id[p];
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        if(sz[pRoot] < sz[qRoot]) { id[pRoot] = qRoot; sz[qRoot] += sz[pRoot]; }
        else                      { id[qRoot] = pRoot; sz[pRoot] += sz[qRoot]; }
        count--;
    }
}
