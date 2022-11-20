import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Count occurrences of letters in a string which may not occur together
 */
public class Ocurrences {

    public static Map<Character, Integer> countOccurrences(String data) {
        Map<Character, Integer> countOccurs = new HashMap<Character, Integer>();
        char oneChar = '*';
        Integer oneCount = 0;
        int len = data.length();
        for (int i=0; i < len; i++) {
            oneChar = data.charAt(i);
            oneCount = countOccurs.get(oneChar);
            if (oneCount == null) {
                countOccurs.put(oneChar, 1);
            }
            else {
                countOccurs.put(oneChar, ++oneCount);
            }
        }
        return countOccurs;
    }

    public static void main(String[] args) {

        String data = "aaabcddb";
        Map<Character, Integer> occurrences = countOccurrences(data);
        for (Map.Entry<Character,Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
