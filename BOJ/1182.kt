import java.util.*
import java.io.*
import java.lang.StringBuilder

var array = mutableListOf<Int>()
lateinit var visited : Array<Boolean>
var n = -1
var s = -1
var count = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val l = br.readLine().toString().split(" ").map{it.toInt()}
    n = l[0]
    s = l[1]
    val input = br.readLine().toString().split(" ").map{it.toInt()}


    visited = Array(n) {false}
    for(i in 0 until n) {
        array.add(input[i])
    }

    dfs(0,0, 0)

    if(s==0) count--
    bw.write("$count")
    bw.flush()


}

fun dfs(depth : Int, beginWith : Int, sum : Int) {
    if(sum == s) count++
    if(depth == n) {
        return
    } else {
        for(i in beginWith until n) {
            dfs(depth +1, i+1, sum + array[i] )
        }
    }
}




