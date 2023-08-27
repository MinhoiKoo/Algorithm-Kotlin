import java.io.*
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
lateinit var graph : Array<MutableList<Int>>
lateinit var visited : Array<Boolean>
var count = 0
var maxL = 0
var n = -1
var m = -1
fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val stack = Stack<Char>()
    val input = br.readLine().toString()

    var count = 0

    for(i in input.indices) {
        when(input[i]) {
            // 현재 막대기 길이 1 추가
            '(' -> stack.add(input[i])
            else -> {
                // 현재 막대기 길이 -1
                stack.pop()
                // 레이저인 경우
                if((i-1) > 0 && input[i-1] == '(') {
                    count+=stack.size
                }
//                막대기 끝인 경우
                else if((i-1) > 0 && input[i-1] == ')') {
//                    막대기 개수 추가
                    count++
                }
            }
        }
    }

    bw.write("$count")
    bw.flush()



}






