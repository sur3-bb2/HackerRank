package samples

import kotlin.math.absoluteValue
import kotlin.math.pow


/**
 * With 62 chars and a unique string 7,8,9,10,11 char long we can shorten:
62⁷ = 3,521,614,606,208 urls
62⁸ = 218,340,105,584,896 urls
62⁹ = 13,537,086,546,263,552 urls
62¹⁰ = 839,299,365,868,340,224 urls
62¹¹ = 52,036,560,683,837,093,888 urls
So you can see from above we can generate these 62⁶ = ~5 billion possible strings
& 62⁸ = ~218 trillion possible strings and much more depending on need.

https://medium.com/swlh/how-to-build-a-tiny-url-service-that-scales-to-billions-f6fb5ea22e8c

In the simplest case we could probably get by with below columns:
id (DB generated sequence ID)
original_url — orginal URL value
shorten_url
creation_date
expiration_date


Generating the identifier from a DB
Now, if you provide a String URL value, your code just needs to insert it into the table along with creation date, this will create the row and the unique ID.
Next, fetch that unique numeric ID, and convert it to base-62 (this will convert the numeric value into the base-62 representation (rather than normal base10, it will allow 0–9, a-z, A-Z as characters. This gives you an identifier in the form of qa12WS4 .
Now append the base62 string into your base url of your short domain http://short.io and voila you get a shorten url as http://short.io/qa12WS4 and update it to the short url column with expiration date.
Now You have to just write redirection logic as who ever hits this shorten url you fetch the details from Db and redirect it to original Url.
This approach has 2 drawbacks:
First, we are doing two DB operations , insert and update , under heavy load it will not scale.
Secondly Incase of Database migration , the sequence ids can not be merged as we might have same sequence id generated into two tables.
Now let’s discuss the improvements, we can improve two things Firstly the DB structure and secondly instead of inserts and update we can do single inserts only. DB structure as follows:
id_hash (base 62 generated string as primary key)
original_url
shorten_url
creation_date
expiration_date
Now to have id_hash as primary key we need to have a centralized service which gives me unique seed tokens say
for example we use Redis autoincrement feature(as it is atomic in nature) we can get a seed number and generate a base 62 string , this will work behind two instances under load balances as well. A number of approaches can be build around to get unique seed depends on the requirement.

 */

val symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()

fun idToUrl(number: Long) : String {
    var shortUrl = StringBuilder()
    var numberCopy = number

    while(numberCopy > 0) {
        shortUrl.append(symbols[(numberCopy % 62).toInt()])
        numberCopy /= 62
    }

    return shortUrl.reverse().toString()
}

fun urlToId(shortUrl: String): Long {
    var decode = 0.0

    shortUrl.reversed().forEachIndexed { index, c ->
        decode += (symbols.indexOf(c).toDouble() * 62.0.pow(index.toDouble()))
    }

    return decode.toLong()
}


fun main() {
    val expected = "https://google.com/123".hashCode().absoluteValue.toLong()

    println("id for url is $expected")

    val shortUrl = idToUrl(expected)

    println(shortUrl)

    val actual = urlToId(shortUrl)

    println(actual)

    println("are equal ${(expected == actual)}")
}