public class ReverseStr {

    static void reverse(char str[], int start, int end) {
        System.out.println("reverse:  " + start + ":" + end);
        char tmp;
        while (start <= end)
        {
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }

    static void reverseWords(char[] s)
    {
        // reverse entire String
        reverse(s, 0, s.length - 1);
        System.out.println(s);

        int start = 0;
        for (int end = 0; end < s.length; end++)
        {
            if (s[end] == ' ')
            {
                // reverse word from start to before space
                reverse(s, start, end - 1);
                System.out.println(s);
                start = end + 1;
            }
        }

        // reverse last word
        reverse(s, start, s.length - 1);
    }

    // test driver
    public static void main(String[] args)
    {
        String s = "The quick brown fox";

        // TEST #1 reverse a string in-place
        // string immutable, need to convert to char array for in-place reversal
        char[] rs1 = s.toCharArray();
        reverse(rs1, 0, s.length() - 1);
        System.out.println(rs1);

        // TEST #2 reverse words in a phrase in-place
        char[] rs2 = s.toCharArray();
        reverseWords(rs2);
        String reversedWords = String.valueOf(rs2);
        System.out.println(reversedWords);
    }
}