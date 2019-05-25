import scala.concurrent.ExecutionContext
import wabisabi._


implicit val ec = ExecutionContext.global


val client = new Client("http://localhost:9200")

// Get the cluster's health
client.health()

// Create the index
client.createIndex(name = "buecher")

client.verifyIndex("buecher").map(_.getStatusCode) // Future(200)

// Put mapping
client.putMapping(indices = Seq("buecher"), `type` = "raw",
  body = "{\"bar\": {\"properties\": {\"baz\": {\"type\": \"string\"}}}}"
)