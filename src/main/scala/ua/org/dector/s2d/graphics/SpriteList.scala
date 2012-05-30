package ua.org.dector.s2d.graphics

/**
 * @author dector (dector9@gmail.com)
 */

class SpriteList(val texture: Texture,
                 val width: Int,
                 val height: Int)
{
    def this(texture: Texture) = this(texture, texture.width, texture.height)
}
