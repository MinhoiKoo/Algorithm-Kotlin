import java.util.*
import java.io.*
import kotlin.math.*
lateinit var array : Array<MutableList<Char>>
var maxV = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    array = Array(n) {mutableListOf<Char>()}

    for(i in 0 until n) {
        val input = br.readLine().toString()
        for(j in 0 until n) {
            array[i].add(input[j])
        }
    }

    check(n)
    for(i in 0 until n) {
        for(j in 0 until n) {

            // 좌, 우가 다르고 j가 마지막 인덱스가 아니면 swap
            if(j<n-1 && (array[i][j] != array[i][j+1])) {
                swap(i, j)
                check(n)
                swap(i, j)
            }
            if(i<n-1 && (array[i][j] != array[i+1][j])) {
                swap2(i, j)
                check(n)
                swap2(i, j)
            }
        }
    }

    bw.write("$maxV")
    bw.flush()
}

fun swap(i : Int, j : Int) {
    val temp = array[i][j]
    array[i][j] = array[i][j+1]
    array[i][j+1] = temp
}

fun swap2(i : Int, j : Int) {
    val temp = array[i][j]
    array[i][j] = array[i+1][j]
    array[i+1][j] = temp
}

fun check(n : Int) {
    var count = 0
    for(i in 0 until n) {
        var current = array[i][0]
        for(j in 0 until n) {
            if(current == array[i][j])
                count++
            else{
                maxV = max(count, maxV)
                current = array[i][j]
                count = 1
            }
        }
        maxV = max(count, maxV)
        count = 0
    }

    count = 0

    for(i in 0 until n) {
        var current = array[0][i]
        for(j in 0 until n) {
            if(current == array[j][i]) {
                count++
            } else {
                maxV = max(count, maxV)
                current = array[j][i]
                count = 1
            }
        }
        maxV = max(count, maxV)
        count = 0
    }

}


