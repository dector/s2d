package ua.org.dector.s2d.util

import java.awt.Image
import javax.imageio.ImageIO
import java.io.{IOException, File}
import ua.org.dector.s2d.Settings
import java.util.logging.{Level, Logger}
import ua.org.dector.s2d.graphics.Texture

/**
 * @author dector (dector9@gmail.com)
 */

object ResourceLoader {
    def getTexture(filename: String): Texture =
    {
        // TODO: Use own loader
        val format = filename.substring(filename.lastIndexOf(".") + 1,
            filename.length).toUpperCase
        val slickTexture = org.newdawn.slick.opengl.TextureLoader.getTexture(format,
            org.newdawn.slick.util.ResourceLoader.getResourceAsStream(filename))
        new Texture(slickTexture)
    }

    def getImage(filename: String): Image =
    {
        try
        {
            ImageIO.read(new File(filename))
        }
        catch
        {
            case e: IOException =>
                Logger.getLogger(Settings.Logger_Name).log(Level.ALL,
                    "Image " + filename + " not found"); null
        }
    }
}
