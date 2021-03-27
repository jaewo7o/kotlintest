fun main() {
    // print
    print("Hello World")

    // 변수형변환
    println("## type change")
    var a: Int = 123
    var b: Long = a.toLong()
    var c = 123 // 타입추론기능 사용
    print(c)

    // 배열
    println("## array")
    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5)

    intArr[3] = 8
    println(intArr[3])

    // 함수
    println("## function")
    println(add(1, 2, 3))
    println(add2(1, 2, 3))

    // 조건문
    println("## condition")
    if (a > 10) {
        println("a는 10보다 크다")
    } else {
        println("a는 10보다 작다.")
    }

    doWhen(a);

    // 반복문
    println("## loop")
    for (i in 1..9) {
        if (i == 3) break
        println(i)
    }

    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i == 1 && j == 2) break@loop
            println("i : $i, j: $j")
        }
    }

    println("## class")
    var persona = Person("이름1", 1990)
    println("안녕하세요, ${persona.birthYear}년생 ${persona.name}입니다.")
    persona.introduce()

    var personb = Person("이름2")
    personb.introduce()

    var dog = Dog("녀석이", 15)
    dog.bark()
    dog.eat()
}

open class Animal(var name: String, var age: Int, var type: String) {
    fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살 입니다.")
    }

    open fun eat() {
        println("음식을 먹습니다.")
    }
}

class Dog(name: String, age: Int) : Animal(name, age, "개") {
    fun bark() {
        println("멍멍")
    }

    override fun eat() {
        println("개밥을 먹습니다.")
    }
}

class Person(var name: String, val birthYear: Int) {
    init {
        println("name : ${name}")
    }

    constructor(name: String) : this(name, 1990)

    fun introduce() {
        println("안녕하세요, ${birthYear}년생 ${name}입니다.")
    }
}

fun doWhen(a: Any) {
    var result = when (a) {
        1 -> "정수 1입니다."
        "Jaewoo" -> "이름이 입력되었습니다."
        is Int -> "Int 형이 입력되었씁니다."
        !is String -> "문자열이 아닙니다."
        else -> "해당사항이 없습니다."
    }

    println(result)
}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun add2(a: Int, b: Int, c: Int) = a + b + c