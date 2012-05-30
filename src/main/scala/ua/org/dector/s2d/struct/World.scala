package ua.org.dector.s2d.struct

import java.util.{TreeSet, LinkedList}


/**
 * @author dector (dector9@gmail.com)
 */

object World
{
    private val scenes = new TreeSet[Scene]
    private var currentScene: Scene = null

    def += (scene: Scene) {
        scenes.add(scene)

        if (currentScene == null) {
            currentScene = scene
        }
    }

    def render(dt: Int)
    {
        if (! scenes.isEmpty)
        {
            currentScene.render(dt)
        }
    }
}
