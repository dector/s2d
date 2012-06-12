package ua.org.dector.s2d.physics

/**
 * @author dector (dector9@gmail.com)
 */

trait Physics
{
    def countPos(pos: Float, V: Float, t: Float): Float
    def countVelocity(V: Float, a: Float, t: Float, oneOnFriction: Float = 1): Float
}
