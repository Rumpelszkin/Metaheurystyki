import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionGenerator {

    int numberOfCities;
    int captacityOfKnapsack;
    int ActualCaptacityOfKnapsack;
    ArrayList<Integer> pobranePrzedmioty;
    List<List<Integer>> listaList;
    Solution solution;

    public SolutionGenerator(Loader loader){
        this.numberOfCities = Integer.parseInt(loader.infoList.get(2).split("\t+")[1]);
        this.captacityOfKnapsack = Integer.parseInt(loader.infoList.get(4).split("\t+")[1]);;
        int numberOfItems = Integer.parseInt(loader.infoList.get(3).split("\t+")[1]);
        int ActualCaptacityOfKnapsack = 0;

        listaList = new ArrayList<>(numberOfCities);

        int[] tablica = new int[numberOfCities];
        for(int i = 0; i<numberOfCities;i++){
            tablica[i] =i;
        }
        shuffleArray(tablica);

        Random generator = new Random();
        int timer = 0;
        while(!isKnapsackFull() && timer != 50){//losuje indeks przedmiotu jak sie zmiesci to biore
           int temp = generator.nextInt(numberOfItems);
           if((captacityOfKnapsack - ActualCaptacityOfKnapsack) >= loader.itemsList.get(temp).getWeight()){
               listaList.get(loader.itemsList.get(temp).getAssignedNode()-1).add(loader.itemsList.get(temp).getIndex());

             //  System.out.println(loader.itemsList.get(temp).getIndex());
           }
           timer++;
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
         //   System.out.println((araj.toString()));
        }


    }
}
