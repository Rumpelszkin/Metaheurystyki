import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {

List<List<Integer>> listaList = new ArrayList<>();

public Solution(){};
public Solution(List<List<Integer>> lista){
    listaList= lista;
}


public boolean hasItems(int index){
    return listaList.get(index).size() != 1;
}

public ArrayList<Integer> getItems(int index){

    ArrayList<Integer> itemsStolenFromCity = new ArrayList<>();
    for(int i = 1; i<listaList.get(index).size();i++ ){
        itemsStolenFromCity.add(listaList.get(index).get(i));
    }
    return itemsStolenFromCity;
}




/*
public int getBackpackValue(){

    List<Integer> listaItemkow = new ArrayList<Integer>;

    for(int i = 0; i <listaList.size();i++){
        listaItemkow.(getItems(i));
    }
}*/

}
