package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    //implement comparator interface and specify which variable ('Finish') of user defined class should the 'compare' method work on
    // This needs to be done because, this will be needed in sort method to sort user defined object
    public static void activitySelection(ArrayList<Activity> activityList) {

        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };


        //sort all the activities by finish time variable (sort all the objects stored in ArrayList)
        Collections.sort(activityList,finishTimeComparator);
        Activity previousActicity = activityList.get(0);
        //print the 1st activity
        System.out.println("\n\n Recommended Schedule: \n"+activityList.get(0));

        for(int i=1;i<activityList.size();i++){
            Activity activity = activityList.get(i);
            if(activity.getStartTime()>=previousActicity.getFinishTime()){
                System.out.println(activity);
                previousActicity=activity;
            }
        }
    }
}
