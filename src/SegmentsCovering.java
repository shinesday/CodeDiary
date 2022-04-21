import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://medium.com/competitive/covering-segments-by-points-fc2c56c4b038
// you are given a set of closed line segments, represented as a two-dimensional integer array
// segments, Each segment: segments[i] is of the for[l,r], where l is the coordinate of its left
// endpoint and r is the coordinate of its right endpoint. Let’s say that the segment[l,r]
// contains the point x if the point is located inside the segment, ie. l <= x <= r， your task
// is to find the minimal number of points that can be placed somewhere on the number line, so
// that each segment contains at least one point. input = [[-1,3],[-5,-3],[3,5],[2,4],[-3,-2],[-1
// .4],[5,5]] the out put is 3
public class SegmentsCovering {

  /*public void minPoints2(List<List<Integer>> segments) {
    Arrays.sort(segments, (a, b) -> a[1] < b[1]);
  }*/
  static void minPoints(int[][] points, int n) {
    Arrays.sort(points, (a, b) -> a[1] - b[1]); // Sort the list of tuples by their second element.
    ArrayList<Integer> coordinates = new ArrayList<>(); // To store the solution

    int i = 0;
    while (i < n) { // Iterate over all the segments
      int seg = points[i][1];
      coordinates.add(seg);
      int p = i + 1;
      if (p >= n)
        break;

      int arrived = points[p][0]; // Get the start point of next segment
      while (seg >= arrived) {
        p += 1;
        if (p >= n)
          break;
        arrived = points[p][0];
      }
      i = p;
    }
    for(Integer point : coordinates) // Print the possibles values of M
      System.out.print(point + " ");
  }

  /*struct Segment {
    int start, end;
  };

  vector<int> optimal_points(vector<Segment> &segments) {

    // sort the vector according to the end points
    std::sort(segments.begin(), segments.end(), [](const Segment &a, const Segment &b) -> bool {
      return a.end < b.end;
    });

    vector<int> points; // create a vector to store the common points in the segments
    int point = segments[0].end; // set the point to the first end point i-e shortest end point
    points.push_back(point);

    for (size_t i = 1; i < segments.size(); ++i) {
      if (point < segments[i].start || point > segments[i].end) { // if the point is not in the segment
        point = segments[i].end; // update the point to the end point of the current segment
        points.push_back(point); // store it in the vector
      }
    }

    return points;
  }*/

  // Driver code
  public static void main(String[] args) {

    int n = 4;
    int[] start = { 4, 1, 2, 5 }; // Starting points of segments
    int[] end = { 7, 3, 5, 6 }; // Ending points of segments
    int[][] points = new int[n][2];


    for(int i = 0; i < n; i++) {// Insert ranges in points[]
      points[i][0] = start[i];
      points[i][1] = end[i];
    }
    minPoints(points, n);
  }
}

