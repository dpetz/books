package controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api._
import play.api.mvc._
import wabisabi.Client
import com.ning.http.client.Response
import play.api.libs.concurrent.Futures._
import play.api.libs.concurrent.CustomExecutionContext

import scala.concurrent.ExecutionContext

// Make sure to bind the new context class to this trait using one of the custom
// binding techniques listed on the "Scala Dependency Injection" documentation page

import com.google.inject.ImplementedBy

@ImplementedBy(classOf[MyExecutionContextImpl])
trait MyExecutionContext extends ExecutionContext

class MyExecutionContextImpl @Inject()(system: ActorSystem)
  extends CustomExecutionContext(system, "my-context") // configured in ``application.conf``
    with MyExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(myExecutionContext: MyExecutionContext, cc: ControllerComponents
                              ) extends AbstractController(cc) {

  def hello() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.hello())
  }

  def search(query:String) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.search(query))
  }


  // https://asynchttpclient.github.io/async-http-client/apidocs/com/ning/http/client/Response.html

  def elastic = Action.async {
    val client = new Client("http://localhost:9200")
      client.health().map { response => Ok(response.getStatusText)
    }(myExecutionContext)

}}
