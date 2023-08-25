import java.io.*
import java.util.*
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var list = arrayListOf<String>()
    val input = br.readLine().toString()
    for(i in 0 until input.length-2) {
        val a = input.substring(0,i+1)
        for(j in i+1 until input.length-1) {
            val sb = StringBuilder()
            val b = input.substring(i+1, j+1)
            val c = input.substring(j+1,input.length)
            sb.append(a.reversed()).append(b.reversed()).append(c.reversed())
            list.add("$sb")
        }
    }
    list.sort()
    bw.write(list[0])
    bw.flush()
}






