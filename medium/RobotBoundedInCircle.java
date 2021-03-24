class Solution {
  public boolean isRobotBounded(String instructions) {
    // North = {0, 1} E = {1, 0} W= {0, -1} S={-1, 0}
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int x = 0;
    int y = 0;
    int index = 0;
    for (char i : instructions.toCharArray()) {
      //if the instruction is to turn left, you need to change direction and face to West. 
      //For this, you just need to increment your direction by 3.
      //Because our North is 0, and our new direction is West, which is 3
      if (i == 'L') {
        index = (index + 3) % 4;
      } else if (i == 'R') {
        //if the instruction is to turn right, you need to change direction and face to East. 
        //For this, you just need to increment your direction by 1.
        //Remeber our North is 0, East is 1? see the commented code at the begining
        index = (index + 1) % 4;
      } else {
        x += directions[index][0];
        y += directions[index][1];
      }
    }
    return (x == 0 && y == 0) || (index != 0);
  }
}

// Time Cost: O(n)
// Space Cost: O(1)

