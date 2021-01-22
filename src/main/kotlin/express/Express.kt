package express

/**
 * Example:
 * val express = Express()
 * express.get("/hello") { req, res ->
 *  res.send("Hello!")
 * }
 */
@JsModule("express")
external class Express {

    val req: Request
    val res: Response

    fun set(key: String, value: String)

    fun get(setting: String): String
    fun get(route: String, callback: (req: Request, res: Response) -> Unit)

    fun post(path: String, functions: (req: Request, res: Response) -> Unit)
    fun put(route: String, callback: (req: Request, res: Response) -> Unit)

    fun listen(port: Int, callback: Callback?)

    fun use(router: RequestHandler)
    fun use(router: Any)

}

@JsModule("compression")
external class Compression

typealias Callback = () -> Unit
typealias RequestHandler = (req: Request, res: Response, next: NextFunction) -> Unit
typealias NextFunction = (Error?) -> Unit
