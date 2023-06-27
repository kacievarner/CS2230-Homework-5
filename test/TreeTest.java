
import java.util.List;
import java.util.function.BiFunction;

import javafx.geometry.Pos;
import net.datastructures.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {

	public TreeTest() {
	}

	@Test
	public void testInsertionAndtoArray() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Object[] actual = AbstractTree.toList(bt.breadthfirst()).toArray();
		Object[] expected = {50, 2, 34, 19, 6, 22};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testInsertionAndtoArray2() {
		LinkedBinaryTree<String> bt = new LinkedBinaryTree<>();
		bt.insertNode("a");
		bt.insertNode("b");
		bt.insertNode("c");
		bt.insertNode("d");
		bt.insertNode("e");
		bt.insertNode("f");
		Object[] actual = AbstractTree.toList(bt.breadthfirst()).toArray();
		Object[] expected = {"a", "b", "c", "d", "e", "f"};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void sumAtDepthTest1() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Integer sum = TreeFunctions.sumAtDepthIterative(bt, 2);
		assertEquals(Integer.valueOf(47), sum);
		// Student: try at different depths!!
	}

	@Test
	public void sumAtDepthTest2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Integer sum = TreeFunctions.sumAtDepthRecursive(bt, 2);
		assertEquals(Integer.valueOf(47), sum);
		// Student: try at different depths!!
	}

	@Test
	public void sumAtDepthTreeWithHolesTest1() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(50);
		Position<Integer> right = bt.addRight(root, 2);
		Position<Integer> rightRight = bt.addRight(right, 34);
		Position<Integer> rightRightLeft = bt.addLeft(rightRight, 10);
		Position<Integer> rightLeft = bt.addLeft(right, 100);
		Position<Integer> rightLeftLeft = bt.addLeft(rightLeft, 16);
		Position<Integer> rightLeftLeftLeft = bt.addLeft(rightLeftLeft, 71);
		Position<Integer> rightLeftRight = bt.addRight(rightLeft, 77);
		Position<Integer> rightLeftRightRight = bt.addRight(rightLeftRight, 13);
		Position<Integer> left = bt.addLeft(root, 44);
		Position<Integer> leftLeft = bt.addLeft(left, 300);
		Integer sum = TreeFunctions.sumAtDepthIterative(bt, 2);
		assertEquals(Integer.valueOf(434), sum);
		// Student: try at different depths!!
	}

	@Test
	public void sumAtDepthTreeWithHolesTest2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(50);
		Position<Integer> right = bt.addRight(root, 2);
		Position<Integer> rightRight = bt.addRight(right, 34);
		Position<Integer> rightRightLeft = bt.addLeft(rightRight, 10);
		Position<Integer> rightLeft = bt.addLeft(right, 100);
		Position<Integer> rightLeftLeft = bt.addLeft(rightLeft, 16);
		Position<Integer> rightLeftLeftLeft = bt.addLeft(rightLeftLeft, 71);
		Position<Integer> rightLeftRight = bt.addRight(rightLeft, 77);
		Position<Integer> rightLeftRightRight = bt.addRight(rightLeftRight, 13);
		Position<Integer> left = bt.addLeft(root, 44);
		Position<Integer> leftLeft = bt.addLeft(left, 300);
		Integer sum = TreeFunctions.sumAtDepthRecursive(bt, 2);
		assertEquals(Integer.valueOf(434), sum);
		// Student: try at different depths!!
	}

	@Test
	public void reduceAtDepthTest1() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		int sum = bt.reduceAtDepthIterative(2, new IntegerSum(), 0);
		assertEquals(47, sum);
		// Student: try at different depths!!
	}

	@Test
	public void reduceAtDepthTest2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		int sum = bt.reduceAtDepthRecursive(2, new IntegerSum(), 0);
		assertEquals(47, sum);
		// Student: try at different depths!!
	}

	@Test
	public void reduceAtDepthTreeWithHolesTest1() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(50);
		Position<Integer> right = bt.addRight(root, 2);
		Position<Integer> rightRight = bt.addRight(right, 34);
		Position<Integer> rightRightLeft = bt.addLeft(rightRight, 10);
		Position<Integer> rightLeft = bt.addLeft(right, 100);
		Position<Integer> rightLeftLeft = bt.addLeft(rightLeft, 16);
		Position<Integer> rightLeftLeftLeft = bt.addLeft(rightLeftLeft, 71);
		Position<Integer> rightLeftRight = bt.addRight(rightLeft, 77);
		Position<Integer> rightLeftRightRight = bt.addRight(rightLeftRight, 13);
		Position<Integer> left = bt.addLeft(root, 44);
		Position<Integer> leftLeft = bt.addLeft(left, 300);
		Integer sum = bt.reduceAtDepthIterative(2, new IntegerSum(), 0);
		assertEquals(Integer.valueOf(434), sum);
		// Student: try at different depths!!
	}

	@Test
	public void reduceAtDepthTreeWithHolesTest2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(50);
		Position<Integer> right = bt.addRight(root, 2);
		Position<Integer> rightRight = bt.addRight(right, 34);
		Position<Integer> rightRightLeft = bt.addLeft(rightRight, 10);
		Position<Integer> rightLeft = bt.addLeft(right, 100);
		Position<Integer> rightLeftLeft = bt.addLeft(rightLeft, 16);
		Position<Integer> rightLeftLeftLeft = bt.addLeft(rightLeftLeft, 71);
		Position<Integer> rightLeftRight = bt.addRight(rightLeft, 77);
		Position<Integer> rightLeftRightRight = bt.addRight(rightLeftRight, 13);
		Position<Integer> left = bt.addLeft(root, 44);
		Position<Integer> leftLeft = bt.addLeft(left, 300);
		Integer sum = bt.reduceAtDepthRecursive(2, new IntegerSum(), 0);
		assertEquals(Integer.valueOf(434), sum);
		// Student: try at different depths!!
	}

	@Test
	public void suchThatIterativeTest() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Integer[] expected = {50, 2};
		List<Integer> answers = bt.suchThatIterative(new HasTwoChildren());
		assertArrayEquals(expected, answers.toArray());
	}

	@Test
	public void suchThatIterativeTreeWithHolesTest() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(50);
		Position<Integer> right = bt.addRight(root, 2);
		Position<Integer> rightRight = bt.addRight(right, 34);
		Position<Integer> rightRightLeft = bt.addLeft(rightRight, 10);
		Position<Integer> rightLeft = bt.addLeft(right, 100);
		Position<Integer> rightLeftLeft = bt.addLeft(rightLeft, 16);
		Position<Integer> rightLeftLeftLeft = bt.addLeft(rightLeftLeft, 71);
		Position<Integer> rightLeftRight = bt.addRight(rightLeft, 77);
		Position<Integer> rightLeftRightRight = bt.addRight(rightLeftRight, 13);
		Position<Integer> left = bt.addLeft(root, 44);
		Position<Integer> leftLeft = bt.addLeft(left, 300);
		Integer[] expected = {50, 2, 100};
		List<Integer> answers = bt.suchThatIterative(new HasTwoChildren());
		assertArrayEquals(expected, answers.toArray());
	}


	// Example implementation of BiFunction used by the given test
	private static class IntegerSum implements BiFunction<Integer, Integer, Integer> {
		@Override
		public Integer apply(Integer soFar, Integer x) {
			return soFar + x;
		}
	}

	// Example implementation of BiFunction used by the given test
	private static class HasTwoChildren implements BiFunction<BinaryTree<Integer>, Position<Integer>, Boolean> {
		@Override
		public Boolean apply(BinaryTree<Integer> t, Position<Integer> p) {
			return t.numChildren(p) == 2;
		}
	}

		/* The staff will run your code on several additional JUnit tests of our own.
		   You must write additional tests below to provide more evidence that your
		   method implementations are correct. 
		
		   This test code is part of the assignment, just like the other code.

		   If you write a new test and it fails, GREAT! That means you are making
		   progress. Either the test is wrong and you just need to fix it, or it means you found
		   a bug in your LinkedBinaryTree code and now you can go fix it. Don't remove good tests just
		   because they fail.
		 */

	// write your new tests below here, using the @Test methods above as an example.
	// PART 3: testing
	@Test
	public void extraReduce1() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		int sum = bt.reduceAtDepthIterative(2, new IntegerSum(), 0);
		assertEquals(0, sum);
	}

	@Test
	public void extraReduce2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		int sum = bt.reduceAtDepthRecursive(2, new IntegerSum(), 0);
		assertEquals(0, sum);
	}
	@Test
	public void extraReduce3() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(75);
		int sum = bt.reduceAtDepthIterative(0, new IntegerSum(), 0);
		assertEquals(75, sum);
	}

	@Test
	public void extraReduce4() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(100);
		int sum = bt.reduceAtDepthRecursive(0, new IntegerSum(), 0);
		assertEquals(100, sum);
	}

	@Test
	public void extraReduceDM() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(75);
		int sum = bt.reduceAtDepthIterative(0, new IntegerSum(), 0);
		assertEquals(75, sum);
	}

	@Test
	public void extraReduceDMR() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(100);
		int sum = bt.reduceAtDepthRecursive(0, new IntegerSum(), 0);
		assertEquals(100, sum);
	}

	@Test
	//Different Tree Shape
	public void newShapeRecursive() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(100);
		Position<Integer> right = bt.addRight(root, 290);
		Position<Integer> rightRight = bt.addRight(right, 48);
		Position<Integer> moreRight = bt.addRight(rightRight, 22);
		Position<Integer> moreMoreRight = bt.addRight(moreRight, 17);
		int sum = bt.reduceAtDepthRecursive(4, new IntegerSum(), 0);
		assertEquals(17, sum);
	}

	@Test
	public void newShapeIterative() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Position<Integer> root = bt.addRoot(100);
		Position<Integer> right = bt.addRight(root, 290);
		Position<Integer> rightRight = bt.addRight(right, 48);
		Position<Integer> moreRight = bt.addRight(rightRight, 22);
		Position<Integer> moreMoreRight = bt.addRight(moreRight, 17);
		int sum = bt.reduceAtDepthIterative(4, new IntegerSum(), 0);
		assertEquals(17, sum);
	}

	@Test
	public void reduceAtDepthTestDoubleMaxRec() {
		LinkedBinaryTree<Double> bt = new LinkedBinaryTree<>();
		bt.insertNode(50.0);
		bt.insertNode(2.0);
		bt.insertNode(34.0);
		bt.insertNode(19.0);
		bt.insertNode(6.0);
		bt.insertNode(22.0);
		Double sum = bt.reduceAtDepthRecursive(2, new DoubleMax(), 0.0);
		assertEquals(Double.valueOf(22.0), sum);
	}

	@Test
	public void reduceAtDepthTestDoubleMaxIt() {
		LinkedBinaryTree<Double> bt = new LinkedBinaryTree<>();
		bt.insertNode(50.0);
		bt.insertNode(2.0);
		bt.insertNode(34.0);
		bt.insertNode(19.0);
		bt.insertNode(6.0);
		bt.insertNode(22.0);
		Double sum = bt.reduceAtDepthIterative(2, new DoubleMax(), 0.0);
		assertEquals(Double.valueOf(22.0), sum);
	}

	// PART 5: testing
	@Test
	public void suchItChildren() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Integer[] expected = {};
		List<Integer> exp = bt.suchThatIterative(new HasTwoChildren());
		assertArrayEquals(expected, exp.toArray());
	}

	@Test
	public void suchRecChildren() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		Integer[] expected = {};
		List<Integer> exp = bt.suchThatRecursive(new HasTwoChildren());
		assertArrayEquals(expected, exp.toArray());
	}
	@Test
	public void suchItChildren2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		Integer[] expected = {};
		List<Integer> exp = bt.suchThatIterative(new HasTwoChildren());
		assertArrayEquals(expected, exp.toArray());
	}
	@Test
	public void suchRecChildren2() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		Integer[] expected = {};
		List<Integer> exp = bt.suchThatRecursive(new HasTwoChildren());
		assertArrayEquals(expected, exp.toArray());
	}

	@Test
	public void suchRecEven() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Integer[] expected = {50, 2, 6, 34, 22};
		List<Integer> exp = bt.suchThatRecursive(new IsEven());
		assertArrayEquals(expected, exp.toArray());
	}

	@Test
	public void suchItEven() {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
		bt.insertNode(50);
		bt.insertNode(2);
		bt.insertNode(34);
		bt.insertNode(19);
		bt.insertNode(6);
		bt.insertNode(22);
		Integer[] expected = {50, 34, 22, 2, 6};
		List<Integer> exp = bt.suchThatIterative(new IsEven());
		assertArrayEquals(expected, exp.toArray());
	}

	@Test
	public void suchRecInOrder() {
		LinkedBinaryTree<String> bt = new LinkedBinaryTree<>();
		bt.insertNode("Hi");
		bt.insertNode("Hello");
		bt.insertNode("Bonjour");
		bt.insertNode("Salut");
		bt.insertNode("Hola");
		bt.insertNode("Caio");
		String[] expected = {"Salut", "Hola", "Caio"};
		List<String> exp = bt.suchThatRecursive(new InOrder());
		assertArrayEquals(expected, exp.toArray());
	}

	@Test
	public void suchItInOrder() {
		LinkedBinaryTree<String> bt = new LinkedBinaryTree<>();
		bt.insertNode("Hi");
		bt.insertNode("Hello");
		bt.insertNode("Bonjour");
		bt.insertNode("Salut");
		bt.insertNode("Hola");
		bt.insertNode("Caio");
		String[] expected = {"Caio", "Hola", "Salut"};
		List<String> exp = bt.suchThatIterative(new InOrder());
		assertArrayEquals(expected, exp.toArray());
	}

	// you must use this BiFunction in tests that you write for reduceAtDepth/reduceAtDepthIterative (PART 3)
	private static class DoubleMax implements BiFunction<Double, Double, Double> {
		@Override
		public Double apply(Double soFar, Double x) {
			return Math.max(soFar, x);
		}
	}

	// you must use this BiFunction in tests that you write for suchThatRecursive/suchThatIterative (PART 5)
	private static class InOrder implements BiFunction<BinaryTree<String>, Position<String>, Boolean> {
		@Override
		public Boolean apply(BinaryTree<String> t, Position<String> p) {
			Position<String> l = t.left(p);
			Position<String> r = t.right(p);
			if (l != null && l.getElement().compareTo(p.getElement()) > 0)
				return false;
			else if (r != null && r.getElement().compareTo(p.getElement()) < 0)
				return false;
			else
				return true;
		}
	}

	// you must use this BiFunction in tests that you write for suchThatRecursive/suchThatIterative (PART 5)
	private static class IsEven implements BiFunction<BinaryTree<Integer>, Position<Integer>, Boolean> {
		@Override
		public Boolean apply(BinaryTree<Integer> t, Position<Integer> p) {
		    return p.getElement() % 2 == 0;
		}
	}
}
