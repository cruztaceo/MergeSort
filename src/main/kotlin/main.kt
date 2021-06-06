import java.io.File

fun main() {
    val inputFileName = "src/main/resources/IntegerArray.txt"
    val outputFileName = "src/main/resources/MergeSortOutputArray.txt"
    val input = readFileAsLinesUsingBufferedReader(inputFileName).map { it.toInt() }.toIntArray()
    val result = mergeSort(input)
//    println("Operations = ${pair.first}")
//    println("==========================")
//    pair.second.map { println(it) }
    val outputFile = File(outputFileName).printWriter()
    outputFile.use { out ->
        out.println(result.contentToString())
    }
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String> = File(fileName).bufferedReader().readLines()

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

fun merge(C: IntArray, D: IntArray): IntArray {
    var i = 0
    var j = 0
    val B = IntArray(C.size + D.size)
    for (k in B.indices) {
        if (j == D.size) {
            B[k] = C[i]
            i += 1
            continue
        } else if (i == C.size) {
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