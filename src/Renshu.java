public class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // 1からnまでの整数の合計値を返す
    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // pからqまでの整数の合計値を返す
    public int sumFromPtoQ(int p, int q) {
        int sum = 0;
        if (p <= q) {
            for (int i = p; i <= q; i++) {
                sum += i;
            }
        } else {
            return -1;
        }
        return sum;
    }

    // 配列a[]の指定されたindexから以降の要素の合計値を返す。不正なindexの場合は-1を返す
    public int sumFromArrayIndex(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            return -1;
        }
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    // 配列aの中で最大の値を返す
    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    // 配列aの中で最大の値が入っている要素の位置（index）を返す。最大値が複数の場合は最小のindexを返す
    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 配列pのi番目とj番目の要素を入れ替える
    public void swapArrayElements(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    // 同じ長さの二つの配列aとbの内容を入れ替える
    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length!= b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }
    // 引数の配列内の一番小さい値を持つ位置を返す
    public int selectMinIndex(int[] a) {
        int min = a[0];
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 引数の配列内の一番小さい要素を返す
    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}