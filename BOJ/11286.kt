import java.io.*
import java.util.*
import kotlin.math.abs

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val absComparator = compareBy<Pair<Int, Int>> {it.first}.thenBy{it.second}
    val queue = PriorityQueue<Pair<Int,Int>>(absComparator)
    repeat(n) {
        when(val num = br.readLine().toInt()) {
            0 -> {
                if (!queue.isEmpty()) {
                    bw.write("${queue.poll().second}\n")
                } else {
                    bw.write("0\n")
                }
            } else -> {
                queue.offer(Pair(abs(num),num))
            }
        }
    }
    bw.flush()
}






