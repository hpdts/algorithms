package cluster;

import java.util.*;
import java.util.stream.Collectors;


public class ItemRelationShipCluster {

    private Map<String, Set<String>> clustersMap = new HashMap<>();
    
    public String readItemRelationshipCluster(String inputData) {
        Scanner scanner = new Scanner(inputData);

        double threshold = scanner.nextDouble();
        int numberOfItems = scanner.nextInt();

        while (scanner.hasNext()) {
            String itemOne = scanner.next();
            String itemTwo = scanner.next();
            double itemThreshold = scanner.nextDouble();

            if (itemThreshold > threshold) {
                System.err.println(itemOne + "," + itemTwo + "," + itemThreshold);
                addCluster(itemOne, itemTwo);

            }
        }

        List<Set<String>> clustersDistinct = clustersMap.values().stream().distinct().collect(Collectors.toList());

        Optional<Set<String>> longestCluster = clustersDistinct.stream()
                .sorted((e1, e2) -> e1.size() > e2.size() ? -1 : 1)
                .findFirst();

        Optional<String> minorElement = longestCluster.get().stream()
                .sorted(Comparator.comparing(String::toString))
                .findFirst();


        return minorElement.get();
    }



    private void addCluster(String itemOne, String itemTwo) {

        Set<String> cluster = clustersMap.containsKey(itemOne) ? clustersMap.get(itemOne) : clustersMap.containsKey(itemTwo) ? clustersMap.get(itemTwo) : new TreeSet<>();

        if (clustersMap.containsKey(itemOne)) {
            cluster.addAll(clustersMap.get(itemOne));
            cluster.add(itemTwo);
        } else if (clustersMap.containsKey(itemTwo)) {
            cluster.addAll(clustersMap.get(itemTwo));
            cluster.add(itemOne);
        } else {
            cluster.add(itemOne);
            cluster.add(itemTwo);
        }

        clustersMap.put(itemOne, cluster);
        clustersMap.put(itemTwo, cluster);

    }


}
