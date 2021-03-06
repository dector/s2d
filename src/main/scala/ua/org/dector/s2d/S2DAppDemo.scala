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

        val entType = new Type("test", new Rendered(sprite))
        val entity  = new Entity(entType, Graphics.width / 2, Graphics.height / 2)
        entity.physical.frictionXCoef = Physical.Default_Friction_Coef
        entity.physical.frictionYCoef = Physical.Default_Friction_Coef

        val scene   = new Scene(Graphics.width, Graphics.height)

        scene += entity
        World += scene

        // KeyboardEvent
        // MouseEvent
        // Other events

        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Left,
            (e: Entity) => { e.physical.ax = -350 })
        entity.addKeyboardEvent(KeyEventState.Key_Up, Keyboard.Key_Left,
            (e: Entity) => { e.physical.ax = 0 })
        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Right,
            (e: Entity) => { e.physical.ax = 350 })
        entity.addKeyboardEvent(KeyEventState.Key_Up, Keyboard.Key_Right,
            (e: Entity) => { e.physical.ax = 0 })

        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Down,
            (e: Entity) => { e.physical.ay = -150 })
        entity.addKeyboardEvent(KeyEventState.Key_Up, Keyboard.Key_Down,
            (e: Entity) => { e.physical.ay = 0 })
        entity.addKeyboardEvent(KeyEventState.Key_Down, Keyboard.Key_Up,
            (e: Entity) => { e.physical.ay = 150 })
        entity.addKeyboardEvent(KeyEventState.Key_Up, Keyboard.Key_Up,
            (e: Entity) => { e.physical.ay = 0 })

        World select entity
    }
}
