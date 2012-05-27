package ua.org.dector.s2d.state

/**
 * @author dector (dector9@gmail.com)
 */

object StateManager {
    private var done = false

    def isDone = done
    def setDone() { done = true }
}
