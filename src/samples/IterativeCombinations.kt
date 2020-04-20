package samples

import java.util.*


/**
 * https://www.geeksforgeeks.org/iterative-letter-combinations-of-a-phone-number/
 *
 * Given an integer array containing digits from [0, 9], the task is to print all possible letter combinations that the numbers
 * could represent.
    A mapping of digit to letters (just like on the telephone buttons) is being followed.
    Note that 0 and 1 do not map to any letters. All the mapping are shown in the image below:
 *

 classic DFS problem...

 approach

 1, use hash map of digit to char array
 2. pick up all chararray and pass to funtion, along with index, output to store combinations and temp
 3. index's purpose to quit recursive function and add all combinations
 4. for each char in array at index, call function recursively same function with index + 1, temp storing

 **/

fun sprint(input: List<CharArray>, index: Int = 0, output: MutableList<String>, temp: String)  {
    if(input.size == index + 1 || input.size == 1) {
        for(i in input[index]) {
            output.add(temp.plus(i))
        }

        return
    }

    input[index].forEach {
        sprint(input, index + 1, output, temp.plus(it))
    }

}

fun main(args: Array<String>) {
    val dict = HashMap<Char, CharArray>()
    var output = mutableListOf<String>()

    dict['2'] = charArrayOf('a', 'b', 'c')
    dict['3'] = charArrayOf('d', 'e', 'f')
    dict['4'] = charArrayOf('g', 'h', 'i')
    dict['5'] = charArrayOf('j', 'k', 'l')
    dict['6'] = charArrayOf('m', 'n', 'o')
    dict['7'] = charArrayOf('p', 'q', 'r', 's')
    dict['8'] = charArrayOf('t', 'u', 'v')
    dict['9'] = charArrayOf('w', 'x', 'y', 'z')

    val test1 = arrayOf('9')
    val test2 = arrayOf('2', '3')
    val test3 = arrayOf('2', '8', '9')

    val inputs = mutableListOf<CharArray>()

    test1.forEach {
        inputs.add(dict[it]!!)
    }
    sprint(inputs, 0, output, "")
    inputs.clear()
    output.clear()

    test2.forEach {
        inputs.add(dict[it]!!)
    }
    sprint(inputs,0, output, "")
    inputs.clear()
    output.clear()

    test3.forEach {
        inputs.add(dict[it]!!)
    }
    sprint(inputs,0, output, "")
    inputs.clear()
    output.clear()
}