import java.util.ArrayList;
import java.util.List;

public class Population {
    int POPULATION_SIZE;
    ArrayList<Solution> population;
    int bestIndex;
    int worstIndex;
    double average;
    double bestFitness = 0;
    double worstFitness = 1000;
    double sum = 0;


    public Population(int rozmiar, Loader loader) {
        population = new ArrayList<Solution>(rozmiar);
        POPULATION_SIZE = rozmiar;
        generate(loader);

    }

    public Population(ArrayList<Solution> populacja) {
        this.population = populacja;
        POPULATION_SIZE = populacja.size();

    }

    public Population(Population p) {//deep copy
        this(p.getPopulation());
    }


    public ArrayList<Solution> getPopulation() {
        return population;
    }

    public Solution get(int index) {
        return population.get(index);
    }

    private void generate(Loader loader) {
        SolutionGenerator solutionGenerator = new SolutionGenerator(loader);
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Solution s = solutionGenerator.generateSolution();
            population.add(s);
        }
    }

    public String ocenPopulacje() {

        bestFitness = 0;
        worstFitness = 10000000;
        sum = 0;

        for (int i = 0; i < population.size(); i++) {
            sum += population.get(i).fitness;
            if (bestFitness < population.get(i).fitness) {
                bestFitness = population.get(i).fitness;
                bestIndex = i;
            }
            if (worstFitness > population.get(i).fitness) {
                worstFitness = population.get(i).fitness;
                worstIndex = i;
            }
        }
        average = sum / population.size();

        return bestFitness + "," + worstFitness + "," + average + '\n';
    }


}
