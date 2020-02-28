public class CountingBits_338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[] {0};
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++)
        {
            // odd
            if ((i & 1) == 1)
            {
                result[i] = result[i - 1] + 1;
            }
            else
            {
                result[i] = result[i >> 1];
            }
        }
        return result;
    }
}
