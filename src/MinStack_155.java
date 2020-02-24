public class MinStack_155 {
    class MinStack
    {
        int[] data;
        int capacity = 10;
        int top;
        int min;

        public MinStack()
        {
            data = new int[capacity];
            top = -1;
            min = Integer.MAX_VALUE;
        }

        public void push(int x)
        {
            if (top == capacity - 1) grow();
            data[++top] = x;
            min = Math.min(min, x);
        }

        public void pop()
        {
            top--;
            refresh();
        }

        private void grow()
        {
            capacity *= 2;
            int[] temp = new int[capacity];
            for (int i = 0; i < data.length; i++)
            {
                temp[i] = data[i];
            }
            data = temp;
        }

        private void refresh()
        {
            min = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++)
            {
                min = Math.min(min, data[i]);
            }
        }

        public int top()
        {
            return data[top];
        }

        public int getMin()
        {
            return min;
        }
    }
}
