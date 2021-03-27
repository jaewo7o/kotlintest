fun main() {
    // print
    print("Hello World")

    // 변수형변환
    var a: Int = 123
    var b: Long = a.toLong()

    // 배열
    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5)

    intArr[3] = 8
    println(intArr[3])
    

}