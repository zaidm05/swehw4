import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ChatGPT-generated JUnit 4 tests for Stack.java
 * These tests validate core stack operations, edge cases, and error handling.
 */
public class ChatGPTTest {

    // ✅ Test 1: Basic LIFO behavior for push, peek, and pop
    @Test
    public void lifo_push_peek_pop() {
        Stack s = new Stack(3);
        s.push(10); s.push(20); s.push(30);
        assertEquals(30, s.peek());     // top should be 30
        assertEquals(30, s.pop());      // popping removes 30
        assertEquals(20, s.peek());     // now top is 20
        assertEquals(2, s.size());      // 2 elements remain
    }

    // ✅ Test 2: Popping from an empty stack should throw an exception
    @Test(expected = IllegalStateException.class)
    public void pop_on_empty_throws() {
        Stack s = new Stack(1);
        s.pop(); // should throw
    }

    // ✅ Test 3: Peeking an empty stack should throw an exception
    @Test(expected = IllegalStateException.class)
    public void peek_on_empty_throws() {
        Stack s = new Stack(1);
        s.peek(); // should throw
    }

    // ✅ Test 4: Pushing beyond capacity should throw an exception
    @Test(expected = IllegalStateException.class)
    public void push_overflow_throws() {
        Stack s = new Stack(1);
        s.push(42);
        s.push(99); // should throw when full
    }

    // ✅ Test 5: Check isEmpty, isFull, and size behavior through transitions
    @Test
    public void flags_and_size_behavior() {
        Stack s = new Stack(2);
        assertTrue(s.isEmpty());
        assertFalse(s.isFull());
        assertEquals(0, s.size());

        s.push(5);
        assertFalse(s.isEmpty());
        assertFalse(s.isFull());
        assertEquals(1, s.size());

        s.push(6);
        assertTrue(s.isFull());
        assertEquals(2, s.size());

        assertEquals(6, s.pop());
        assertFalse(s.isFull());
        assertEquals(1, s.size());

        assertEquals(5, s.pop());
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
    }

    // ✅ Test 6: Peeking multiple times does not change stack size (idempotent)
    @Test
    public void peek_is_idempotent() {
        Stack s = new Stack(3);
        s.push(7); s.push(8);
        int beforeSize = s.size();
        assertEquals(8, s.peek());
        assertEquals(beforeSize, s.size());
        assertEquals(8, s.peek());
        assertEquals(beforeSize, s.size());
    }

    // ✅ Test 7: Stack with zero capacity behaves correctly (always full)
    @Test(expected = IllegalStateException.class)
    public void zero_capacity_cannot_push() {
        Stack s = new Stack(0);
        assertTrue(s.isEmpty());
        assertTrue(s.isFull());  // because capacity - 1 == -1
        assertEquals(0, s.size());
        s.push(1); // must throw
    }

    // ✅ Test 8: Refilling the stack after emptying it works correctly
    @Test
    public void refill_after_empty() {
        Stack s = new Stack(2);
        s.push(1); s.push(2);
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());

        s.push(3); s.push(4);
        assertTrue(s.isFull());
        assertEquals(4, s.peek());
    }
}
