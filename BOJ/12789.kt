import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args : Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var canGive = true
    val n = br.readLine().toInt()
    val people = StringTokenizer(br.readLine())
    val stack = Stack<Int>()
    val queue = ArrayDeque<Int>()
    var count = 1

    for(i in 0 until n) {
        val k = people.nextToken().toInt()
        queue.add(k)
    }


    while(!queue.isEmpty()) {

        if(!stack.isEmpty() && stack.peek() == count) {
            stack.pop()
            count++
            continue
        }

        val k = queue.poll()
        if(count == k) {
            count++
            continue
        }
        stack.push(k)
    }

    if(stack.size > 0) {
        while(!stack.isEmpty()) {
            if(stack.peek() == count) {
                stack.pop()
                count++
            } else {
                break
            }
        }
    }

    if(stack.size == 0) {
        bw.write("Nice")
    } else {
        bw.write("Sad")
    }

    bw.flush()
}
