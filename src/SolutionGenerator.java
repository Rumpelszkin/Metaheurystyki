import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionGenerator {

    int numberOfCities;
    int captacityOfKnapsack;
    int ActualCaptacityOfKnapsack;
    ArrayList<Integer> pobranePrzedmioty;
    List<List<Integer>> listaList = new ArrayList<>();
    Solution solution;

    public SolutionGenerator(Loader loader){
        this.numberOfCities = Integer.parseInt(loader.infoList.get(2));
        this.captacityOfKnapsack = Integer.parseInt(loader.infoList.get(4));;
        int numberOfItems = Integer.parseInt(loader.infoList.get(3));
        int ActualCaptacityOfKnapsack = 0;

        int[] tablica = new int[numberOfCities];
        for(int i = 0; i<numberOfCities;i++){
            tablica[i] =i;
        }
        shuffleArray(tablica);

        Random generator = new Random();
        while(!isKnapsackFull()){//losujeindeks przedmiotu jak sie zmiesci to biore
           int temp = generator.nextInt(numberOfItems);
           if(ActualCaptacityOfKnapsack >= loader.itemsList.get(temp).getWeight()){
               listaList.get(loader.itemsList.get(temp).getAssignedNode()).add(loader.itemsList.get(temp).getIndex());
           }
        }
        solution = new Solution(listaList);

    }

    boolean isKnapsackFull(){
        return captacityOfKnapsack == ActualCaptacityOfKnapsack;
    }

    void shuffleArray(int[] ar)
    {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        for(int i = 0; i < ar.length;i++){
            ArrayList<Integer> araj = new ArrayList<>();
            araj.add(ar[i]);
            listaList.add(araj);

        }


    }
}
