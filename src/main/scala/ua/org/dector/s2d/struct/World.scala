package ua.org.dector.s2d.struct

import java.util.{HashMap, TreeSet, LinkedList}
import ua.org.dector.s2d.events.KeyEventState

/**
 * @author dector (dector9@gmail.com)
 */

object World
{
    private val selected = new LinkedList[Entity]

    private val keyboardEvents = new HashMap[(KeyEventState.KeyEventState, Int),
            java.util.List[(Entity, (Entity) => Unit)]]

    private val scenes = new TreeSet[Scene]
    private var currentScene: Scene = null

    def += (scene: Scene) {
        scenes.add(scene)

        if (currentScene == null) {
            currentScene = scene
        }
    }

    def select(entity: Entity)
    {
        if (! selected.contains(entity))
            selected.add(entity)
    }

    def deselect(entity: Entity)
    {
        selected.remove(entity)
    }

    def render(dt: Int)
    {
        if (currentScene != null)
        {
            currentScene.render(dt)
        }
    }

    def addKeyboardEvent(entity: Entity, eventType: KeyEventState.KeyEventState, eventKey: Int,
                         exec: (Entity) => Unit)
    {
        if (! keyboardEvents.containsKey((eventType, eventKey))
                || keyboardEvents.get ((eventType, eventKey)) == null)
        {
            keyboardEvents.put((eventType, eventKey),
                new LinkedList[(Entity, (Entity) => Unit)])
        }

        keyboardEvents.get((eventType, eventKey)).add((entity, exec))
    }

    def removeKeyboardEvent(entity: Entity, eventType: KeyEventState.KeyEventState, eventKey: Int)
    {
        println("Implement it")
//        keyboardEvents.get((eventType, eventKey)).remove(entity)
    }

    def processInput(keyEvent: (KeyEventState.KeyEventState, Int))
    {
        if (keyboardEvents.containsKey(keyEvent) && keyboardEvents.get(keyEvent) != null)
        {
            val iter = keyboardEvents.get(keyEvent).iterator()

            while (iter.hasNext)
            {
                val (entity, exec) = iter.next()

                if (isSelected(entity))
                    exec(entity)
            }
        }
    }

    def isSelected(entity: Entity): Boolean =
    {
        selected.contains(entity)
    }

    def updatePhysics(dt: Int)
    {
        if (currentScene != null)
        {
            currentScene.updatePhysics(dt)
        }
    }
}
