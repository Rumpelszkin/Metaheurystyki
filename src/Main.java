import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    Program p = new Program();


    GeneticAlgorithm ga1 = new GeneticAlgorithm(new Population(100,p.xd),100,0.1,0.03,p.xd);
    ga1.runAlgorithm();
        GeneticAlgorithm g7a = new GeneticAlgorithm(new Population(100,p.xd),100,0.8,0.03,p.xd);
        g7a.runAlgorithm();
        GeneticAlgorithm g2a = new GeneticAlgorithm(new Population(100,p.xd),100,0.9,0.03,p.xd);
        g2a.runAlgorithm();
        GeneticAlgorithm g3a = new GeneticAlgorithm(new Population(100,p.xd),100,0.2,0.03,p.xd);
        g3a.runAlgorithm();
        GeneticAlgorithm g4a = new GeneticAlgorithm(new Population(100,p.xd),100,0.3,0.03,p.xd);
        g4a.runAlgorithm();
        GeneticAlgorithm g5a = new GeneticAlgorithm(new Population(100,p.xd),100,0.4,0.03,p.xd);
        g5a.runAlgorithm();
        GeneticAlgorithm g6a = new GeneticAlgorithm(new Population(100,p.xd),100,0.5,0.03,p.xd);
        g6a.runAlgorithm();
        GeneticAlgorithm ga6 = new GeneticAlgorithm(new Population(100,p.xd),100,0.6,0.03,p.xd);
        ga6.runAlgorithm();
        GeneticAlgorithm ga7 = new GeneticAlgorithm(new Population(100,p.xd),100,0,0,p.xd);
        ga7.runAlgorithm();
        //GeneticAlgorithm g7a = new GeneticAlgorithm(new Population(100,p.xd),100,0.8,0.03,p.xd);
        //g7a.runAlgorithm();
        GeneticAlgorithm ga11 = new GeneticAlgorithm(new Population(100,p.xd),100,1,0.00,p.xd);
        ga11.runAlgorithm();
/*/for(int i = 0; i<100; i++) {
  //  SolutionGenerator solutionGenerator= new SolutionGenerator((p.xd));
    //Solution s = solutionGenerator.generateSolution();
    //p.TTP1(s);
    Population population = new Population(100,p.xd);
    for(int xdxd = 0; xdxd<100;xdxd ++){
      //  System.out.println(population.POPULATION_SIZE);
        p.TTP1(population.population.get(xdxd));
    /*/}




}







    /*  List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        List<Integer> t3 = new ArrayList<>();
        List<Integer> t4 = new ArrayList<>();
        List<Integer> t5 = new ArrayList<>();

    t1.add(11);
        t1.add(5);
        t1.add(12);
        t1.add(13);
        t2.add(11);
        t3.add(11);
        t3.add(11);
        t3.add(11);

    s.listaList.add(t1);
        s.listaList.add(t2);
        s.listaList.add(t3);

        for(int i = 0; i<3;i++){
            if(s.hasItems(i)){
            System.out.println(s.getItems(i));
        }}
*
    }
}*/
