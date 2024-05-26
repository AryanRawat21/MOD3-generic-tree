import java.io.*;
import java.util.*;

public class CeilAndFloor {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here, ceil is smallest among larger, floor is largest among smaller
  //for ceil
    if(node.data > data){          //for bigger group      
       if(node.data < ceil){       //minimum among them 
       ceil = node.data;
   }
}

if(node.data < data){
    if(node.data > floor){
        floor = node.data;
    }
}
   
   
    for(Node child: node.children){
        ceilAndFloor(child, data);          //everyone will be visited
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;   //initialised with infinity 
    floor = Integer.MIN_VALUE;  //initialised with - infinity
    ceilAndFloor(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

}