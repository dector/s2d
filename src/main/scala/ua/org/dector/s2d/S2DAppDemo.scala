package ua.org.dector.s2d

import graphics.{SpriteList, Sprite, Graphics}
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
    }
}
