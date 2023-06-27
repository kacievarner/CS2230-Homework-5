
package queries;

import net.datastructures.BinaryTree;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;


public class FamilyRecordQuery4 {

    public static void main(String[] args) throws IOException{
        Iterator<FamilyRecord> records = FamilyRecordTools.records("familyrecord.csv");

        LinkedBinaryTree<FamilyRecord> treeOfRecords = new LinkedBinaryTree<>();
        while (records.hasNext()) {
            FamilyRecord record = records.next();
            treeOfRecords.insertNode(record);
        }
        List<FamilyRecord> under50 = treeOfRecords.suchThatIterative(new underAge50(50));
        System.out.println(under50);
    }


    private static class underAge50 implements BiFunction<BinaryTree<FamilyRecord>, Position<FamilyRecord>, Boolean> {
        int ageOfPerson;
        private underAge50(int x){
            this.ageOfPerson = x;
        }
        public Boolean apply(BinaryTree<FamilyRecord> tree, Position<FamilyRecord> p) {
            return (tree.root().getElement().birthYear - p.getElement().birthYear) < ageOfPerson;
        }
    }
    
}
