package Extensions

import java.util.regex.Pattern

fun String.isEmailValid(): Boolean {
    val expression = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}


fun String.isPassWordValid(): Boolean {
    val expression = "^[A-Za-z](.*)([@#$%](.*))([0-9](.*)).{3,}"

    //val expression = "/^(?=.*\\d)(?=.*[A-Z])([@\$%&#])[0-9a-zA-Z]{4,}$/"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}
fun String.isNamevalid(): Boolean {
    val expression = "^[A-Za-z](.*)"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}