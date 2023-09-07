import java.io.*

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val array = arrayListOf<Pair<Int, Int>>()

    // 배열 초기화
    repeat(n) {
        val (x, y) = br.readLine().toString().split(" ").map {it.toInt()}
        array.add(Pair(x,y))
    }

    // X 좌표가 가장 큰 인덱스 찾기
    val endIndex = array.maxBy {it.first}

    // (0~마지막 X좌표 까지의 배열 생성)
    val arrayColumn = Array(endIndex.first+1) {Pair(0,0)}

    // 각 x좌표에 기둥 생성
    for(i in array) {
        arrayColumn[i.first] = i
    }

    val maxIndex = arrayColumn.indexOf(arrayColumn.maxBy {it.second})

    var currentMax = -1
    var sum = 0

    for(i in 0 until maxIndex) {
        // 현재 막대가 지금까지 제일 큰 막대보다 크면 넓이에 더하기
        if(arrayColumn[i].second > currentMax) {
            currentMax = arrayColumn[i].second
            sum += currentMax
            // 현재 막대가 더 작으면 지금까지 제일 큰 막대의 넓이 더하기
        } else {
            sum += currentMax
        }
    }

    currentMax = -1

    for(i in arrayColumn.size-1 downTo maxIndex+1) {
        if(arrayColumn[i].second > currentMax) {
            currentMax = arrayColumn[i].second
            sum += currentMax
        } else {
            sum += currentMax
        }
    }

    sum += arrayColumn[maxIndex].second

    bw.write("$sum")
    bw.flush()
}