package ua.org.dector.s2d.struct

/**
 * @author dector (dector9@gmail.com)
 */

class Physical
{
    def this(physical: Physical) =
    {
        this()
        Vx = physical.Vx
        Vy = physical.Vy
        ax = physical.ax
        ay = physical.ay
    }

    var Vx = 0f
    var Vy = 0f
    var ax = 0f
    var ay = 0f

    // TODO: Implement forces
    // TODO: Make global physics (as World physics + exceptions for entities)
    var gravityax = 0f
    var gravityay = 0f

    var frictionXCoef = 1f
    var frictionYCoef = 1f

    def Vx_= (Vx: Int) { this.Vx = Vx.toFloat }
    def Vy_= (Vy: Int) { this.Vy = Vy.toFloat }
    def ax_= (ax: Int) { this.ax = ax.toFloat }
    def ay_= (ay: Int) { this.ay = ay.toFloat }

    def update(dt: Int, entity: Entity)
    {
        val t = dt.toFloat / 1000

        Vx = (Vx + (ax + gravityax) * t) * frictionXCoef
        Vy = (Vy + (ay + gravityay) * t) * frictionYCoef

        val newX = entity.x + Vx * t
        val newY = entity.y + Vy * t

        entity.x = newX
        entity.y = newY
    }
}

object Physical
{
    val Default_Friction_Coef = 0.975f
}
