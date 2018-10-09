import java.io.FileNotFoundException;

public class Main {

    Loader xd;
    double[][] distanceMatrix;



    public static void main(String[] args) throws FileNotFoundException {

        String location= "C:\\Users\\Max\\Desktop\\Study\\Metaheurystyki\\ttp_student\\";
        Loader xd = new Loader(location +"easy_0.ttp");

    }

    public void fillDistanceMatrix(){
        for(int i = 0; i<xd.cityLocationMatrix.length;i++){
            for(int i2= i+1;i2<xd.cityLocationMatrix.length;i2++){
                double x = xd.cityLocationMatrix[i][0] -  xd.cityLocationMatrix[i2][0];
                double y = xd.cityLocationMatrix[i][1] -  xd.cityLocationMatrix[i2][1];
                double distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
                distanceMatrix[i][i2]= distance;
            }
        }
    }
}
