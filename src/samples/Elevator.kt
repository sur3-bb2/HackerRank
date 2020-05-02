package samples

enum class Direction {
    IDLE,
    UP,
    DOWN
}


data class Building(val floors: Int)

data class Elevator(private val maxFloors: Int) {
    private var current = 0
    private var direction = Direction.IDLE

    private var arrayStatus = booleanArrayOf()


    private fun isIdle() = direction == Direction.IDLE

    private fun defaultDirection() = Direction.UP

    fun move(floor: Int) {

    }
}

class Controller {
    val building = Building(20)
    val elevator = Elevator(building.floors)




}