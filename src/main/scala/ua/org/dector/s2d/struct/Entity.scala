package ua.org.dector.s2d.struct

import java.util.HashMap
import ua.org.dector.s2d.events.{Event, KeyEventState}

/**
 * @author dector (dector9@gmail.com)
 */

class Entity(val eType: Type,
             var x: Int,
             var y: Int,
             val name: String,
             var z: Int = 0)
{
//    private val events = new HashMap[KeyEventState.type, (Entity, Event) => Unit]

    def this(eType: Type, x: Int, y: Int, z: Int = 0) =
        this(eType, x + eType.rendered.offsetX, y + eType.rendered.offsetY,
        eType.name + eType.nextId(), z)

    def render(dt: Int)
    {
        eType.rendered.render(dt, x, y)
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

    def onEvent(event: Event)
    {

    }
}
