package tk.roccodev.hiveapi.util

import java.util.*


fun dateFromHiveSeconds(seconds: Number) : Date {

    return Date(seconds.toLong() * 1000)
}
