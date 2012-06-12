package ua.org.dector.s2d.physics

/**
 * @author dector (dector9@gmail.com)
 */

object DefaultPhysics extends Physics
{
    val Gravity_Acceleration = 0f
    val One_On_Friction = 0.975f

    def countPos(pos: Float, V: Float, t: Float) =
        pos + V * t
    def countVelocity(V: Float, a: Float, t: Float, oneOnFriction: Float) =
        (V + a * t) * oneOnFriction
}
