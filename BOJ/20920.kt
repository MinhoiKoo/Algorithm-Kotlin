import java.io.*
import java.util.*

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = StringTokenizer(br.readLine())
    val n = input.nextToken().toInt()
    val m = input.nextToken().toInt()

    val treeMap = TreeMap<String, Int>()
    val list = arrayListOf<Pair<String, Int>>()
    repeat(n) {
        val word = br.readLine()!!
        if(word.length >= m) {
            if(treeMap.containsKey(word)) {
                treeMap.replace(word, treeMap.getValue(word)!! +1)
            } else {
                treeMap.put(word,0)
            }
        }
    }

    treeMap.forEach {
        list.add(Pair(it.key, it.value))
    }
    list.sortWith(compareBy<Pair<String, Int>> {it.second}.thenBy{it.first.length}.thenByDescending{it.first})
    list.reverse()

    for (i in list) {
        bw.write("${i.first}\n")
    }
    bw.flush()
}