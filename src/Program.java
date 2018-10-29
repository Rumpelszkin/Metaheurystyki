import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Program {

    Loader xd;
    double[][] distanceMatrix;
    String PROBLEM_NAME;
    String KNAPSACK_DATA_TYPE;
    int DIMENSION;
    int NUMBER_OF_ITEMS;
    int CAPACITY_OF_KNAPSACK;
    double MIN_SPEED;
    double MAX_SPEED;
    double RENTING_RATIO;
    String EDGE_WEIGHT_TYPE;

    double ACTUAL_SPEED;
    int ACTUAL_CAPACITY_OF_KNAPSACK;
    int ACTUAL_VALUE;
    double KNAPSACK_COST;

    public Program() throws FileNotFoundException {
        String location = "C:\\Users\\Max\\Desktop\\Study\\Metaheurystyki\\ttp_student\\";
        xd = new Loader(location + "easy_0.ttp");
        fillDistanceMatrix();
        PROBLEM_NAME = xd.infoList.get(0);
        KNAPSACK_DATA_TYPE = xd.infoList.get(1);
        DIMENSION = Integer.parseInt(xd.infoList.get(2).split("\t+")[1]);
        NUMBER_OF_ITEMS = Integer.parseInt(xd.infoList.get(3).split("\t+")[1]);
        CAPACITY_OF_KNAPSACK = Integer.parseInt(xd.infoList.get(4).split("\t+")[1]);
        MIN_SPEED = Double.parseDouble(xd.infoList.get(5).split("\t+")[1]);
        MAX_SPEED = Double.parseDouble(xd.infoList.get(6).split("\t+")[1]);
        RENTING_RATIO = Double.parseDouble(xd.infoList.get(7).split("\t+")[1]);
        EDGE_WEIGHT_TYPE = xd.infoList.get(8);
        ACTUAL_SPEED = MAX_SPEED;
        ACTUAL_CAPACITY_OF_KNAPSACK = CAPACITY_OF_KNAPSACK;
        ACTUAL_VALUE = 0;
        KNAPSACK_COST = 0;
    }

    public void refreshActualSpeed() {
        if (ACTUAL_CAPACITY_OF_KNAPSACK != 0)
            ACTUAL_SPEED = (ACTUAL_CAPACITY_OF_KNAPSACK / CAPACITY_OF_KNAPSACK) * MAX_SPEED;
    }


    public void TTP1(Solution solution) {
        /*  G(x,z) = g(z) - R * f(x,z)

            Fitness finesse data:
            G - value of all picked items
            R - rent per time unit price
            f - time of the tour
        */
        ACTUAL_VALUE = 0;
        KNAPSACK_COST = 0;
        ACTUAL_CAPACITY_OF_KNAPSACK = CAPACITY_OF_KNAPSACK;
        double fitness = 0;
        for (int i = 0; i < solution.listaList.size(); i++) {
            if (solution.hasItems(solution.listaList.get(i).get(0))) {
                ArrayList<Integer> lista = solution.getItems(solution.listaList.get(i).get(0));
                for (int ii = 0; ii < lista.size(); ii++) {
                    Item item = xd.itemsList.get(lista.get(ii) - 1);
                    ACTUAL_VALUE += item.profit;
                    ACTUAL_CAPACITY_OF_KNAPSACK -= item.weight;
                }
                refreshActualSpeed();
            }
            if (i != 0) {
                KNAPSACK_COST += ACTUAL_SPEED * distanceMatrix[(solution.listaList.get(i).get(0))][(solution.listaList.get(i - 1).get(0))];
            }
            solution.fitness = fitness;
            fitness = ACTUAL_VALUE - KNAPSACK_COST;
        }
        //  System.out.println("Actual fitness= "+fitness);


    }

    public void fillDistanceMatrix() {
        distanceMatrix = new double[xd.cityLocationMatrix.length][xd.cityLocationMatrix.length];
        for (int i = 0; i < xd.cityLocationMatrix.length; i++) {
            for (int i2 = i + 1; i2 < xd.cityLocationMatrix.length; i2++) {
                double x = xd.cityLocationMatrix[i][0] - xd.cityLocationMatrix[i2][0];
                double y = xd.cityLocationMatrix[i][1] - xd.cityLocationMatrix[i2][1];
                double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                distanceMatrix[i][i2] = distance;
                distanceMatrix[i2][i] = distance;
            }
        }
    }

    public void showDistanceMatrix() {
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int ii = 0; ii < distanceMatrix.length; ii++) {
                //  System.out.print(distanceMatrix[i][ii]+ "  ");
            }
            //  System.out.println();
        }
    }
}
