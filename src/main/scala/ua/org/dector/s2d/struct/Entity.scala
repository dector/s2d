package ua.org.dector.s2d.struct

/**
 * @author dector (dector9@gmail.com)
 */

class Entity(val eType: Type,
             var x: Int,
             var y: Int,
             val name: String,
             var z: Int = 0)
{

    def this(eType: Type, x: Int, y: Int, z: Int = 0) =
        this(eType, x + eType.rendered.offsetX, y + eType.rendered.offsetY,
        eType.name + eType.nextId(), z)

    def render(dt: Int)
    {
        eType.rendered.render(dt, x, y)
    }
}
