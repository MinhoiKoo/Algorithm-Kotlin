import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args : Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val sb = StringBuilder()
    sb.append("<")

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val queue = ArrayDeque<Int>()
    repeat(n) {
        queue.add(it+1)
    }

    while (true) {
        if(queue.size == 1)
            break

        for(i in 1 until k) {
            queue.add(queue.first)
            queue.remove()
        }

        val num = queue.remove()
        sb.append("$num, ")
    }
    sb.append(queue.first.toString())
    sb.append(">")
    bw.write(sb.toString())
    bw.flush()


}
