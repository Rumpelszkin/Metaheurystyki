import java.io.FileNotFoundException;

public class Program {

    Loader xd;
    double[][] distanceMatrix;

    public Program() throws FileNotFoundException {
        String location= "C:\\Users\\Max\\Desktop\\Study\\Metaheurystyki\\ttp_student\\";
        xd = new Loader(location +"easy_3.ttp");
        fillDistanceMatrix();

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
