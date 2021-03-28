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

    println("\n## collection 1")
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

    println("## function advance")
    deliveryItem("짬뽕")
    deliveryItem("책", 3)
    deliveryItem("노트북", 30, "학교")
    deliveryItem("선물", destination = "친구집")

    sum(1, 2, 3, 5)

    println("## nested & inner class")
    Outer.Nested().introduce()

    val outer = Outer()
    val inner = outer.Inner()

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Change Outer Class"
    inner.introduceOuter()

    println("## data class")
    val jaewoo = PersonData(1, "정재우")
    println(jaewoo == PersonData(1, "정재우"))
    println(jaewoo.hashCode())
    println(jaewoo)

    println(jaewoo.copy())
    println(jaewoo.copy(name = "정다솜"))

    val family = listOf(
        PersonData(1, "정재우"),
        PersonData(2, "고혜진"),
        PersonData(3, "정다솜"),
        PersonData(4, "정한별"),
        PersonData(5, "정진우")
    )

    for (person in family) {
        println("1. id : ${person.id}, 이름 : ${person.name}")
    }

    for ((x1, x2) in family) {
        println("2. id : $x1, 이름 : $x2")
    }

    println("## enum class")
    val state = State.SLEEP
    println(state.message)
    println(state.isSleeping())

    println("\n## collection 2")
    val fruitSet = mutableSetOf("귤", "바나나", "키위")
    for (item in fruitSet) {
        println("$item")
    }

    println(fruitSet.contains("귤"))

    val albumns = mutableMapOf(
        "레드벨벳" to "음파음파", "트와이스" to "FANCY", "ITZY" to "ICY"
    )

    for (albumn in albumns) {
        println("${albumn.key}:${albumn.value}")
    }

    albumns.put("오마이걸", "번지")
    println(albumns)

    println(albumns["오마이걸"])

    println("## collection function")

    val names = listOf("정재우", "고혜진", "정다솜", "정한별", "정진우")
    names.forEach({ print(it + " ") })

    println()
    println(names.filter { it.startsWith("고") })
    println(names.map { "이름 : $it" })
    println(names.any { it == "정재우" })
    println(names.all { it.startsWith("정") })

    data class Idol(val name: String, val birthYear: Int)

    val idols = listOf(
        Idol("바니", 1996),
        Idol("조이", 1996),
        Idol("츄", 1999),
        Idol("유나", 2003)
    )

    println(idols.associateBy { it.name })
    println(idols.groupBy { it.birthYear })

    val (over98, under98) = idols.partition { it.birthYear > 1998 }
    println(over98)
    println(under98)

    val numbers2 = listOf(-1, 3, 2, 10, 9)
    println(numbers2.flatMap { listOf(it * 10, it + 1) })
    println(numbers2.getOrElse(10) { 100 })

    println("## variable, constant")
    val foodCourt = FootCourt()
    foodCourt.searchPrice(FootCourt.FOOD_PIZZA)
    foodCourt.searchPrice(FootCourt.FOOD_STEAK)
    foodCourt.searchPrice(FootCourt.FOOD_PASTA)

    val lateInit = LateInitSample();
    println(lateInit.getLateInitText())

    lateInit.text = "값할당"
    println(lateInit.getLateInitText())
    
}

class LateInitSample {
    lateinit var text: String

    fun getLateInitText(): String {
        if (::text.isInitialized) {
            return text
        } else {
            return "기본값"
        }
    }
}

class FootCourt {
    fun searchPrice(name: String) {
        val price = when (name) {
            FOOD_PASTA -> 2000
            FOOD_STEAK -> 13000
            FOOD_PIZZA -> 11000
            else -> 0
        }

        println("${name}의 가격은 ${price}입니다.")
    }

    companion object {
        const val FOOD_PASTA = "파스트"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}

enum class State(val message: String) {
    SING("노래를 부릅니다."),
    EAT("밥을 먹습니다."),
    SLEEP("잠을 잡니다.");

    fun isSleeping() = this == SLEEP
}

data

class PersonData(
    val id: Int,
    val name: String
)

class Outer {
    var text = "Outer Class"

    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }

    inner class Inner {
        var text = "Inner Class"

        fun introduceInner() {
            println(text)
        }

        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}

fun sum(vararg numbers: Int) {
    var sum = 0
    for (number in numbers) {
        sum += number
    }

    println(sum)
}

fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
    println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
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