package com.chandan.interview.practice.test.practice.practice;

import java.util.Comparator;
import java.util.List;

public class CanAttendAllMeetings {
        public boolean canAttendMeetings(List<Interval> intervals) {

            intervals.sort(Comparator.comparing(i -> i.start));

            for(int i =1; i< intervals.size(); i++){
                if(intervals.get(i-1).start > intervals.get(i).end)
                    return false;
            }
        return true;
    }

}


class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }