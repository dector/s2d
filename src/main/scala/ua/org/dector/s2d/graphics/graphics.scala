package ua.org.dector.s2d

import org.lwjgl.opengl.GL11._

/**
 * @author dector (dector9@gmail.com)
 */

package object graphics
{
    def drawSprite(x: Int, y: Int, sprite: Sprite)
    {
        glEnable(GL_TEXTURE_2D)
        glColor3f(1, 1, 1)
        glBindTexture(GL_TEXTURE_2D, sprite.spriteList.texture.id)
        glBegin(GL_QUADS)

        glTexCoord2f(sprite.textureX, sprite.textureY)
        glVertex2f(x, y + sprite.height)
        glTexCoord2f(sprite.textureX + sprite.textureWidth, sprite.textureY)
        glVertex2f(x + sprite.width, y + sprite.height)
        glTexCoord2f(sprite.textureX + sprite.textureWidth,
            sprite.textureY + sprite.textureHeight)
        glVertex2f(x + sprite.width, y)
        glTexCoord2f(sprite.textureX, sprite.textureY + sprite.textureHeight)
        glVertex2f(x, y)

        glEnd()
        glDisable(GL_TEXTURE_2D)
    }
}
