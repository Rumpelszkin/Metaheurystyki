import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    //Program p = new Program();

    Solution s = new Solution();
    List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        List<Integer> t3 = new ArrayList<>();
        List<Integer> t4 = new ArrayList<>();
        List<Integer> t5 = new ArrayList<>();

    t1.add(11);
        t1.add(5);
        t1.add(12);
        t1.add(13);
        t2.add(11);
        t3.add(11);
        t3.add(11);
        t3.add(11);

    s.listaList.add(t1);
        s.listaList.add(t2);
        s.listaList.add(t3);

        for(int i = 0; i<3;i++){
            if(s.hasItems(i)){
            System.out.println(s.getItems(i));
        }}

    }
}
