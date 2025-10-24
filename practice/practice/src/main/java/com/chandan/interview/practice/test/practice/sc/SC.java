package com.chandan.interview.practice.test.practice.sc;


 //int[][] intervals = {{0, 8},{5, 10}, {9, 20},{12, 25}};
//[[0, 30], [5, 10], [15, 20], [25, 35]]
//


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class SC {


    public static void main(String[] args) {

        int[][] intervals = {{1,15},{3, 8},{5, 10}, {9, 20},{12, 25}};

        //i =1;

        // 0, 5, 9, 12
        // 8, 10,20,25

        // 2


        List<Meeting> meetings = Arrays.stream(intervals).map(x-> new Meeting(x[0],x[1])).collect(Collectors.toList());

        int room = getRoom(meetings);
        System.out.println(room);

        PriorityQueue<Meeting> sortedMeetings = new PriorityQueue<>(Comparator.comparing(meeting -> meeting.end));
        sortedMeetings.addAll(meetings);

        while (!sortedMeetings.isEmpty()){
            System.out.println(sortedMeetings.peek());
            sortedMeetings.poll();
        }



    }

    private static int getRoom(List<Meeting> meetings) {
        List<Integer> start = meetings.stream().map(x->x.start).toList().stream().sorted().toList();
        List<Integer> end = meetings.stream().map(x->x.end).toList().stream().sorted().toList();


        int i =1;
        int j =0;

        int room =1;

        while(i< start.size() && j< end.size()){

            if(start.get(i) < end.get(j)){
                room++;
                i++;
            }else {
                room--;
                j++;
            }

        }
        return room;
    }

}
