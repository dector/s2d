package ua.org.dector.s2d

import events.KeyEventState
import graphics.{SpriteList, Sprite, Graphics}
import input.Keyboard
import struct._
import util.ResourceLoader

/**
 * @author dector (dector9@gmail.com)
 */

object S2DAppDemo extends S2DApp {
    override def create()
    {
        val texture = ResourceLoader.getTexture("test.png")
        val spriteList = new SpriteList(texture)
        val sprite  = new Sprite(spriteList)

        val entType = new Type("test", new Rendered(sprite), new Physical)
        val entity  = new Entity(entType, Graphics.width / 2, Graphics.height / 2)

        val scene   = new Scene(Graphics.width, Graphics.height)

        scene += entity
        World += scene

        // KeyboardEvent
        // MouseEvent
        // Other events

        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Left,
            (e: Entity) => { println("<- on " + e.name) })
        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Right,
            (e: Entity) => { println("-> on " + e.name) })

//        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Left,
//            (e: Entity) => { e.physical.velocityX = -5 })
//        entity.addKeyboardEvent.onKeyUp(Keyboard.Key_Left,
//            (e: Entity) => { e.physical.velocityX = 0 })
//        entity.addKeyboardEvent.onKeyDown(Keyboard.Key_Right,
//            (e: Entity) => { e.physical.velocityX = 5 })
//        entity.addKeyboardEvent.onKeyUp(Keyboard.Key_Right,
//            (e: Entity) => { e.physical.velocityX = 0 })

        World select entity
    }
}
