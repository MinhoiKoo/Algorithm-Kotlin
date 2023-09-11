import java.io.*
import java.util.ArrayDeque

val dx = arrayOf(-1,1,0,0,-1,-1,1,1)
val dy = arrayOf(0,0,-1,1,-1,1,-1,1)
fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    while(true) {
        val input = br.readLine().toString().split(" ").map {it.toInt()}
        if(input.contains(0))
            break
        val graph = Array(input[1]) {mutableListOf<Int>()}
        val visited = Array(input[1]) {BooleanArray(input[0]){false}}
        // 그래프에 땅/바다 위치 저장
        for(i in 0 until input[1]) {
            val num = br.readLine().toString().split(" ").map {it.toInt()}
            for(j in num) {
                graph[i].add(j)
            }
        }

        var ans = 0
        for(i in 0 until input[1]) {
            for(j in 0 until input[0]) {
                // 방문하지 않은 땅만 탐색
                if(graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j, input[1], input[0], graph, visited)
                    ans++
                }
            }
        }
        bw.write("$ans\n")
    }
    bw.flush()
}

fun bfs(i : Int, j : Int, n : Int, m : Int, graph : Array<MutableList<Int>>, visited : Array<BooleanArray>) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    // 현재 위치 큐에 삽입
    queue.offer(Pair(i, j))
    visited[i][j] = true
    while(!queue.isEmpty()) {
        val current = queue.poll()
        // 현재 위치 상하좌우대각선 탐색 
        for(i in 0 until 8) {
            val x = current.first + dx[i]
            val y = current.second + dy[i]

            // 범위가 넘어가거나 이미 방문한 노드는 건너뛰기
            if(x < 0 || x >=n || y<0 || y>=m || visited[x][y])
                continue
            else if(graph[x][y] == 0)
                continue
            else {
                queue.offer(Pair(x,y))
                visited[x][y] = true
            }
        }

    }

}