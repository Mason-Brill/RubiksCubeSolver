//  This code solves a Rubiks Cube by using a front tree
//  and a back tree using a bi-directional search until a
//  the nodes of each tree match and then will solve the
//  cube and return the steps required to un-randomize the cube
//
//  I cannot thank Troy enough for helping me develop this program
//  Mason Brill, Kadeem Jonas

package ShortestPathTESTING;

public class main {

    public static void main(String[] args) {
        // **Specify limits**
        // - limitHash: Maximum depth for the hashing process
        // - limitBFS: Maximum depth for the BFS exploration
        int limitHash = 5;
        int limitBFS = 5;

        // **Show information about available processors**
        // This is useful for understanding the potential parallelism
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors/cores: " + availableProcessors);

        // **Run the test with the BackTree class**
        // - backTest: Instance of the BackTree class responsible for the search
        // - solvedNode: The initial node representing the solved state of the Rubik's Cube
        // - limitHash+1: Effective limit for parallel DFS due to offset
        // - 16: Number of threads to use for parallel processing
        BackTree backTest = new BackTree(limitBFS, limitHash);
        backTest.parallelDFSTraversal(backTest.solvedNode, limitHash + 1, 16);
    }
}
