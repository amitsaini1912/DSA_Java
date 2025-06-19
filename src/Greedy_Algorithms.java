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


    public static void main(String args[]){
        maxActSelection();
    }
}
