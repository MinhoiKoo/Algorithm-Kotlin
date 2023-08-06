import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args : Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = arrayListOf<Int>()

    val k = br.readLine().toInt()

    repeat(k) {
        when(val input = br.readLine()!!.toInt()) {
            0 -> stack.removeAt(stack.size-1)
            else -> {
                stack.add(input)
            }
        }
    }

    bw.write(stack.sum().toString())
    bw.flush()
}
