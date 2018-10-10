import java.io.FileNotFoundException;

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


    public Program() throws FileNotFoundException {
        String location= "C:\\Users\\Max\\Desktop\\Study\\Metaheurystyki\\ttp_student\\";
        xd = new Loader(location +"medium_3.ttp");
        fillDistanceMatrix();
        PROBLEM_NAME = xd.infoList.get(0);
        KNAPSACK_DATA_TYPE= xd.infoList.get(1);
        DIMENSION = Integer.parseInt(xd.infoList.get(2));
        NUMBER_OF_ITEMS = Integer.parseInt(xd.infoList.get(3));
        CAPACITY_OF_KNAPSACK= Integer.parseInt(xd.infoList.get(4));
        MIN_SPEED = Double.parseDouble(xd.infoList.get(5));
        MAX_SPEED = 	Double.parseDouble(xd.infoList.get(6));
        RENTING_RATIO= Double.parseDouble(xd.infoList.get(7));
        EDGE_WEIGHT_TYPE =	xd.infoList.get(8);


    }


    public void TTP1(Solution solution){
        /*  G(x,z) = g(z) - R * f(x,z)

            Fitness finesse data:
            G - value of all picked items
            R - rent per time unit price
            f - time of the tour
        */



        for(int i = 0; i < solution.listaList.size();i++){


        }




    }

    public void fillDistanceMatrix(){
        distanceMatrix = new double[xd.cityLocationMatrix.length][xd.cityLocationMatrix.length];
        for(int i = 0; i<xd.cityLocationMatrix.length;i++){
            for(int i2= i+1;i2<xd.cityLocationMatrix.length;i2++){
                double x = xd.cityLocationMatrix[i][0] -  xd.cityLocationMatrix[i2][0];
                double y = xd.cityLocationMatrix[i][1] -  xd.cityLocationMatrix[i2][1];
                double distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
                distanceMatrix[i][i2]= distance;
                distanceMatrix[i2][i]= distance;
            }
        }
    }

    public void showDistanceMatrix(){
        for(int i = 0; i<distanceMatrix.length;i++)
        {
            for (int ii = 0;ii<distanceMatrix.length;ii++){
                System.out.print(distanceMatrix[i][ii]+ "  ");
            }
            System.out.println();
        }
    }
}
