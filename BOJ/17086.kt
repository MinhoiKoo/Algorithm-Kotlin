import java.io.*
import java.util.*
import kotlin.math.*
lateinit var graph : Array<MutableList<Int>>
var dx = arrayListOf<Int>(-1,1,0,0,-1,-1,1,1)
var dy = arrayListOf<Int>(0,0,-1,1,-1,1,-1,1)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().toString().split(" ").map {it.toInt()}

    graph = Array(n) {mutableListOf<Int>()}
    for(i in 0 until n) {
        val input = br.readLine().toString().split(" ").map{it.toInt()}
        for(j in 0 until m) {
            graph[i].add(input[j])
        }
    }

    var ans = 0
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(graph[i][j] == 0) {
                ans = max(ans, bfs(i,j,n,m))
            }
        }
    }

    for(i in graph) {
        for(j in i)  {
            ans = max(ans, j)
        }
    }

    bw.write("$ans")
    bw.flush()


}

fun bfs(i : Int, j : Int, n : Int, m : Int) : Int {
    val queue = ArrayDeque<MutableList<Int>>()
    val visited = Array(n) {BooleanArray(m) {false} }

    visited[i][j] = true
    queue.offer(arrayListOf(i,j,0))

    while(!queue.isEmpty()) {
        val current = queue.poll()
        visited[current[0]][current[1]] = true

        if(graph[current[0]][current[1]] == 1) {
            return current[2]
        }
        else {
            //상하좌우대각선 queue에 삽입
            for(i in 0 until 8) {
                val x = current[0] + dx[i]
                val y = current[1] + dy[i]
                val dis = current[2]
                if(x < 0 || x>=n || y<0 || y>=m || visited[x][y])
                    continue
                else {
                    visited[x][y] = true
                    queue.offer(arrayListOf(x,y, dis+1))
                }
            }
        }
    }
   return 0
}