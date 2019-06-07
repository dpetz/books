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
    val url = "https://www.amazon.com/s?k="+ query

    import scala.io.Source
    val html = Source.fromURL(url,"ISO-8859-1").mkString //  ISO-8859-1 UTF-16 ISO-8859-15 UTF-8
    print(html)

    val time: Long = System.currentTimeMillis / 1000

    // Put mapping
    Elastic.client().putMapping(indices = Seq("amazon"), `type` = "raw",
      body = s"""{"url": "$url", "time": "$time", "html": "$html"}"""
    )

  }



}
