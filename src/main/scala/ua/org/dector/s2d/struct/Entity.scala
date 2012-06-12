package ua.org.dector.s2d.struct

import java.util.HashMap
import ua.org.dector.s2d.events.{Event, KeyEventState}

/**
 * @author dector (dector9@gmail.com)
 */

class Entity(val eType: Type,
             var x: Float,
             var y: Float,
             val name: String,
             var z: Int = 0)
{
    var physical = new Physical

    def this(eType: Type, x: Float, y: Float, z: Int = 0) =
        this(eType, x + eType.rendered.offsetX, y + eType.rendered.offsetY,
        eType.name + eType.nextId(), z)

    def render(dt: Int)
    {
        eType.rendered.render(dt, x.toInt, y.toInt)
    }

    def addKeyboardEvent(eventType: KeyEventState.KeyEventState, eventKey: Int,
                         exec: (Entity) => Unit)
    {
        World.addKeyboardEvent(this, eventType, eventKey, exec)
    }

    def removeKeyboardEvent(eventType: KeyEventState.KeyEventState, eventKey: Int)
    {
        World.removeKeyboardEvent(this, eventType, eventKey)
    }

//    def onEvent(event: Event)
//    {
//
//    }

    def updatePhysics(dt: Int)
    {
        physical.update(dt, this)
    }
}
