import java.io.*
import java.util.*

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    var count = 0
    val hashSet = hashSetOf<String>()
    
    repeat(n) {
        when(val person = br.readLine()) {
            "ENTER" -> {
                count += hashSet.size
                hashSet.clear()
            }
            else -> {
                hashSet.add(person)
            }
        }
    }
    count += hashSet.size
    bw.write("$count")
    bw.flush()
}