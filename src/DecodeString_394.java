import java.util.Stack;

class IntString
{
    int mult;
    String body;
    IntString(int mult, String body)
    {
        this.mult = mult;
        this.body = body;
    }
}
// 用stack 想到了 但是stack应当倒着用。将前面的答案乘以mult，再加到pair的body里作为新的答案。
public class DecodeString_394 {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        Stack<IntString> pairStack = new Stack<>();
        String mult = "", result = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
            {
                mult += s.charAt(i);
                continue;
            }
            if (s.charAt(i) == '[')
            {
                pairStack.push(new IntString(Integer.parseInt(mult), result));
                mult = "";
                result = "";
                continue;
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            {
                result += s.charAt(i);
                continue;
            }
            if (s.charAt(i) == ']')
            {
                IntString pair = pairStack.pop();
                if (pair != null)
                {
                    for (int j = 0; j < pair.mult; j++)
                    {
                        pair.body += result;
                    }
                    result = pair.body;
                }
                continue;
            }
            result += s.charAt(i);
        }
        return result;
    }
}
