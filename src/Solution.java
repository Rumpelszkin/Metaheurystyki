import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    ArrayList<ArrayList<Integer>> listaList = new ArrayList<>();
    double fitness;

    public Solution() {
    }

    ;

    public Solution(Solution s) {
        this(s.listaList);
    }

    ;

    public Solution(ArrayList<ArrayList<Integer>> lista) {
        listaList = lista;
        fitness = 0;
    }


    public boolean hasItems(int index) {
        return listaList.get(index).size() != 1;
    }

    public ArrayList<Integer> getItems(int index) {

        ArrayList<Integer> itemsStolenFromCity = new ArrayList<>();
        for (int i = 1; i < listaList.get(index).size(); i++) {
            itemsStolenFromCity.add(listaList.get(index).get(i));
        }
        return itemsStolenFromCity;
    }


    public void mutuj(int index) {

        Random random = new Random();
        int i = random.nextInt(listaList.size());
        while (i == index) {
            i = random.nextInt(listaList.size());
        }
        ArrayList<Integer> temp = listaList.get(index);
        listaList.set(index, listaList.get(i));
        listaList.set(i, temp);
    }
/*
public int getBackpackValue(){

    List<Integer> listaItemkow = new ArrayList<Integer>;

    for(int i = 0; i <listaList.size();i++){
        listaItemkow.(getItems(i));
    }
}*/

}
