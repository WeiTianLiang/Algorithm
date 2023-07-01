package Stack

import java.util.Stack

/**
 * 剑指 OfferII 36 medium
 * 后缀表达式
 */
private fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    tokens.forEach {
        if (it.isDigit()) {
            stack.push(it.toInt())
        } else {
            val value1 = stack.pop()
            val value2 = stack.pop()
            stack.push(calculate(it, value2, value1))
        }
    }

    return stack.pop()
}

private fun String.isDigit(): Boolean {
    val arr = this.toCharArray()
    if (arr.size == 1) {
        return arr[0].isDigit()
    }
    if (arr[0] == '-') {
        for (i in 1 until arr.size) {
            if (!arr[i].isDigit()) {
                return false
            }
        }
    } else {
        this.toCharArray().forEach {
            if (!it.isDigit()) {
                return false
            }
        }
    }
    return true
}

private fun calculate(symbol: String, value1: Int, value2: Int): Int {
    when(symbol) {
        "+" -> {
            return value1 + value2
        }
        "-" -> {
            return value1 - value2
        }
        "*" -> {
            return value1 * value2
        }
        "/" -> {
            return value1 / value2
        }
    }
    return 0
}

fun main() {
    println(evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(evalRPN(arrayOf("4", "13", "5", "/", "+")))
    println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}