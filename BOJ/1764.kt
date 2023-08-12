import java.io.*
import java.util.*

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = StringTokenizer(br.readLine())
    val n = input.nextToken().toInt()
    val m = input.nextToken().toInt()
    val array = arrayListOf<String>()

    val hashMap = hashMapOf<String,Boolean>()

    repeat(n) {
        val person = br.readLine()
        hashMap.put(person,false)
    }

    repeat(m) {
        // 보도못한 사람이 hashMap에 담겨있으면 value값을 true로 변경
        val person = br.readLine()
        if(hashMap.containsKey(person)) {
            hashMap.replace(person, true)
            array.add(person)
        }
    }

    array.sort()

    bw.write("${array.size}\n")

    for(i in array) {
        bw.write("${i}\n")
    }

    bw.flush()

}