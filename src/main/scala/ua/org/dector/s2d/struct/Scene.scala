package ua.org.dector.s2d.struct

import java.util.{TreeMap, LinkedList}

//import java.util.{TreeMap, List, LinkedList}

/**
 * @author dector (dector9@gmail.com)
 */

class Scene(val width: Int, val height: Int)
{
    private val entities = new TreeMap[String, Entity]
    private val entitiesByZ = new TreeMap[Int, LinkedList[Entity]]

    def += (entity: Entity)
    {
        if (! entities.containsKey(entity.name))
        {
            entities.put(entity.name, entity)

            val entityZ = entity.z

            if (! entitiesByZ.containsKey(entityZ))
            {
                entitiesByZ.put(entityZ, new LinkedList[Entity])
            }
            entitiesByZ.get(entityZ).add(entity)
        }
    }

    def render(dt: Int)
    {
        val iterZ = entitiesByZ.keySet().iterator

        while (iterZ.hasNext)
        {
            val iter = entitiesByZ.get(iterZ.next()).iterator()

            while(iter.hasNext)
            {
                iter.next().render(dt)
            }
        }
    }
}
