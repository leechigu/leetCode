import java.util.*;

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> totalMap = new HashMap<>();
        HashMap<String, List<int[]>> genreInfo = new HashMap<>();
        int n = genres.length;
        for(int i=0;i<n;i++){
            String genre = genres[i];
            int playVal = plays[i];
            totalMap.put(genre,totalMap.getOrDefault(genre,0)+playVal);

            if(genreInfo.containsKey(genre)){
                genreInfo.get(genre).add(new int[]{i,playVal});
            }else{
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i,playVal});
                genreInfo.put(genre,list);
            }
        }

        ArrayList<String> genreList = new ArrayList<>(totalMap.keySet());
        Collections.sort(genreList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return totalMap.get(o2)-totalMap.get(o1);
            }
        });

        System.out.println(genreList.get(0));

        for(String key: genreInfo.keySet()){
            List<int[]> genreInfoList = genreInfo.get(key);
            Collections.sort(genreInfoList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0;i<genreList.size();i++){
            String genre = genreList.get(i);
            List<int[]> genreInfoList = genreInfo.get(genre);
            for(int j=0;j<genreInfoList.size()&&j<2;j++){
                answer.add(genreInfoList.get(j)[0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}