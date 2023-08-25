import java.io.*
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
lateinit var graph : Array<MutableList<Int>>
lateinit var visited : Array<MutableList<Boolean>>
var count = 0
var maxL = 0
var n = -1
var m = -1
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine().toString().split(" ").map{it.toInt()}
    n = input[0]
    m = input[1]
    graph = Array(n) {mutableListOf<Int>()}
    visited = Array(n) { mutableListOf<Boolean>()}

    for(i in 0 until n) {
        val num = br.readLine().split(" ").map{it.toInt()}
        for(j in 0 until m) {
            graph[i].add(num[j])
            visited[i].add(false)
        }
    }
    var maxValue = 0
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(graph[i][j] == 1 && !visited[i][j]) {
                count++
                maxValue = max(dfs(i,j),maxValue)
                maxL = 0
            }
        }
    }

    bw.write("$count\n")
    bw.write("$maxValue")
    bw.flush()
}

fun dfs(x : Int, y : Int) : Int {
    if(x < 0 || x>=n || y<0 || y>=m) {
        return -1
    }
    // 방문한 노드는 제외
    if(visited[x][y]) {
        return -1
    }
    if(graph[x][y] == 0) {
        return -1
    }

    // 현재 노드 방문
    visited[x][y] = true
    maxL++
    dfs(x-1, y)
    dfs(x+1, y)
    dfs(x, y-1)
    dfs(x, y+1)

    return maxL
}






