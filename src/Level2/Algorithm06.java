package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Algorithm06 {
    public static int[] solution(int[] fees, String[] records) {
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        ArrayList<String> orderList = new ArrayList<>();
        HashMap<String, String[]> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (String record : records) {
            String[] recordArr = record.split(" ");
            if (!orderList.contains(recordArr[1])) orderList.add(recordArr[1]);
            if (map.containsKey(recordArr[1])) {
                String[] arrList = map.get(recordArr[1]);
                if (!arrList[1].equals(recordArr[2])) {
                    String[] timeArr = arrList[0].split(":");
                    String[] timeArr2 = recordArr[0].split(":");
                    int minute = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
                    int minute2 = Integer.parseInt(timeArr2[0]) * 60 + Integer.parseInt(timeArr2[1]);
                    result.put(recordArr[1], result.getOrDefault(recordArr[1], 0) + (minute2 - minute));
                    map.remove(recordArr[1]);
                    continue;
                }
            }
            map.put(recordArr[1], new String[]{recordArr[0], recordArr[2]});
        }
        for (String key : map.keySet()) {
            String[] arrList = map.get(key);
            String[] timeArr = arrList[0].split(":");
            int minute = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            result.put(key, result.getOrDefault(key, 0) + 23*60+59 - minute);
        }
        Object[] array = orderList.toArray();
        Arrays.sort(array);
        
        for (Object s : array) {
            int total;
            if ((result.get(s)) > fees[0]) {
                total = fees[1];
                total += Math.ceil(((double) (result.get(s) - fees[0]) / fees[2])) * fees[3];
            } else {
                total = fees[1];
            }
            list.add(total);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
