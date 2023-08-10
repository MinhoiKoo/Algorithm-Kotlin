import java.io.*
import java.util.*

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val list = arrayListOf<Int>()
    repeat(n) {
        val num = br.readLine().toInt()
        list.add(num)
    }

    list.sortDescending()
    var max = list[0]
    for(i in 1 until list.size) {
        if(max < list[i] * (i+1)) {
            max = list[i] * (i+1)
        }
    }
    bw.write("$max")
    bw.flush()
}