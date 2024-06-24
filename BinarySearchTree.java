/*Project 2                                    Comp 282 Fall 2022
BinarySearchTreeOutlineProj2
Uses generic type E for data in nodes. E must implement Comparable 
Put both classes in same file called BinarySearchTree.java
*/

class BinaryNode<E>
{
   E data;
   BinaryNode<E> left;
   BinaryNode<E> right;
   BinaryNode<E> parent;  //added for convenience
   
   public BinaryNode( E x) {  
    data = x;
    left = null;
    right = null;
    parent = null;
    //Set data to x and BinaryNodes to null
 }
   
   public BinaryNode( E x, BinaryNode<E> left, BinaryNode<E> right, BinaryNode<E> parent)
   {  /*Set data to x and left, right and parent pointers to parameters 
      Use this.left = left  to set left field to left parameter */
      this.data = x;
      this.right = right;
      this.left = left;
      this.parent = parent;
   }  
   
   public String toString() { 
    return "" + data;
 } //done

 } //end BinaryNode class 

 
      
 /* ---------------------------------------------------*/
public class BinarySearchTree<E extends Comparable<E>>
{  
   private BinaryNode<E> root;
   private int size;   //Number of nodes in tree
  
   public BinarySearchTree() { /* set root to null and size to 0 */
    root = null;
    size = 0;

   }
   /*---------------- public methods--------------------*/
  
   public int size() { 
    return size;
   }
   
   
   public boolean isEmpty() { 
    return root == null;
   } 
     
   public boolean search( E x)
   { /* Use algorithm on power point slides or use private 
        method find(x,root). Return true if search is successful 
        else return false */
     BinaryNode<E> p;
        if (root ==null) 
            return false;
        p = root;
        while (p != null)
        {
        if (x.compareTo(p.data) < 0)
        p = p.left;
        else if (x.compareTo(p.data) > 0)                            
        p = p.right;
        else
        return true;
        }
        return false;
    }
   
   
  public void preOrderPrint()  //done
   {
      System.out.print("preOrder print: ");
      preOrder (root);
      System.out.println();
   }


   public void inOrderPrint()
   {
      /* Use private method inOrder( root) 
         Model on preOrderPrint */
      System.out.print("inOrder print: ");
      inOrder (root);
      System.out.println();
   }
   
   
   /**
 * @param x
 * @return
 */
public boolean insert( E x ) 
    {//Create a new BinaryNode<E> called w with data = x and 
        //links = null
       //BELOW IS THE COMMENTED CODE THAT DIDN'T WORK AND I COULDN'T FIX IT, TRIED ALTERNATIVE WAY TO DO IT BY DECALRING insertNode method 
       //It worked partially on that way, but right now it works fine 
       /* 
        if (find(x, root) != null) {
            return false;
        }
        BinaryNode<E> p = root ;
        BinaryNode<E> q = null;
        if (p == null) {
            BinaryNode<E> w = new BinaryNode<>(x);
            w.parent = q;
            root = w;
            size++;
            return true;
        }
        if (x.compareTo(p.data) < 0) {
            if (p.left == null) {
            p.left = new BinaryNode<E>(x);
            return true;
        }
           root = p.left;
            insert(x);
           
        } else if (x.compareTo(p.data) > 0) {
            if (p.right == null) {
            p.right = new BinaryNode<E>(x);
            return true;
        }
     
           root = p.right;
              insert(x);

            
        }
        size++;
            return true;

             
-----------------------------------------------------------------------------------------------------------------------------
            */


            if (find(x, root) != null) {
                return false;
            }
            root = insertNode(root, null, x);
            size++;
            return true;





}
      
public boolean remove(E x)
{
  /* Return true if remove  is successful else return false }
      You must use  private methods 
deleteNodeWithOnlyRightChild(p)
deleteNodeWithOnlyLeftChild(p)
deleteLeaf(p)
getSuccessorNode(p)
 */

    if (root == null){
        return false;
    }
    BinaryNode<E> p = find(x,root);
    if(p == null){
        return false;
     }

    if (p == root) {
        deleteLeaf(p);
    } else if (p.right == null) {

        deleteNodeWithOnlyLeftChild(p);

    }   else if (p.left == null) {

        deleteNodeWithOnlyRightChild(p);

    } else { //p has a left and right child

    BinaryNode<E> v = getSuccessorNode(p);
    p.data = v.data;

    if (v.right == null) {
        deleteLeaf(v);
    } else {
        deleteNodeWithOnlyRightChild(v);
    }

}

return true;



}

  // ---------private  methods -------------------------------
   
   

   private BinaryNode<E> find(E x, BinaryNode<E> t)  
   {  // return null if x is not in tree}}
   
   if (t == null) {
    return null;
    }

    if (x.equals(t.data)) {
    return t;
    }
    if (x.compareTo(t.data)<0){
        return(find(x,t.left));
    }
    return(find(x,t.right));
    

    }

   private void deleteLeaf( BinaryNode<E> t)
   {  
    if (t == root) {
        root = null;}
        else {
            BinaryNode<E> parentT = t.parent;
            if (parentT.left == t) {
                parentT.left = null;
            } else {
                parentT.right = null;
            }
            size--;
            //set the correct left to right subtree of the parent t to null
        }
       
    
   }
  
   private void deleteNodeWithOnlyLeftChild( BinaryNode<E> t)
   { 
    if(t==root){
        root = t.left;
        root.parent = null;
    }else{
        t.left = t.parent;
    }
    size--;
 }          

                      
     
   private void deleteNodeWithOnlyRightChild( BinaryNode<E> t)
   {
        if(t==root){
            root = t.right;
            root.parent = null;
        }else{
            t.right = t.parent;
        }
        size--;
     }                  

   private BinaryNode<E> getSuccessorNode(BinaryNode<E> t)
   {
        if(t.right != null){
            BinaryNode<E> rightNode = t.right;
            while(rightNode.left != null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        return t;
     /*This will only be called  when t.right != null */
   }
     
   
 
 

  // -------------private traversal methods -----------------------     
           
         
  private void preOrder ( BinaryNode<E> t)  //done
   {
      if ( t != null)
      {
         System.out.print(t + " ");
         preOrder(t.left);
         preOrder(t.right);
      }
   }
     
   private void inOrder ( BinaryNode<E> t) { /*model code on preOrder */
    if ( t != null)
    {
        inOrder(t.left);
        System.out.print(t + " ");
        inOrder(t.right);
    }}
    private BinaryNode<E> findMinNode( )

    {
        BinaryNode<E> t = root;
    
    if (isEmpty())
    
    { 
    
        return null;    
    
    }
    
    else
    
     {
        if (root.left == null)
       }
    
    
    }

    
    private BinaryNode<E> insertNode(BinaryNode<E> p, BinaryNode<E> q, E data ) {
        if (p == null) {
            BinaryNode<E> w = new BinaryNode<>(data);
            w.parent = q;
            return w;
            
        }
        if (data.compareTo(p.data) < 0) {
            p.left = insertNode(p.left, p, data);
        } else if (data.compareTo(p.data) > 0) {
            p.right = insertNode(p.right, p, data);
        }
        return p;
    }

 
   //------------------------ main program -----------------
   public static void main(String[] args) 
   {  
  /*Testing my methods 
  
  BinarySearchTree tree= new BinarySearchTree();
 
tree.inOrderPrint();
 tree.insert(18);
 tree.insert(11);
 tree.insert(9);
 tree.insert(15);
 tree.insert(10);
 tree.insert(25);
 tree.insert(30);
 tree.insert(20);
 tree.insert(19);
 tree.insert(24);

  tree.inOrderPrint();
  tree.preOrderPrint();
  */
}
   }//end BinarySearchTree
