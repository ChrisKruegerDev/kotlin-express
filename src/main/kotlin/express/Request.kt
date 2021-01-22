package express

import kotlin.js.Json

external interface Request {
    val app: dynamic
    val baseUrl: String
    val body: Any
    val headers: IncomingHttpHeaders
    val rawHeaders: List<String>
    val cookies: dynamic
    val fresh: Boolean
    val hostname: String
    val ip: String
    val ips: List<String>
    val method: String
    val originalUrl: String
    val path: String
    val protocal: String
    val query: dynamic
    val route: String
    val secure: Boolean
    val signedCookies: dynamic
    val stale: Boolean
    val subdomains: List<String>
    val xhr: Boolean
    val params: dynamic

    fun accepts(type: String)
    fun accepts(types: List<String>)
    fun get(field: String): String
    fun `is`(type: String): Boolean?
    fun param(name: String, defaultValue: Any?): String?
    fun range(times: Int)
    fun header(name: String): Any?
}

typealias IncomingHttpHeaders = Json