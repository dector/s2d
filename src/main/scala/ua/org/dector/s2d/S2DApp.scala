package ua.org.dector.s2d

import graphics.Graphics
import state.StateManager
import java.util.logging.Logger
import struct.World

/**
 * S2D application
 *
 * @author dector (dector9@gmail.com)
 */

abstract class S2DApp(val name: String = Lang.NonameApp)
        extends Runnable
{
    private var dt: Int = 0

    def create() {}

    final def init()
    {
        //        systemLoad()
        //        loadResources()
        Logger.getLogger(Settings.Logger_Name)
        Graphics.init()
        create()
    }

    final def loop()
    {
        //            checkInput()
        //            preRenderCount()
        //            systemCount()
        //            systemDraw()
        //            updateDisplay()
        render()
        Graphics.update()
    }

    final def render() { World.render(dt) }

    final def run()
    {
        init()
        while (! StateManager.isDone)
            loop()
        exit()
    }

    final def exit()
    {
        Graphics.destroy()
    }

    def main(args: Array[String])
    {
        run()
    }
}
