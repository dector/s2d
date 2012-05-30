package ua.org.dector.s2d.graphics

import ua.org.dector.s2d.graphics

/**
 * @author dector (dector9@gmail.com)
 */

class Sprite(val spriteList: SpriteList,
             val width: Int,
             val height: Int,
             val textureX: Float,
             val textureY: Float,
             val textureWidth: Float,
             val textureHeight: Float)
{
    def this(spriteList: SpriteList, width: Int, height: Int, textureX: Float = 0,
             textureY: Float = 0) =
        this(spriteList, width, height, textureX, textureY,
            width.toFloat / spriteList.texture.textureWidth,
            height.toFloat / spriteList.texture.textureHeight)

    def this(spriteList: SpriteList) = this(spriteList, spriteList.width, spriteList.height)

    def render(dt: Int, x: Int, y: Int)
    {
        graphics.drawSprite(x, y, this)
    }
}
