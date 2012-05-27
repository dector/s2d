package ua.org.dector.s2d.graphics

import org.lwjgl.opengl.GL11._
import ua.org.dector.s2d.Settings._
import org.lwjgl.opengl.{DisplayMode, Display}
import ua.org.dector.s2d.state.StateManager

/**
 * @author dector (dector9@gmail.com)
 */

object Graphics
{
    val width       = Default_Screen_Width
    val height      = Default_Screen_Height
    val fullScreen  = Default_Full_Screen
    val syncFreq    = Default_Sync_Freq

    var clearColor  = Color.Black
    var title       = ""

    private def initDisplay()
    {
        Display.setDisplayMode(new DisplayMode(width, height))
        Display.setFullscreen(fullScreen)
        Display.setTitle(title)
        Display.create()
    }

    private def initOGL()
    {
        glDisable(GL_DEPTH_TEST)
        glDisable(GL_LIGHTING)

        glEnable(GL_BLEND)
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)

        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glOrtho(0, width, 0, height, -1, 1)
        glMatrixMode(GL_MODELVIEW)

        glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a)
    }

    def init(width: Int = Default_Screen_Width,
             height: Int = Default_Screen_Height,
             fullScreen: Boolean = Default_Full_Screen,
             syncRate: Int = Default_Sync_Freq)
    {
        initDisplay()
        initOGL()
        println("Graphics init")
    }

    def update()
    {
        Display.update()
        Display.sync(syncFreq)

        glClear(GL_COLOR_BUFFER_BIT)

        if (Display.isCloseRequested) StateManager.setDone()
    }

    def destroy()
    {
        Display.destroy()
    }
}