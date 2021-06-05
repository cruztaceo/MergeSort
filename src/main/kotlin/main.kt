fun main(args: Array<String>) {
    println("Hello World!")
    val array = intArrayOf(1, 3, 4, 5, 6)
    println(mergeSort(array).contentToString())
}

fun mergeSort(A: IntArray): IntArray {
    val n = A.size
    if(n == 1)
        return A
    var C = A.slice(0 until (n/2)).toIntArray()
    var D = A.slice((n/2) until n).toIntArray()

    C = mergeSort(C)
    D = mergeSort(D)
    return merge(C, D)
}

fun merge(C: IntArray, D: IntArray): IntArray {
    var i = 1
    var j = 1
    val B = intArrayOf();
    for (k in 1..(C.size)) {
        if (C[i] < D[j]){
            B[k] = C[i]
            i += 1
        }
        else{
            B[k] = D[j]
            j += 1
        }
    }
    return B
}