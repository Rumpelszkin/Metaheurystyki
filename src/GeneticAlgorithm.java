import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class GeneticAlgorithm {
    Population populationN0;
    int numberOfPopulations;
    double Px;
    double Pm;
    Loader loader;


    public GeneticAlgorithm(Population populationN0,int numer,double Px, double Pm,Loader loader){
        this.populationN0 = populationN0;
        this.loader=loader;
        this.numberOfPopulations=numer;
        this.Pm=Pm;
        this.Px=Px;
    }

    public void runAlgorithm() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("test_Px="+Px+"_Pm="+Pm+".csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Best,Worst,Average\n");
        for(int i = 0; i<numberOfPopulations;i++){
           // System.out.print(i+" ");
            sb.append(letsRoll());
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }


    public String letsRoll() throws FileNotFoundException {
        Population tempPopulation= new Population(new ArrayList<Solution>());
        boolean flag = false;
        while(!flag){
            tempPopulation.population.add(tournament(5));
            if(tempPopulation.population.size()==100){
                flag = true;
            }
        }
        flag = false;
        Random rand = new Random();
        Population tempPopulation2= new Population(new ArrayList<Solution>());
        Program p = new Program();



        for(int i = 0;i<100;i++){
            Solution s =new Solution(tempPopulation.population.get(i));
            if(rand.nextDouble() <Px){
                Solution solution =new Solution(cross(s,tournament(5)));
                mutowanko(solution);
                p.TTP1(solution);
                tempPopulation2.population.add(solution);
            }
            else {
                Solution solution = new Solution(s);
                mutowanko(solution);
                p.TTP1(solution);
                        tempPopulation2.population.add(solution);
            }

        }

        populationN0 = tempPopulation2;
        populationN0.POPULATION_SIZE = tempPopulation2.population.size();
        return tempPopulation2.ocenPopulacje();



    }
    public void mutowanko(Solution solution){
        Random random = new Random();
        int temp = 0;
        for(int i = 0; i<solution.listaList.size();i++){
            if(random.nextDouble()<=Pm){
                solution.mutuj(i);
            }
        }
    }

    private Solution fixIt(ArrayList<ArrayList<Integer>> tempList, int sliceIndex) throws FileNotFoundException {


        int ActualCaptacityOfKnapsack=0;



        ArrayList<Integer> pobranePrzedmioty;
        ArrayList<ArrayList<Integer>> listaList;


        int numberOfCities = Integer.parseInt(loader.infoList.get(2).split("\t+")[1]);
        int captacityOfKnapsack = Integer.parseInt(loader.infoList.get(4).split("\t+")[1]);;
        int numberOfItems = Integer.parseInt(loader.infoList.get(3).split("\t+")[1]);

        for(int i = sliceIndex; i<numberOfCities && !(captacityOfKnapsack<ActualCaptacityOfKnapsack);i++){
            if(tempList.get(i).size()>1){
                for(int ii = 1;ii<tempList.get(i).size();ii++) {

                    if (captacityOfKnapsack > (ActualCaptacityOfKnapsack + loader.itemsList.get(tempList.get(i).get(ii)-1).getWeight()))
                    {
                        ActualCaptacityOfKnapsack+=loader.itemsList.get(tempList.get(i).get(ii)-1).getWeight();
                    };
            }
            }
        }

        Random generator = new Random();
        int timer = 0;
        while(!(captacityOfKnapsack == ActualCaptacityOfKnapsack) && timer != 50){//losuje indeks przedmiotu jak sie zmiesci to biore
            int temp = generator.nextInt(numberOfItems);

            if((captacityOfKnapsack - ActualCaptacityOfKnapsack) >= loader.itemsList.get(temp).getWeight()){//dodac funkcje uniemozliwiajacą dodawanie tych samuch przedmiotów
                tempList.get(loader.itemsList.get(temp).getAssignedNode()-1).add(loader.itemsList.get(temp).getIndex());
                ActualCaptacityOfKnapsack+=loader.itemsList.get(temp).getWeight();
                //  System.out.println(loader.itemsList.get(temp).getIndex());
            }
            timer++;
        }
        Solution newSolution = new Solution(tempList);
        Program p = new Program();
        p.TTP1(newSolution);



        return newSolution;
    }


    private Solution cross(Solution s1, Solution s2) throws FileNotFoundException {
        Random random = new Random();

        int sliceIndex = random.nextInt(s1.listaList.size());
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<sliceIndex;i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(s1.listaList.get(i).get(0));
            tempList.add(a);
        }
        for(int i = sliceIndex;i<s2.listaList.size();i++){
            tempList.add(s2.listaList.get(i));
        }

        return fixIt(tempList,sliceIndex);
    }



    private Solution tournament(int sizeOfTournamet){
        Random rand = new Random();
        Solution[] tournamentArray = new Solution[sizeOfTournamet];
        double bestFitness = 0;
        int bestFitnessIndex =0;
        for (int i=0; i<sizeOfTournamet;i++) {
            int x = rand.nextInt(populationN0.POPULATION_SIZE);
            tournamentArray[i] = new Solution(populationN0.get(x));//deep copy
            if(bestFitness<populationN0.get(x).fitness){
                bestFitness=populationN0.get(x).fitness;
                bestFitnessIndex = i;
            }
        }
        return tournamentArray[bestFitnessIndex];

    }




}
