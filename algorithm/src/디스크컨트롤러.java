import java.util.*;

class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;

        int[][] sortedJobs = new int[jobs.length][3];
        for(int i=0;i<jobs.length;i++){
            sortedJobs[i][0] = i;
            sortedJobs[i][1] = jobs[i][0];
            sortedJobs[i][2] = jobs[i][1];
        }

        Arrays.sort(sortedJobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        //작업의 번호, 작업의 요청 시각, 소요 시간
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]){
                    if(o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1]-o2[1];
                }
                return o1[2]-o2[2];
            }
        });

        //우선순위 -> 소요시간이 짧은것 요청시각이 빠른것 작업번호가 작은것
        int curTime = 0;
        int indx = 0;

        int[] curJob = new int[]{};

        while(true){
            //System.out.println("curTime = "+ curTime);
            //System.out.println("indx = "+ indx);
            //System.out.println("queueSize = "+ queue.size());
            //System.out.println("remainTime = "+ remainTime);
            //System.out.println("diskIsEmpty = "+ diskIsEmpty);
            //System.out.println();

            if(indx==sortedJobs.length && queue.isEmpty()){
                break;
            }

            while(true) {
                if(indx == sortedJobs.length){
                    break;
                }
                int[] job = sortedJobs[indx];
                if (curTime >= job[1]) {
                    queue.add(job);
                    indx++;
                }else{
                    break;
                }
            }

            if(!queue.isEmpty()){
                curJob = queue.poll();
                curTime+=curJob[2];
                answer+= (curTime-curJob[1]);
            }else{
                curTime=sortedJobs[indx][1];
            }
        }
        return answer / jobs.length;
    }
}