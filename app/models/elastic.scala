package models

import wabisabi.Client


/**
  * Most methods return
  * https://asynchttpclient.github.io/async-http-client/apidocs/com/ning/http/client/Response.html
  *
  * Wraps https://github.com/gphat/wabisabi. Also see:
  * https://github.com/gphat/wabisabi/blob/master/src/main/scala/wabisabi/Client.scala
  * http://onemogin.com/wabisabi/api/index.html#wabisabi.Client
  */
object Elastic {

  // run `elasticsearch```from terminal first

  /** Create new client instance */
  def client(): Client = new Client("http://localhost:9200")



}
