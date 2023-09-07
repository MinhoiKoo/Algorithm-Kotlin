import java.util.*
import java.io.*

lateinit var graph : Array<MutableList<Char>>
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (x, y) = br.readLine().toString().split(" ").map {it.toInt()}

    graph = Array(x) {mutableListOf<Char>()}

    for(i in 0 until x) {
        val input = br.readLine().toString()
        for(j in input) {
            graph[i].add(j)
        }
    }

    var ans = -1

    for(i in 0 until x) {
        for(j in 0 until y) {
            if(graph[i][j] == 'L')
                ans = kotlin.math.max(ans, bfs(i,j,x,y))
        }
    }

    bw.write("$ans")
    bw.flush()
}

fun bfs(i : Int, j: Int, n : Int, m : Int) : Int {
    val queue = java.util.ArrayDeque<Coordinate>()
    // 한 지점 탐색마다 방문한 땅 초기화
    val visited = Array(n) {BooleanArray(m) {false}}
    var distance = -1
    // 현재 노드 꺼내서 방문처리
    queue.offer(Coordinate(i,j,0))
    visited[i][j] = true
    while(!queue.isEmpty()) {
        val current = queue.poll()
        distance = current.dis

        for(i in 0 until 4) {
            val x = current.x + dx[i]
            val y = current.y + dy[i]
            // 범위 벗어나거나 방문했거나 바다면 큐에 넣지 않는다
            if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || graph[x][y] == 'W')
                continue

            queue.offer(Coordinate(x,y,current.dis +1))
            visited[x][y] = true
        }
    }
    return distance
}

data class Coordinate(
    val x : Int,
    val y : Int,
    val dis : Int
)