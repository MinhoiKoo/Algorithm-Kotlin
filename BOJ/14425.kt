import java.io.*
import java.util.*
import kotlin.math.max
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var count = 0
    val (n,m) = br.readLine().toString().split(" ").map{it.toInt()}
    val set = hashSetOf<String>()
    repeat(n) {
        val input = br.readLine().toString()
        set.add(input)
    }

    repeat(m) {
        val input = br.readLine().toString()
        if(set.contains(input)) {
            count++
        }
    }
    bw.write("$count")
    bw.flush()
}






