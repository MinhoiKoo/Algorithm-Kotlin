import java.io.*
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine().toString()
    val list = arrayListOf<Char>()
    for(i in input) {
        list.add(i)
    }

    for(i in input.length-1 downTo 0) {
        list.add(input[i])
    }

    var min = -1

    while(true) {
        val sb = StringBuilder()

        if(list.size == 0) {
            break
        }
        for(i in list) {
            sb.append(i)
        }

        if(sb.toString().contains(input)) {
            min = list.size
        }

        val size = list.size/2
        list.removeAt(size)
    }

    bw.write("${min}")
    bw.flush()

}






