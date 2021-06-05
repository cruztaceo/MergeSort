import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun mergeSort() {
        val array = intArrayOf(2, 1, 3, 5, 6, 4)
        val result = mergeSort(array)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6)
        assertTrue(result.contentEquals(expected), "Arrays is ordered")
    }
}