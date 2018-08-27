package tk.roccodev.hiveapi.server.chatlog

import tk.roccodev.hiveapi.http.DownloadObj

class Chatlog(id: String) {

    private val json = DownloadObj.chatReport(id)

    val uuid
        get() = json.string("UUID")

    val messages: Array<ChatlogMessage>
        get() {
            var str = json.string("messages")
            str = str?.substring(0, str.length - 2)

            val split = str?.split("\\n")
            val arr = arrayListOf<ChatlogMessage>()
            split?.forEach {

                val date = "\\[(.*?)]".toRegex().find(it)?.groupValues?.get(1)
                val sender = "]\\s\\s(.+?):".toRegex().find(it)?.groupValues?.get(1)
                val msg = "$sender:(.*)".toRegex().find(it)?.groupValues?.get(1)

                arr.add(ChatlogMessage(sender, date, msg))
            }

            return arr.toTypedArray()

        }


}