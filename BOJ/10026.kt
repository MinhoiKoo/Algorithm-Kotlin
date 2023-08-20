import java.io.*
import java.util.*

var count = 0
var count1 = 0
lateinit var graph : Array<MutableList<String>>

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    graph = Array(n){mutableListOf<String>()}
    val visited = Array(n) {mutableListOf<Boolean>()}
    val visited1 = Array(n) {mutableListOf<Boolean>()}

    for(i in 0 until n) {
        for(j in 0 until n) {
            visited[i].add(false)
        }
    }
    for(i in 0 until n) {
        for(j in 0 until n) {
            visited1[i].add(false)
        }
    }
    //graph 초기화
    for(i in 0 until n) {
        val input = br.readLine().toString()
        for(j in input) {
            graph[i].add(j.toString())
        }
    }

//    색맹이 아닌 사람이 한개씩 모두 방문
    for(i in 0 until n) {
        for (j in 0 until n) {
            if(dfs(i,j,visited,graph[i][j],n)) {
                count++
            }
        }
    }

    //    색맹인 사람이 한개씩 모두 방문
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(dfs1(i,j,visited1,graph[i][j],n))
                count1++
        }
    }

    bw.write("$count ")
    bw.write("$count1")
    bw.flush()


}

fun dfs(i : Int, j : Int, visited : Array<MutableList<Boolean>>, color : String, n : Int) : Boolean {

    //범위가 넘는 노드는 방문하지 않는다
    if(i<0 || i>=n || j<0 || j>=n) {
        return false
    }

    // 방문한 노드는 방문하지 않는다
    if(visited[i][j]) {
        return false
    }

    //색상이 다른 노드는 방문하지 않는다
    if(color != graph[i][j]) {
        return false
    }

    // 현재 노드 방문
    visited[i][j] = true

    //상,하,좌,우 방문
    dfs(i-1, j, visited, graph[i][j],n)
    dfs(i+1, j, visited, graph[i][j],n)
    dfs(i, j-1, visited, graph[i][j],n)
    dfs(i, j+1, visited, graph[i][j],n)

    return true
}

fun dfs1(i : Int, j : Int, visited : Array<MutableList<Boolean>>, color : String, n : Int) : Boolean {

    //범위가 넘는 노드는 방문하지 않는다
    if(i<0 || i>=n || j<0 || j>=n) {
        return false
    }

    // 방문한 노드는 방문하지 않는다
    if(visited[i][j]) {
        return false
    }

    if(color == "R") {
        if(graph[i][j] != "G" && graph[i][j] != "R") {
            return false
        }
    } else if(color == "G") {
        if(graph[i][j] !="R" && graph[i][j] != "G") {
            return false
        }
    } else {
        if(color != graph[i][j])
            return false
    }



    // 현재 노드 방문
    visited[i][j] = true
    //상,하,좌,우 방문
    dfs1(i-1, j, visited, graph[i][j],n)
    dfs1(i+1, j, visited, graph[i][j],n)
    dfs1(i, j-1, visited, graph[i][j],n)
    dfs1(i, j+1, visited, graph[i][j],n)

    return true
}





