//
// Binary trees are already defined with this interface:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
Tree<Integer> constructSumTree(Tree<Integer> t) {

    goDown(t, t, t);

    return t;

}

void goDown(Tree<Integer> t, Tree<Integer> parent, Tree<Integer> root) {

    // 1. emergency exit
    if ( t == null ) return;
    
    // 2. Nullify Leaf
    if ( t.left == null && t.right == null) {

        // give that value to my parent;
        parent.value += t.value;

        // nullify here
        t.value = 0;
    }

    // 3. traverse  
    if ( t.left  != null && t.left.value != 0) goDown(t.left, t, root);
    if ( t.right != null && t.right.value != 0 ) goDown(t.right, t, root);
    
    // 4. handle  branches
    if ( t.left  != null && t.left.value != 0)  t.value += t.left.value;
    if ( t.right != null && t.right.value != 0) t.value += t.right.value;

    // 5. parent is root edge case
    if ( t.left == null && t.right == null && parent == t)  t.value = 0;
    
// end of go down 
}
