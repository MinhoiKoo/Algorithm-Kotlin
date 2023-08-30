import java.util.*
import java.io.*
var n = -1
var array = mutableListOf<Int>()
lateinit var visited : Array<Boolean>
lateinit var selected : Array<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    n = br.readLine().toInt()
    selected = Array(n+1){0}
    visited = Array(n+1) {false}

    for(i in 0..n) {
        array.add(i)
    }

    dfs(0)

}

fun dfs(depth : Int) {
    if(depth == n) {
        for(i in 0 until n) {
            print("${selected[i]} ")
        }
        println()
        return
    }

    for(i in 1 ..n) {
        if(!visited[i]) {
            visited[i] = true
            selected[depth] = i
            dfs(depth+1)
            visited[i] = false
        }
    }

}


