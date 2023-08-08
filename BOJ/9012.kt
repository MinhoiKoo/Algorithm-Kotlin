import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args : Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    repeat(n) {

        var count = 0

        val vps = br.readLine()
        for(i in vps){
            when(i){
                '(' -> count++
                ')' -> count--
            }
            if(count <0) break
        }

        if(count == 0){
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
        bw.flush()
    }
}
