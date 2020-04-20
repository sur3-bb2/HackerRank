package samples

import java.io.File
import java.net.URI
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Log(val dateTimeRaw: String, val parsedDateTime: LocalDateTime, val endpoint: String, val status: Int = 200) {
    companion object {
        fun create(input: List<String>?) : Log? {
            if(input == null || input.size > 2) return null

            //more logic to parse/validate string
            val parsedDateTime = input[0].replace("[","").replace("]", "")

            /*val formatter = DateTimeFormatterBuilder().appendPattern("dd/MMM/yyyy:HH:mm:ss")
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .parseDefaulting(ChronoField.MICRO_OF_SECOND, 0)
                .toFormatter()*/

            return Log(parsedDateTime,
                LocalDateTime.parse(parsedDateTime, DateTimeFormatter.ofPattern("dd/MMM/yyy:HH:mm:ss")),
                input[1])
        }
    }
}


data class LogStats(val log: Log1, var count: Int = 0)

data class Log1(val dateTimeRaw: String, val endpoint: String, val status: Int = 200) {
    companion object {
        fun create(input: List<String>?) : Log1? {
            if(input == null || input.size > 2) return null

            //more logic to parse/validate string
            val parsedDateTime = input[0].replace("[","").replace("]", "")

            return Log1(parsedDateTime.substring(0, parsedDateTime.length - 3), URI.create(input[1]).path)
        }
    }

    fun getKey() = "$endpoint-$dateTimeRaw"
}

fun List<String>.pick(vararg index: Int) : List<String> {
    val result = mutableListOf<String>()

    index.forEach {
        result.add(this[it])
    }

    return result
}

fun List<String>.filter200(position: Int = 8) = if(this[position] == "200") this else null

fun main(args: Array<String>) {
    val maps = mutableMapOf<String, LogStats>()
    File("./src/log.txt").forEachLine {
        val log = Log1.create(it.split(" ", limit = 10)
            .filter200()
            ?.pick(3, 6))

        println(log?.endpoint)
        log?.run {
            val key = this.getKey()

            maps.putIfAbsent(key, LogStats(log))
            maps.computeIfPresent(key) { _, value ->
                LogStats(value.log, value.count + 1)
            }
        }
    }

    println(maps)
}
