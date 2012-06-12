package ua.org.dector.s2d.input

import org.lwjgl.input.{Keyboard => LWJGLKeyboard}
import ua.org.dector.s2d.events.KeyEventState

/**
 * @author dector (dector9@gmail.com)
 */

object InputManager
{
    def next() = LWJGLKeyboard.next()
    def keyEvent =
        (if (LWJGLKeyboard.getEventKeyState)
            KeyEventState.Key_Down
        else
            KeyEventState.Key_Up
        , LWJGLKeyboard.getEventKey)

    def isKeyDown(button: Int): Boolean = LWJGLKeyboard.isKeyDown(button)
}
