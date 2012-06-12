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

    def Vx_= (Vx: Int) { this.Vx = Vx.toFloat }
    def Vy_= (Vy: Int) { this.Vy = Vy.toFloat }
    def ax_= (ax: Int) { this.ax = ax.toFloat }
    def ay_= (ay: Int) { this.ay = ay.toFloat }

    def update(dt: Int, entity: Entity)
    {
        val t = dt.toFloat / 1000

        Vx = World.physics.countVelocity(Vx, ax, t, World.physics.One_On_Friction)
        Vy = World.physics.countVelocity(Vy, ay, t + World.physics.Gravity_Acceleration,
            World.physics.One_On_Friction)

        entity.x = World.physics.countPos(entity.x, Vx, t)
        entity.y = World.physics.countPos(entity.y, Vy, t)
    }
}