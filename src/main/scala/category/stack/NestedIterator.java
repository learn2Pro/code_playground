package category.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator
 * test case:
 * [[1,1],2,[1,1]]
 * [1,[4,[6]]]
 * [[1,[4,7,[9,10]],8],2]
 * [1]
 * []
 * [[]]
 * [1,[],3]
 * [1,2,3,4]
 * [[4,3],1]
 * [[[[]]],[]]
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new java.util.Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        int sz = nestedList.size();
        for (int i = sz - 1; i >= 0; --i) {
            add(nestedList.get(i));
        }
    }

    private void add(NestedInteger input) {
        if (input.isInteger()) {
            stack.push(input);
        }
        List<NestedInteger> lst = input.getList();
        int sz = lst.size();
        for (int i = sz - 1; i >= 0; --i) {
            add(lst.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}