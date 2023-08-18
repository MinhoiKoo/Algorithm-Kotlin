import java.io.*
import java.util.*

var large = 0
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = StringTokenizer(br.readLine())
    val m = input.nextToken().toInt()
    val n = input.nextToken().toInt()
    val k = input.nextToken().toInt()

    val graph = Array(m) { mutableListOf<Int>()}
    for(i in 0 until m) {
        for(j in 0 until n) {
            graph[i].add(0)
        }
    }

    repeat(k) {
        val input = StringTokenizer(br.readLine())
        val y1 = input.nextToken().toInt()
        val x1 = input.nextToken().toInt()
        val y2 = input.nextToken().toInt()
        val x2 = input.nextToken().toInt()

        for(i in x1 until x2) {
            for(j in y1 until y2) {
                graph[i][j] = 1
            }
        }
    }


    var count = 0
    val list = arrayListOf<Int>()
    val sb = StringBuilder()

    for(i in 0 until m) {
        for(j in 0 until n) {
            if(graph[i][j] == 0) {
                count++
                dfs2(i,j,graph,m,n)
                list.add(large)
                large = 0
            }
        }
    }

    list.sort()

    bw.write("$count\n")
    for(i in list) {
        sb.append("$i ")
    }

    bw.write(sb.toString().trimEnd())
    bw.flush()


}

fun dfs2(y1 : Int, x1 : Int, graph : Array<MutableList<Int>>, m:Int, n:Int){
    if(y1 <0 || y1>=m || x1<0 || x1>=n) {
        return
    }
    if(graph[y1][x1]==1) {
        return
    }
    // 현재 노드 방문
    graph[y1][x1] = 1
    large++

    //상,하,좌,우 방문
    dfs2(y1-1, x1,graph,m,n)
    dfs2(y1+1,x1,graph,m,n)
    dfs2(y1,x1-1,graph,m,n)
    dfs2(y1,x1+1,graph,m,n)

}


