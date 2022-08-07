package com.datanapps.kotlin_utility.loggers

/*
* Created by Yogendra on 7/8/2022
*/

private const val STACK_TRACE_LEVELS_UP = 5

/**
 * Get the current line number. Note, this will only work as called from
 * this class as it has to go a predetermined number of steps up the stack
 * trace. In this case 5.
 *
 * @author Yogendra
 * @return int - Current line number.
 */
private fun getLineNumber(): Int {
    return Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].lineNumber
}

/**
 * Get the current class name. Note, this will only work as called from this
 * class as it has to go a predetermined number of steps up the stack trace.
 * In this case 5.
 *
 * @author Yogendra
 * @return String - Current line number.
 */
private fun getClassName(): String {
    val fileName = Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].fileName
    return fileName.substring(0, fileName.length )
}


/**
 * Get the current method name. Note, this will only work as called from
 * this class as it has to go a predetermined number of steps up the stack
 * trace. In this case 5.
 *
 * @author Yogendra
 * @return String - Current line number.
 */
private fun getMethodName(): String {
    return Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].methodName
}

/**
 * Returns the class name, method name, and line number from the currently
 * executing log call in the form .()-
 *
 * @author Yogendra
 * @return String - String representing class name, method name, and line
 * number.
 */
fun getClassNameMethodNameAndLineNumber(): String {
    return "[ ${getClassName()} -> ${ getMethodName() }() -> ${getLineNumber()} ] : "
}
