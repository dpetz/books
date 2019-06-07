package models

import com.ning.http.client.Response

import scala.concurrent.{ExecutionContext, Future}
import wabisabi._

/**
  * Crawl similar books from amazon
  *
  */
object amazon {




  implicit val ec = ExecutionContext.global


  // client.health() map
  //client.createIndex(name = "amazon")
  //client.verifyIndex("amazon").map(_.getStatusCode)

  def search(query:String) : Future[Response] = {

    // https://www.amazon.de/s?k=the+annotated+turing
    val url = "https://www.amazon.de/s?k="+ query

    import scala.io.Source
    val html = Source.fromURL(url).mkString

    val time: Long = System.currentTimeMillis / 1000

    // Put mapping
    Elastic.client().putMapping(indices = Seq("amazon"), `type` = "raw",
      body = s"""{"url": "$url", "time": "$time", "html": "$html"}"""
    )

  }



}
