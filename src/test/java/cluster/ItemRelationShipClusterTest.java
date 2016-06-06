package cluster;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ItemRelationShipClusterTest {

    private ItemRelationShipCluster itemRelationShipCluster = new ItemRelationShipCluster();

    @Before
    public void setUp(){
        itemRelationShipCluster.clusters = new ArrayList<>();
    }

    @Test
    public void testReadItemRelationshipCluster() throws Exception {
        String firstItemLargerCluster = itemRelationShipCluster.readItemRelationshipCluster("0.15\n" +
                "4\n" +
                "Item1 Item2 0.2\n" +
                "Item2 Item3 0.1\n" +
                "Item4 Item5 0.3\n" +
                "Item5 Item6 0.4");

        assertThat("Item4", is(firstItemLargerCluster));
    }

    @Test
    public void itemAffinityDifferentOrder() throws Exception {
        String firstItemLargerCluster = itemRelationShipCluster.readItemRelationshipCluster("0.15\n" +
                "4\n" +
                "Item2 Item1 0.2\n" +
                "Item5 Item4 0.3\n" +
                "Item8 Item1 0.4");

        assertThat("Item1", is(firstItemLargerCluster));
    }

    @Test
    public void itemClusterLarger() throws Exception {
        String firstItemLargerCluster = itemRelationShipCluster.readItemRelationshipCluster("0.15\n" +
                "4\n" +
                "Item2 Item1 0.2\n" +
                "Item5 Item4 0.3\n" +
                "Item2 Item23 0.3\n" +
                "Item10 Item56 0.3\n" +
                "Item5 Item10 0.45\n" +
                "Item8 Item1 0.4");

        assertThat("Item1", is(firstItemLargerCluster));
    }
}