package ShortestPathTESTING;

import rubikcube.RubikCube; // Class representing the Rubik's Cube
import java.util.ArrayList; // For storing child states
import java.util.Arrays; // For deep comparison of state arrays
import java.util.List; // For storing child states
import java.util.Objects; // For hashing the state

public class RubiksCubeState {
    private RubikCube rubiksCube; // Current state of the Rubik's Cube
    private int level; // Depth of the state in the search tree
    private RubiksCubeState parent; // Reference to the parent state in the search tree
    private List<RubiksCubeState> children; // List of child states generated from this state

    // **Additional attributes to represent the state of the Rubik's Cube**
    // This could be an array or data structure that captures the configuration of the cube's faces and pieces.

    public RubiksCubeState(RubikCube rubiksCube, int level, RubiksCubeState parent) {
        this.rubiksCube = rubiksCube;
        this.level = level;
        this.parent = parent;
        this.children = new ArrayList<>();

        // **Set other attributes based on rubiksCube to represent its state**
        // This could involve extracting information like face colors, piece positions, etc., from the RubikCube object.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RubiksCubeState)) return false;

        RubiksCubeState other = (RubiksCubeState) o;

        // **Compare state representations for equality**
        // This uses the `generateArray()` method of the RubikCube class to convert the cube state into a comparable format.
        List<List<Integer>> thisState = this.getRubiksCube().generateArray();
        List<List<Integer>> otherState = other.getRubiksCube().generateArray();

        return Arrays.deepEquals(thisState.toArray(), otherState.toArray());
    }

    @Override
    public int hashCode() {
        // **HashCode based on the state representation**
        // This ensures consistent hashing for equal states.
        return Objects.hash(this.getRubiksCube().generateArray());
    }

    public RubikCube getRubiksCube() {
        return rubiksCube;
    }

    public RubiksCubeState getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }

    public void addChild(RubiksCubeState child) {
        children.add(child);
    }

    public List<RubiksCubeState> getChildren() {
        return children;
    }

    public int calculateMisplacedFacelets() {
        // **Logic to count misplaced facelets**
        // This compares the current state of the cube with the solved state and counts the number of facelets that are not in their correct positions.

        int misplacedCount = 0;

        // Get the current cube state as an array
        List<List<Integer>> currentState = this.getRubiksCube().generateArray();

        // Get the solved state of the cube
        RubikCube solved = new RubikCube(3); // Assumes a constructor for size
        List<List<Integer>> solvedState = solved.generateArray(); // Assumes a method to get the solved state array

        // Iterate through each facelet and compare it with the solved state
        for (int i = 0; i < currentState.size(); i++) {
            for (int j = 0; j < currentState.get(i).size(); j++) {
                if (!currentState.get(i).get(j).equals(solvedState.get(i).get(j))) {
                    misplacedCount++; // Increment count for misplaced facelet
                }
            }
        }

        return misplacedCount;
    }
}