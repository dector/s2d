package ua.org.dector.s2d.graphics

/**
 * @author dector (dector9@gmail.com)
 */

class Texture(private val texture: org.newdawn.slick.opengl.Texture)
{
    def id = texture.getTextureID
    def width = texture.getImageWidth
    def height = texture.getImageHeight

    def textureWidth = texture.getTextureWidth
    def textureHeight = texture.getTextureHeight
}
