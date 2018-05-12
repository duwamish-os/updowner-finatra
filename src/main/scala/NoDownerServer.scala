import com.github.xiaodongw.swagger.finatra.SwaggerController
import com.twitter.finatra.http._
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import doc.UpDownerDocument
import io.swagger.models.Info

class NoDownerServer extends HttpServer {

  UpDownerDocument.info(new Info()
    .description("Up Downer API")
    .version("0.0.1")
    .title("Up Downer"))

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add(new SwaggerController(swagger = UpDownerDocument))
      .add[MoviesController]
  }
}


object ANoDownerServer extends NoDownerServer