/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
 
        ArrayList<Interval> result = new ArrayList<Interval>();
 
        for(Interval interval: intervals){
            //this interval end before new inteval start, add to result
            if(interval.end < newInterval.start){
                result.add(interval);
            }
            //this interval overlap with new interval, update new interval
            else if(interval.start <= newInterval.end && newInterval.start <= interval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
            //this interval start after new interval end, add new to result and update new inderval
            else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;        
            }
        }
 
        result.add(newInterval); 
 
        return result;
    }
}