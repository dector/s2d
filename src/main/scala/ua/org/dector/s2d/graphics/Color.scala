package ua.org.dector.s2d.graphics

/**
 * Drawing color structure
 *
 * @author dector (dector9@gmail.com)
 */

class Color(val r: Float = Color.Default_Red,
            val g: Float = Color.Default_Green,
            val b: Float = Color.Default_Blue,
            val a: Float = Color.Default_Alpha)
{
    def this(c: Color) = this(c.r, c.g, c.b, c.a)
}

object Color
{
    private val Default_Red     = 1
    private val Default_Green   = 1
    private val Default_Blue    = 1
    private val Default_Alpha   = 1

    val Red     = Color(1, 0, 0, 1)
    val Green   = Color(0, 1, 0, 1)
    val Blue    = Color(0, 0, 1, 1)
    val White   = Color(1, 1, 1, 1)
    val Black   = Color(0, 0, 0, 1)

    def apply(r: Float, g: Float, b: Float)             = new Color(r, g, b)
    def apply(r: Float, g: Float, b: Float, a: Float)   = new Color(r, g, b, a)
}
