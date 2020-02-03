# mars-robot-task
A robot lands on Mars, which happens to be a cartesian grid; assuming that we hand the robot these instructions, such as LFFFRFFFRRFFF, where "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right", and "F" is "go forward one space, please write control code for the robot such that it ends up at the appropriate-and-correct destination

# Starting info
Robot requires to have known facing direction when starting. These can be NORTH, EAST, SOUTH or WEST.

Robot always starts at [0,0] coordination.

Feel free to extend the provided robot with custom implementation and add extra behaviour.

### Navigating the robot
Robot supports 3 commands:
* F - Forward
* R - Turn right 90 degrees
* L - Turn left 90 degrees

To move the robot use the provided `move()` method and provide the desired navigation commands.

Commands can be chained. Example: `robot.move(FLRLFLRLRFFFLRLFR)`

### Navigating commands validation
Before actually executing any navigation commands, roboto will validate if the input is correct. If it is, it will
execute the command. If it isn't it will report an error.

# Tests
Use the standard `test` task from gradle to run all tests.