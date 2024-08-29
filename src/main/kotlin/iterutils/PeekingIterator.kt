package dev.magthe.iterutils

class PeekingIterator<T>(private val iterator: Iterator<T>) : Iterator<T> {
    private var hasPeeked = false
    private var peeked: T? = null

    override fun hasNext(): Boolean = hasPeeked || iterator.hasNext()

    override fun next(): T  {
        return if (hasPeeked) {
            hasPeeked = false
            @Suppress("UNCHECKED_CAST")
            peeked as T
        } else {
            iterator.next()
        }
    }

    fun peek(): T {
        if (!hasPeeked) {
            peeked = iterator.next()
            hasPeeked = true
        }
        @Suppress("UNCHECKED_CAST")
        return peeked as T
    }
}

fun <T> Iterator<T>.peeking(): PeekingIterator<T> = PeekingIterator(this)