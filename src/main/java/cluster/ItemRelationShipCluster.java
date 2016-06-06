package cluster;

import java.util.*;
import java.util.stream.Collectors;


public class ItemRelationShipCluster {

    List<List<String>> clusters = new ArrayList<>();


    public String readItemRelationshipCluster(String inputData) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(inputData);

        double threshold = scanner.nextDouble();
        int numberOfItems = scanner.nextInt();

        while(scanner.hasNext()){
            String itemOne = scanner.next();
            String itemTwo = scanner.next();
            double itemThreshold = scanner.nextDouble();

            if(itemThreshold > threshold){
                System.err.println(itemOne + "," + itemTwo + "," + itemThreshold);
                addCluster(itemOne, itemTwo);

            }
        }
        Comparator<List<String>> compareBySize = (aName, bName) -> bName.size() - aName.size();
        clusters = clusters.stream().sorted(compareBySize).collect(Collectors.toList());

        List<String> largerCluster = clusters.get(0);
        Collections.sort(clusters.get(0));

        return largerCluster.get(0);
    }

    private void addCluster(String itemOne, String itemTwo) {

        for(List<String> cluster : clusters){
            if(cluster.contains(itemOne)){
                cluster.add(itemTwo);
                return;
            }else if (cluster.contains(itemTwo)){
                cluster.add(itemOne);
                return;
            }
        }

        List<String> cluster = new ArrayList<>();
        cluster.add(itemOne);
        cluster.add(itemTwo);

        clusters.add(cluster);

    }
}
