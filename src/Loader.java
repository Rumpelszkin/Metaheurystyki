import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {





    public void load(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        List<String> list = new ArrayList<String>();


        while (input.hasNextLine()) {
            list.add(input.nextLine());
        }
        for(int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}
