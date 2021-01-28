
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void dataIsRetained() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int expected = 4;
        binarySearchTree.insert(expected);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);

        int actual = root.getData();
        assertEquals(expected, actual);
    }

    @Test
    public void insertsLess() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        char expectedRoot = '4';
        char expectedLeft = '2';

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<Character> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Character> left = root.getLeft();
        assertNotNull(left);

        char actualRoot = root.getData();
        char actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void insertsSame() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        String expectedRoot = "4";
        String expectedLeft = "4";

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<String> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<String> left = root.getLeft();
        assertNotNull(left);

        String actualRoot = root.getData();
        String actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void insertsRight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Integer> right = root.getRight();
        assertNotNull(right);

        int actualRoot = root.getData();
        int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void createsSimpleTripleLevelledTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRightOfRoot = 5;
        int expectedLeftOfRoot = 2;
        int expectedRightOf2 = 3;
        int expectedRightOf5 = 6;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRightOfRoot);
        binarySearchTree.insert(expectedLeftOfRoot);
        binarySearchTree.insert(expectedRightOf2);
        binarySearchTree.insert(expectedRightOf5);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Integer> right = root.getRight();
        assertNotNull(right);
        BinarySearchTree.Node<Integer> left = root.getLeft();
        assertNotNull(left);
        BinarySearchTree.Node<Integer> rightOfRight = root.getRight().getRight();
        assertNotNull(rightOfRight);
        BinarySearchTree.Node<Integer> rightOfLeft = root.getLeft().getRight();
        assertNotNull(rightOfLeft);

        int actualRoot = root.getData();
        int actualRight = right.getData();
        int actualLeft = left.getData();
        int actualRightOfRight = rightOfRight.getData();
        int actualRightOfLeft = rightOfLeft.getData();
        assertEquals(expectedRightOfRoot, actualRight);
        assertEquals(expectedRoot, actualRoot);
        assertEquals(expectedLeftOfRoot, actualLeft);
        assertEquals(expectedRightOf5, actualRightOfRight);
        assertEquals(expectedRightOf2, actualRightOfLeft);
    }

    @Test
    public void canCreateLevelOrderedListForSmallTrees(){
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6')
        );
        List<Character> treeData = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6')
        );
        treeData.forEach(binarySearchTree::insert);
        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    @Test
    public void createsComplexTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );

        List<Character> treeData = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );
        treeData.forEach(binarySearchTree::insert);

        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsSingleElement() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.unmodifiableList(
                Collections.singletonList("2")
        );

        binarySearchTree.insert("2");

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(1, 2)
        );

        binarySearchTree.insert(2);
        binarySearchTree.insert(1);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondNumberisSameAsFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('2', '2')
        );

        binarySearchTree.insert('2');
        binarySearchTree.insert('2');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('2', '3')
        );

        binarySearchTree.insert('2');
        binarySearchTree.insert('3');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void iteratesOverComplexTree() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.unmodifiableList(
                Arrays.asList("1", "2", "3", "5", "6", "7")
        );

        List<String> treeData = Collections.unmodifiableList(
                Arrays.asList("2", "1", "3", "6", "7", "5")
        );
        treeData.forEach(binarySearchTree::insert);

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }
}
