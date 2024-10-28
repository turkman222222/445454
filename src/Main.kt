import kotlin.math.sqrt
import kotlin.math.pow
import kotlin.math.abs

fun main() {

    println("сколько точек хотите создать?")
    val valueOfDots = readln()?.toInt() ?: throw IllegalArgumentException("неверный ввод")
    val dots:MutableSet<Dot> = mutableSetOf()

    //запихиваем рандомные точки в сет
    while (dots.size != valueOfDots) {

        val x = (1..100).random().toDouble()
        val y = (1..100).random().toDouble()

        dots.add(Dot(x, y))
    }


    var minDist:Double = Double.MAX_VALUE
    for (dot1 in dots) {
        for (dot2 in dots) {
            if (dot1 != dot2) {

                val dist = sqrt(abs((dot1._X - dot2._X)).pow(2) + abs((dot1._Y - dot2._Y)).pow(2))
                if (dist < minDist) minDist = dist
            }
        }
    }

    var maxDist:Double = Double.MIN_VALUE
    for (dot1 in dots) {
        for (dot2 in dots) {
            if (dot1 != dot2) {

                val dist = sqrt((abs((dot1._X - dot2._X)).pow(2)) + (abs((dot1._Y - dot2._Y)).pow(2)))
                if (dist > maxDist) maxDist = dist
            }
        }
    }

    //println(dots.toString())
    println("минимальное расстояние между точками:\t$minDist\nмаксимальное расстояние между точками: $maxDist")

}


class Dot(X:Double, Y:Double){

    public val _X = X
    public val _Y = Y

    override fun toString(): String {
        return "(${_X.toInt()}, ${_Y.toInt()})"
    }
}