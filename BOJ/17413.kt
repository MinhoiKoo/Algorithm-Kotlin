import java.io.*
import java.util.*

var count = 0
var count1 = 0
lateinit var graph : Array<MutableList<String>>

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine()
    var count = 0
    val sb = StringBuilder()
    val stack = Stack<Char>()

    for(i in input) {
        if(i == '<') {
            while(!stack.isEmpty()) {
                sb.append(stack.pop())
            }
            count++
        }
        if(i == '>') {
            count--
            sb.append('>')
            continue
        }

        // 태그 안 공백은 무시
        if(count == 1) {
            sb.append(i)
            continue
        } else {
            stack.add(i)
        }

        if(i ==' ') {
            stack.pop()
            while(!stack.isEmpty()) {
               sb.append(stack.pop())
            }
            sb.append(' ')
        }
    }

    while(!stack.isEmpty()) {
        sb.append(stack.pop())
    }
    bw.write(sb.toString())
    bw.flush()

}





