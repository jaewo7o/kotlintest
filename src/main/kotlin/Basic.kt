fun main() {
    // print
    print("Hello World")

    // 변수형변환
    var a: Int = 123
    var b: Long = a.toLong()
    var c = 123 // 타입추론기능 사용
    print(c)

    // 배열
    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5)

    intArr[3] = 8
    println(intArr[3])

    // 함수
    println(add(1, 2, 3))
    println(add2(1, 2, 3))

    // 조건문
    if (a > 10) {
        println("a는 10보다 크다")
    } else {
        println("a는 10보다 작다.")
    }

    doWhen(a)
}

fun doWhen(a: Any) {
    when (a) {
        1 -> println("정수 1입니다.")
        "Jaewoo" -> println("이름이 입력되었습니다.")
        is Int -> println("Int 형이 입력되었씁니다.")
        !is String -> println("문자열이 아닙니다.")
        else -> println("해당사항이 없습니다.")
    }
}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun add2(a: Int, b: Int, c: Int) = a + b + c