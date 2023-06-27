package net.datastructures;


public class TreeFunctions {

  /* Returns the result of summing all elements at the given depth
  NOTE: must use recursion, no looping
   */
    public static Integer sumAtDepthRecursive(BinaryTree<Integer> tree, int depth) {
        int sum = 0;
        if (tree.isEmpty()) {
            return sum;
        }
        LinkedQueue<Position<Integer>> Queue = new LinkedQueue<>();
        Queue.enqueue(tree.root());
        while (!Queue.isEmpty()) {
            if (tree.left(Queue.first()) != null){
                Queue.enqueue(tree.left(Queue.first()));
            }
            if (tree.right(Queue.first()) != null) {
                Queue.enqueue(tree.right(Queue.first()));
            }
            int curDepth = 0;
            Position<Integer> currentParent = Queue.first();
            while (tree.parent(currentParent) != null){
                curDepth += 1;
                currentParent = tree.parent(currentParent);
            }
            if (curDepth == depth){
                sum += Queue.first().getElement();
            }
            if (curDepth > depth){
                break;
            }
            Queue.dequeue();
        }
        return sum;
    }

    /* Returns the result of summing all elements at the given depth
    NOTE: must use looping, no recursion
     */

    public static Integer sumAtDepthIterative(BinaryTree<Integer> tree, int depth) {
        int sum = 0;
        if (tree.isEmpty()) {
            return sum;
        }
        LinkedQueue<Position<Integer>> Queue = new LinkedQueue<>();
        Queue.enqueue(tree.root());
        while (!Queue.isEmpty()) {
            if (tree.left(Queue.first()) != null){
                Queue.enqueue(tree.left(Queue.first()));
            }
            if (tree.right(Queue.first()) != null) {
                Queue.enqueue(tree.right(Queue.first()));
            }
            int curDepth = 0;
            Position<Integer> currentParent = Queue.first();
            while (tree.parent(currentParent) != null){
                curDepth += 1;
                currentParent = tree.parent(currentParent);
            }
            if (curDepth == depth){
                //System.out.println(Queue.first().getElement());
                sum += Queue.first().getElement();
            }
            if (curDepth > depth){
                break;
            }
            Queue.dequeue();
        }
        return sum;
    }
}
