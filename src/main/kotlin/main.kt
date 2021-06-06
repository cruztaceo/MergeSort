import java.io.File

fun main() {
    val inputFileName = "src/main/resources/IntegerArray.txt"
    val outputFileName = "src/main/resources/MergeSortOutputArray.txt"
    val input = readFileAsLinesUsingBufferedReader(inputFileName).map { it.toInt() }.toIntArray()
    val result = mergeSort(input)
    val outputFile = File(outputFileName).printWriter()
    outputFile.use { out ->
        out.println(result.contentToString())
    }
}

/**
 * Read file
 *
 * @param fileName Read file
 * @return List of strings read
 */
fun readFileAsLinesUsingBufferedReader(fileName: String): List<String> = File(fileName).bufferedReader().readLines()

/**
 * Main method to sort arrays using MergeSort
 *
 * @param A any array
 * @return Sorted array
 */
fun mergeSort(A: IntArray): IntArray {
    val n = A.size
    if (n == 1)
        return A
    var C = A.slice(0 until (n / 2)).toIntArray()
    var D = A.slice((n / 2) until n).toIntArray()

    C = mergeSort(C)
    D = mergeSort(D)
    return merge(C, D)
}

/**
 * Merge two sorted arrays with length (n/2)
 *
 * @param C Sorted array
 * @param D Sorted array
 * @return Sorted merged array
 */
fun merge(C: IntArray, D: IntArray): IntArray {
    var i = 0
    var j = 0
    val B = IntArray(C.size + D.size)
    for (k in B.indices) {
        // Evaluate when D[j] > D.Size
        if (j == D.size) {
            B[k] = C[i]
            i += 1
            continue
        }
        // Evaluate when C[i] > C.Size
        else if (i == C.size) {
            B[k] = D[j]
            j += 1
            continue
        }

        if (C[i] < D[j]) {
            B[k] = C[i]
            i += 1
        } else {
            B[k] = D[j]
            j += 1
        }
    }
    return B
}