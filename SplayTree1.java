/*This is a Java Program to implement Splay Tree. A splay tree is a self-adjusting binary search tree with the additional property that recently accessed elements are quick to access again. It performs basic operations such as insertion, look-up and removal in O(log n) amortized time. For many sequences of non-random operations, splay trees perform better than other search trees, even when the specific pattern of the sequence is unknown. The splay tree was invented by Daniel Dominic Sleator and Robert Endre Tarjan in 1985.*/
 
/**
 *  Java Program to Implement SplayTree
 **/
 

 
/** Class Node **/
class SplayNode1
{
    SplayNode1 left, right, parent;
    int element;
 
    /** Constructor **/
    public SplayNode1()
    {
        this(0, null, null, null);
    }
    /** Constructor **/
    public SplayNode1(int ele)
    {
        this(ele, null, null, null);
    }
    /** Constructor **/
    public SplayNode1(int ele, SplayNode1 left, SplayNode1 right, SplayNode1 parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = ele;
    }
}
 
/** Class SplayTree **/
class SplayTree1
{
    private SplayNode1 root;
    int count = 0;
 
    /** Constructor **/
    public SplayTree1()
    {
        root = null;
    }
 
    /** Function to check if tree is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }
 
    /** clear tree **/
    public void clear()
    {
        root = null;
        count = 0;
    }
 
    /** function to insert element */
    public void insert(int ele)
    {
        SplayNode1 z = root;
        SplayNode1 p = null;
        while (z != null)
            {
                p = z;
                if (ele < p.element)
                    z = z.right;
                else
                    z = z.left;
            }
        z = new SplayNode1();
        z.element = ele;
        z.parent = p;
        if (p == null)
            root = z;
        else if (ele < p.element)
            p.right = z;
        else
            p.left = z;
        Splay(z);
        count++;
    }
    /** rotate **/
    public void makeLeftChildParent(SplayNode1 c, SplayNode1 p)
    {
        if ((c == null) ||(p == null) ||(p.left != c) ||(c.parent != p)){
            throw new RuntimeException("WRONG");
        }
        if (p.parent != null)
            {
                if (p == p.parent.left)
                    p.parent.left = c;
                else
                    p.parent.right = c;
            }
        if (c.right != null)
            c.right.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }
 
    /** rotate **/
    public void makeRightChildParent(SplayNode1 c, SplayNode1 p)
    {
        if ((c == null)  ||(p == null)  ||(p.right != c)  ||(c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
            {
                if (p == p.parent.left)
                    p.parent.left = c;
                else
                    p.parent.right = c;
            }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }
 
    /** function splay **/
    private void Splay(SplayNode1 x)
    {
        while (x.parent != null)
            {
                SplayNode1 Parent = x.parent;
                SplayNode1 GrandParent = Parent.parent;
                if (GrandParent == null)
                    {
                        if (x == Parent.left)
                            makeLeftChildParent(x, Parent);
                        else
                            makeRightChildParent(x, Parent);
                    }
                else
                    {
                        if (x == Parent.left)
                            {
                                if (Parent == GrandParent.left)
                                    {
                                        makeLeftChildParent(Parent, GrandParent);
                                        makeLeftChildParent(x, Parent);
                                    }
                                else
                                    {
                                        makeLeftChildParent(x, x.parent);
                                        makeRightChildParent(x, x.parent);
                                    }
                            }
                        else
                            {
                                if (Parent == GrandParent.left)
                                    {
                                        makeRightChildParent(x, x.parent);
                                        makeLeftChildParent(x, x.parent);
                                    }
                                else
                                    {
                                        makeRightChildParent(Parent, GrandParent);
                                        makeRightChildParent(x, Parent);
                                    }
                            }
                    }
            }
        root = x;
    }
 
    /** function to remove element **/
    public void remove(int ele)
    {
        SplayNode1 node = findNode(ele);
        remove(node);
    }
 
    /** function to remove node **/
    private void remove(SplayNode1 node)
    {
        if (node == null)
            return;
        Splay(node);
        if( (node.left != null) && (node.right !=null))
            {
                SplayNode1 min = node.left;
                while(min.right!=null)
                    min = min.right;
                min.right = node.right;
                node.right.parent = min;
                node.left.parent = null;
                root = node.left;
            }
        else if (node.right != null)
            {
                node.right.parent = null;
                root = node.right;
            }
        else if( node.left !=null)
            {
                node.left.parent = null;
                root = node.left;
            }
        else
            {
                root = null;
            }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }
 
    /** Functions to search for an element **/
    public boolean search(int val)
    {
        return findNode(val) != null;
    }
    private SplayNode1 findNode(int ele)
    {
        SplayNode1 z = root;
        while (z != null)
            {
                if (ele < z.element)
                    z = z.right;
                else if (ele > z.element)
                    z = z.left;
                else
                    return z;
            }
        return null;
    }
 
    /** Function for inorder traversal **/
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(SplayNode1 r)
    {
        if (r != null)
            {
                inorder(r.left);
                System.out.print(r.element +" ");
                inorder(r.right);
            }
    }
 
}
 
