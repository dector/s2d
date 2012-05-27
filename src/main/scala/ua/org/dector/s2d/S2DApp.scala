package ua.org.dector.s2d

import graphics.Graphics
import state.StateManager
import java.util.logging.Logger

/**
 * S2D application
 *
 * @author dector (dector9@gmail.com)
 */

abstract class S2DApp(val name: String = Lang.NonameApp)
        extends Runnable
{
    private var dt: Int = 0

    final def onInit( initFunc: () => Unit = { () =>
            Logger.getLogger(Settings.Logger_Name)
            Graphics.init()
        //        systemLoad()
        //        loadResources()

    } ) { initFunc() }

    final def onLoop( loopFunc: () => Unit = { () =>
        //            checkInput()
        //            preRenderCount()
        //            systemCount()
        render()
        //            systemDraw()
        //            updateDisplay()
        Graphics.update()
    } ) { loopFunc() }

    final def render( renderFunc: (Int) => Unit = (Int) => Unit ) { renderFunc(dt) }

    final def run()
    {
        onInit()
        while (! StateManager.isDone)
            onLoop()
        onExit()
    }

    final def onExit( exitFunc: () => Unit = () => Unit )
    {
        exitFunc()
        Graphics.destroy()
    }

    def main(args: Array[String])
    {
        run()
    }
}
