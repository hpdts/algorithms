package listOther;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListOtherTest {

    private ListOther listOther = new ListOther();
    private ListOther listOtherWithOther = new ListOther();
    private ListOther listCloned = new ListOther();


    @Test
    public void addingNodes() throws Exception {
        //List is LIFO - STACK Header is always at last node inserted
        listOther.add('a');
        listOther.add('b');
        listOther.add('c');
        listOther.add('d');

        assertThat(listOther.head.label, is('d'));
        assertThat(listOther.size, is(4));
    }


    @Test
    public void addingNodesAndOther() throws Exception {
        listOtherWithOther.add('a');
        listOtherWithOther.add('b');
        listOtherWithOther.add('c');
        listOtherWithOther.add('d');

        listOtherWithOther.head.other = listOtherWithOther.head.next.next;

        assertThat(listOtherWithOther.head.label, is('d'));
        assertThat(listOtherWithOther.head.other.label, is('b'));
        assertThat(listOtherWithOther.size, is(4));
    }

    @Test
    public void cloningListWithOther() throws Exception {
        listOtherWithOther.add('a');
        listOtherWithOther.add('b');
        listOtherWithOther.add('c');
        listOtherWithOther.add('d');

        listOtherWithOther.head.other = listOtherWithOther.head.next.next;

        assertThat(listOtherWithOther.head.label, is('d'));
        assertThat(listOtherWithOther.head.other.label, is('b'));
        assertThat(listOtherWithOther.size, is(4));

        assertThat(listOtherWithOther.printNodes(), is("dcba"));
        listCloned = listOtherWithOther.cloneWithOther();
        assertThat(listCloned.printNodes(), is("dcba"));
        assertThat(listCloned.head.other.label, is('b'));
    }


    @Test
    public void cloningListWithOtherInMiddle() throws Exception {
        listOtherWithOther.add('a');
        listOtherWithOther.add('b');
        listOtherWithOther.add('c');
        listOtherWithOther.add('d');

        listOtherWithOther.head.next.other = listOtherWithOther.head.next.next;

        assertThat(listOtherWithOther.head.label, is('d'));
        assertThat(listOtherWithOther.head.next.other.label, is('b'));
        assertThat(listOtherWithOther.size, is(4));

        assertThat(listOtherWithOther.printNodes(), is("dcba"));
        listCloned = listOtherWithOther.cloneWithOther();
        assertThat(listCloned.printNodes(), is("dcba"));
        assertThat(listCloned.head.next.other.label, is('b'));

        System.out.println("Other");
        assertThat(listCloned.printNodesOther(), is("dcb"));
    }

    @Test
    public void cloningNormalList() throws Exception {
        listOther.add('a');
        listOther.add('b');
        listOther.add('c');
        listOther.add('d');

        assertThat(listOther.printNodes(), is("dcba"));
        listCloned = listOther.clone();
        assertThat(listCloned.printNodes(), is("dcba"));
    }




}
