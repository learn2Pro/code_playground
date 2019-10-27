package category.time.week42;

import java.util.Iterator;

/**
 * 284. Peeking Iterator
 */
class PeekingIterator implements Iterator<Integer> {

    private       Integer           peekElement = null;
    private       Boolean           hasPeeked   = false;
    private final Iterator<Integer> internal;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if (iterator == null) { throw new NullPointerException("input iterator is null!"); }
        internal = iterator;
        peeky();
    }

    public Integer peek() {
        if (!hasPeeked) {
            peeky();
        }
        return peekElement;
    }

    @Override
    public Integer next() {
        if (!hasPeeked) { peeky(); }
        hasPeeked = false;
        return peekElement;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || internal.hasNext();
    }

    private void peeky() {
        if (internal.hasNext()) {
            peekElement = internal.next();
            hasPeeked = true;
        }
    }
}