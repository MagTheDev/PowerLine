package iterutils

import dev.magthe.iterutils.peeking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PeekingIteratorTest {

    @Test
    fun `Can correctly work as an iterator`() {
        val iter = listOf(0,1,2,3,4,5,6,7,8,9).iterator().peeking()
        var expected = 0;
        for (item in iter) {
            assertEquals(expected, item)
            expected++
        }
    }

    @Test
    fun `Can correctly work as a PeekingIterator`() {
        val iter = listOf(0,1,2,3,4,5,6,7,8,9).iterator().peeking()
        assertEquals(0, iter.peek())
        assertEquals(0, iter.peek())
        assertEquals(0, iter.peek())

    }

}