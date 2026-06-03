import java.util.*;
public class job_sequencing {
    static class Job{
        int deadline;
        int profit;
        int id; //0(A), 1(B), ...

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String args[]){
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 0; i<jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> ans = new ArrayList<>();

        int time = 0;

        for(int i = 0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                ans.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Jobs = " + ans.size());
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
