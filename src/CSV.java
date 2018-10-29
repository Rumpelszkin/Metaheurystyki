import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSV {
    PrintWriter pw;
    StringBuilder sb;
    public CSV() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
    };


    public void add(String string){
        sb.append(string);
    }





        public void close(){
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");}
}
