fun main() {
    // print
    println("Hello World\n")

    // 변수형변환
    println("\n## type change")
    var a: Int = 123
    var b: Long = a.toLong()
    var c = 123 // 타입추론기능 사용
    println("a : ${a}, b : ${b}, c : ${c}")

    // 배열
    println("\n## array")
    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5)

    intArr[3] = 8
    println(intArr[3])

    // 함수
    println("\n## function")
    println(add(1, 2, 3))
    println(add2(1, 2, 3))

    // 조건문
    println("\n## condition")
    if (a > 10) {
        println("a는 10보다 크다")
    } else {
        println("a는 10보다 작다.")
    }

    doWhen(a);

    // 반복문
    println("\n## loop")
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

    println("\n## class")
    var persona = Person("이름1", 1990)
    println("안녕하세요, ${persona.birthYear}년생 ${persona.name}입니다.")
    persona.introduce()

    var personb = Person("이름2")
    personb.introduce()

    var dog = Dog("녀석이", 15)
    dog.introduce()
    dog.bark()
    dog.eat()
    dog.sniff()
    dog.run()

    println("\n## high order function")
    funb(::funa)

    val func: (String) -> Unit = { param -> println("$param 람다함수") }
    funb(func)

    println("\n## scope function")

    var book = Book("책이름", 10000)
    printBookInfo(book)

    println("last book info: name = ${book.name}, price = ${book.price}")

    book.run {
        println("상품명 : ${name}, 가격 : ${price}원")
    }

    var price = 5000
    book.let {
        println("상품명 : ${it.name}, 가격 : ${it.price}원")
    }

    println("\n## object")
    println(Counter.count)

    Counter.countUp()
    Counter.countUp()
    println(Counter.count)

    Counter.clear()
    println(Counter.count)

    var food1 = FoodPool("짜장")
    var food2 = FoodPool("짬뽕")

    food1.vote()
    food1.vote()

    food2.vote()
    food2.vote()
    food2.vote()

    println("${food1.name} : ${food1.count}")
    println("${food2.name} : ${food2.count}")
    println("총계 : ${FoodPool.total}")

    println("\n## list")
    var fruits = listOf("사과", "귤", "딸기")
    println(fruits[2])

    for (fruit in fruits) {
        print("${fruit}:")
    }

    var numbers = mutableListOf(6, 3, 1)
    println("\n" + numbers)

    numbers.add(4)
    println(numbers)

    println("## string")
    val testString = "Test.Kotlin.String"

    println(testString.length)

    println(testString.toLowerCase())
    println(testString.toUpperCase())

    val stringTokens = testString.split(".")
    println(stringTokens)

    println(stringTokens.joinToString())
    println(stringTokens.joinToString("-"))

    println(testString.substring(5..10))

    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    println(nullString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankString.isNullOrEmpty())
    println(normalString.isNullOrEmpty())

    println()

    println(nullString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankString.isNullOrBlank())
    println(normalString.isNullOrBlank())

    println()

    println(nullString?.toUpperCase())
    println(nullString ?: "default".toUpperCase())
    //println(nullString!!.toUpperCase()) // null point exception 처리

    nullString?.run {
        println(toUpperCase())
        println(toLowerCase())
    }

    var book1 = Book("책1", 2000)
    var book2 = Book("책1", 2000)
    var book3 = book1

    println(book1 == book2)
    println(book1 === book2)
    println(book1 == book3)
    println(book1 === book3)
}

class FoodPool(
    val name: String
) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        count++
        total++
    }
}

object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}

fun printBookInfo(book: Book) {
    book.apply {
        name = "[초특가]" + name
        discount()
    }

    println("first book info: name = ${book.name}, price = ${book.price}")
}

class Book(
    var name: String,
    var price: Int
) {
    fun discount() {
        price -= 2000
    }

    override fun equals(other: Any?): Boolean {
        if (other is Book) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}

fun funa(param: String) {
    println("$param 함수 funa")
}

fun funb(function: (String) -> Unit) {
    function("b가 호출한")
}

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("interface 음식을 먹습니다.")
    }
}

abstract class Animal(var name: String, var age: Int, var type: String) {
    fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살 입니다.")
    }

    open fun eat() {
        println("음식을 먹습니다.")
    }

    abstract fun sniff()
}

class Dog(name: String, age: Int) : Animal(name, age, "개"), Runner, Eater {
    fun bark() {
        println("멍멍")
    }

    override fun eat() {
        println("개밥을 먹습니다.")
    }

    override fun sniff() {
        println("킁킁")
    }

    override fun run() {
        println("빠르게 달립니다.")
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