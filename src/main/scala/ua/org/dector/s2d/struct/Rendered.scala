package ua.org.dector.s2d.struct

import ua.org.dector.s2d.graphics.Sprite

/**
 * @author dector (dector9@gmail.com)
 */

class Rendered(var sprite: Sprite, val offsetX: Int, val offsetY: Int)
{
    // Only state independent code!

    def this(sprite: Sprite) =
        this(sprite, - sprite.width / 2, - sprite.height / 2)

    def render(dt: Int, x: Int, y: Int)
    {
        sprite.render(dt, x, y)
    }
}