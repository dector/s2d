package ua.org.dector.s2d.struct

/**
 * @author dector (dector9@gmail.com)
 */

class Type(val name: String, val rendered: Rendered, val physical: Physical)
{
    private var lastId = -1

    def nextId() = { lastId += 1; lastId }
}
