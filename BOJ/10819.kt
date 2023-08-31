import java.util.*
import java.io.*
import kotlin.math.*
var n = -1
lateinit var array : Array<Int>
lateinit var permutation : ArrayList<MutableList<Int>>
lateinit var visited : Array<Boolean>
lateinit var selected : ArrayList<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    n = br.readLine().toInt()
    val input = br.readLine().toString().split(" ").map {it.toInt()}

    permutation = ArrayList()
    visited = Array(n) {false}
    array = Array(n) {0}
    selected = arrayListOf<Int>()
    for(i in 0 until n) {
        array[i] = input[i]
        selected.add(0)
    }

    dfs(0)

    var maxV = -2100000000
    for(i in 0 until permutation.size) {
        var sum = 0
        for(j in 0 until n-1) {
            sum += abs(permutation[i][j] - permutation[i][j+1])
        }
        maxV = max(maxV, sum)
    }

    bw.write("$maxV")
    bw.flush()

}

fun dfs(depth : Int) {
    if(depth == n) {
        val per = arrayListOf<Int>()
        per.addAll(selected)
        permutation.add(per)
        return
    }

    for(i in 0 until n) {
        if(!visited[i]) {
            visited[i] = true
            selected[depth] = array[i]
            dfs(depth +1)
            visited[i] = false
        }
    }

}


