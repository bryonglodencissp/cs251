import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainMinHeap {
    public static void main(String[] args) {
        if(args.length < 2)
            return;
        String filename = args[0];
        int m = Integer.parseInt(args[1]);

        MinHeap lbs = new MinHeap(m);
        if (lbs == null)
            System.out.println("new lbs fails");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(" ");
                if(split.length == 2) {
                    Score s = new Score(split[0], Integer.parseInt(split[1]));
                    lbs.insert(s);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lbs);
    }

}