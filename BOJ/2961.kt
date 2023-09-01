import java.util.*
import java.io.*
import kotlin.math.*

var n = -1
lateinit var array : ArrayList<Pair<Int, Int>>
var combArray = arrayListOf<MutableList<Pair<Int, Int>>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    n = br.readLine().toInt()
    array = arrayListOf()
    repeat(n) {
        val (s, b) = br.readLine().toString().split(" ").map {it.toInt()}
        array.add(Pair(s,b))
    }

    // 모든 조합 구하기
    dfs(0, 0, mutableListOf())
    combArray.removeFirst()

    var ans = 1000000000

    for(i in combArray) {
        var sumS = 1
        var sumB = 0
        for(j in i) {
            sumS *= j.first
            sumB += j.second
        }
        ans = min(ans, abs(sumS-sumB))
    }
    bw.write("$ans")
    bw.flush()
}


fun dfs(depth: Int, currentIndex: Int, currentCombination: MutableList<Pair<Int, Int>>) {
    if (depth > n) {
        return
    }
    // 조합 추가
    combArray.add(ArrayList(currentCombination))

    for (i in currentIndex until n) {
        currentCombination.add(array[i])
        dfs(depth + 1, i + 1, currentCombination)
        currentCombination.removeAt(currentCombination.size - 1) // 백트래킹
    }
}


