import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    //TODO: Substitute the testing input and output directory with your own
    private final String inputFolderPath = "/Users/bryongloden/Workspace/cs251/P3P3Distribution/Test/input/";
    private final String outputFolderPath = "/Users/bryongloden/Workspace/cs251/P3P3Distribution/Test/output/";
    private final ByteArrayOutputStream newOut = new ByteArrayOutputStream();
    private final ByteArrayOutputStream newErr = new ByteArrayOutputStream();
    private final PrintStream oldOut = System.out;
    private final PrintStream oldErr = System.err;

    @BeforeEach
    public void redirectStreams(){
        System.setOut(new PrintStream(newOut));
        System.setErr(new PrintStream(newErr));
    }


    //Test the overall output
    @Test
    public void test1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(outputFolderPath + "output1.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = br.readLine()) != null){
            sb.append(line);
            sb.append(ls);
        }
        br.close();
        String outputString = sb.toString();
        MainMinHeap.main(new String[] {inputFolderPath + "input1.txt", "200"});
        assertEquals(outputString, newOut.toString());
    }

    @Test
    public void test2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(outputFolderPath + "output2.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = br.readLine()) != null){
            sb.append(line);
            sb.append(ls);
        }
        br.close();
        String outputString = sb.toString();
        MainMinHeap.main(new String[] {inputFolderPath + "input2.txt", "100"});
        assertEquals(outputString, newOut.toString());
    }

    @Test
    public void test3() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(outputFolderPath + "output3.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = br.readLine()) != null){
            sb.append(line);
            sb.append(ls);
        }
        br.close();
        String outputString = sb.toString();
        MainMinHeap.main(new String[] {inputFolderPath + "input3.txt", "200"});
        assertEquals(outputString, newOut.toString());
    }

    @AfterEach
    public void reconvergeStreams(){
        System.setOut(oldOut);
        System.setErr(oldErr);
    }
}
