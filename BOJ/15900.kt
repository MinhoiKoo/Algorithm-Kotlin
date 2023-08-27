import java.io.*
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
lateinit var graph : Array<MutableList<Int>>
lateinit var visited : Array<Boolean>
var count1 = 0
var maxL = 0
var n = -1
var m = -1
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    graph = Array(n+1) { mutableListOf<Int>() }
    visited = Array(n+1) {false}
    repeat(n-1) {
        val (i,j) = br.readLine().toString().split(" ").map {it.toInt()}
        graph[i].add(j)
        graph[j].add(i)
    }

    dfs(1,0)

    val ans = when{
        count1%2 == 0 -> "No"
        else -> "Yes"
    }
    bw.write("$ans")
    bw.flush()
}

fun dfs(node : Int, count : Int) {
    visited[node] = true
    var leaf = 0
    graph[node].forEach { next ->
        if(!visited[next]) {
            dfs(next, count+1)
        } else if(visited[next]) {
            leaf++
        }
    }
    if(leaf == graph[node].size) {
        count1 += count
    }
}
