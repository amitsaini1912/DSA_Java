import java.util.*;
public class Greedy_Algorithms {
    
    //GREEDY ALGORITHMS: ACTIVITY SELECTION PROBLEM
    public static void maxActSelection(){
        int start[] = {10,12,20};
        int end[] = {20,25,30};

        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add(activities[0][0]);
        int lastEndAct = activities[0][2];

        for (int i = 1; i < start.length; i++) {
            if (activities[i][1]>=lastEndAct){
                maxAct++;
                ans.add(activities[i][0]);
                lastEndAct = activities[i][2];
            }
        }
        System.out.println("Max Activities: "+ maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }


    //GREEDY ALGORITHMS: FRACTIONAL KNAPSACK PROBLEM
    public static void fracKnapsack(){
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 50;

        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                finalVal += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final maximum Value in knapsack: "+finalVal);
    }



    public static void main(String args[]){
        fracKnapsack();
    }
}
