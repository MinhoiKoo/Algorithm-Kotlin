import java.io.*
import java.util.*
import kotlin.math.max

var count = 0
var n = 0
var m = 0
lateinit var graph : Array<MutableList<Boolean>>
lateinit var visited : Array<MutableList<Boolean>>

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var input = StringTokenizer(br.readLine())
    n = input.nextToken().toInt()
    m = input.nextToken().toInt()
    val k = input.nextToken().toInt()

    //N+1행 M+1열 (1부터 시작하기위해)
    graph = Array(n+1){mutableListOf<Boolean>()}
    visited = Array(n+1){mutableListOf<Boolean>()}

    for(i in 0..n) {
        for(j in 0..m) {
            graph[i].add(false)
            visited[i].add(false)
        }
    }

    repeat(k) {
        val (x,y) = br.readLine().split(" ").map{it.toInt()}
        // 그래프에 음식물 쓰레기 위치 true로 설정
        graph[x][y] = true
    }

    var maxValue = 0

    for(i in 1..n) {
        for(j in 1..m) {
            // 쓰레기가 있는 곳만 방문
            if(graph[i][j]) {
                count = 0
                maxValue = max(maxValue, dfs(i,j))
            }
        }
    }

    bw.write("$maxValue")
    bw.flush()

}

fun dfs(x : Int, y : Int) : Int {
    if(x<1 || x>n || y<1 || y>m) {
        return -1
    }

    if(visited[x][y]) {
        return -1
    }
    //현재 노드 방문
    visited[x][y] = true

    // 만약 쓰레기가 없는 노드이면 반환 있으면 상하좌우 탐색
    if(!graph[x][y]) {
        return -1
    } else {
        count++
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
    }

    return count
}






