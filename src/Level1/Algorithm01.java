package Level1;

import java.util.ArrayList;
import java.util.HashMap;

public class Algorithm01 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (int i=0;i<privacies.length;i++) {
            String[] arr = privacies[i].split(" ");
            int num = getTotal(arr[0]) + map.get(arr[1])*28-1;
            if (num < getTotal(today)) list.add(i+1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getTotal(String strDate) {
        String[] arr = strDate.split("\\.");
        return Integer.parseInt(arr[0]) * 12 * 28 + Integer.parseInt(arr[1]) * 28 + Integer.parseInt(arr[2]);
    }
}
