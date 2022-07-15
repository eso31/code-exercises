import java.util.ArrayList;
import java.util.List;

import com.domain.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode node100 = new BinaryTreeNode(100);
        BinaryTreeNode node50 = new BinaryTreeNode(50);
        BinaryTreeNode node200 = new BinaryTreeNode(200);
        BinaryTreeNode node25 = new BinaryTreeNode(25);
        BinaryTreeNode node75 = new BinaryTreeNode(75);
        BinaryTreeNode node125 = new BinaryTreeNode(125);
        BinaryTreeNode node350 = new BinaryTreeNode(350);
        BinaryTreeNode node30 = new BinaryTreeNode(30);
        BinaryTreeNode node60 = new BinaryTreeNode(60);

        node100.left = node50;
        node100.right = node200;

        node50.left = node25;
        node50.right = node75;

        node200.left = node125;
        node200.right = node350;

        node25.right = node30;

        node75.left = node60;


        BinaryTreeNode dll = ToDLL.convert_to_linked_list(node100);


        while(dll!=null) {
            System.out.println(dll.data);
            dll = dll.right;
        }
    }
}
