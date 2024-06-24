/* Project 2 Comp 282 Fall 2022
   Use BinarySearchTreeDriver1.java to test your BinarySearchTree.java program.
   Put BinarySearchTreeDriver1.java in the same directory that 
   BinarySearchTree.java file is in. 
   */
  import java.util.*;
  public class BinarySearchTreeDriver1
  {
     public static void main(String[] args)
     {
         
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
           
        System.out.println("\nTEST 1");     
        int[] values = {4,7,2,9,3,5,6,2,1,8}; 
        System.out.println("insert:  4,7,2,9,3,5,6,2,1,8 " +
             "into an empty binary search tree");     
        for( int i = 0; i < values.length; i++)
           bst.insert(values[i]);
           
        bst.inOrderPrint();
        bst.preOrderPrint(); 
        System.out.println( "tree size = " + bst.size());               
        int u= 90;  
        System.out.println( u + " is in tree?   " + bst.search(u) );
        u = 7;
        System.out.println( u + " is in tree?   " + bst.search(u) );
        
        /* -----------------------------------------*/ 
        System.out.println("\nTEST 2");    
        System.out.println("insert 10 ; remove 5; remove 7"); 
        bst.insert(10);  
        int a = 5 ;     
        bst.remove(a);
        int b = 7;
        bst.remove(b);
        int c = 8;
        bst.inOrderPrint();
        bst.preOrderPrint(); 
        System.out.println( "bst size = " + bst.size());
        System.out.println( a + " is in tree?   " + bst.search(a) );
        System.out.println( b + " is in tree?   " + bst.search(b) );
        System.out.println( c + " is in tree?   " + bst.search(c) );
        
        /* -------------------------------------*/
        System.out.println("\nTEST 3");
        int d = 12;
        System.out.println("remove " + d);
        boolean result = bst.remove(d); 
        if( result == true)
        {
           bst.inOrderPrint();
           bst.preOrderPrint();
        }
        else
           System.out.println("remove was unsuccessful since " + d
               + " is not in tree");
     }
  }
  /*--------- Sample Run ----------------
  TEST 1
  insert:  4,7,2,9,3,5,6,2,1,8 into an empty binary search tree
  inOrder print: 1 2 3 4 5 6 7 8 9 
  preOrder print: 4 2 1 3 7 5 6 9 8 
  tree size = 9
  90 is in tree?   false
  7 is in tree?   true
  TEST 2
  insert 10 ; remove 5; remove 7
  inOrder print: 1 2 3 4 6 8 9 10 
  preOrder print: 4 2 1 3 8 6 9 10 
  bst size = 8
  5 is in tree?   false
  7 is in tree?   false
  8 is in tree?   true
  TEST 3
  remove 12
  remove was unsuccessful since 12 is not in tree
  */