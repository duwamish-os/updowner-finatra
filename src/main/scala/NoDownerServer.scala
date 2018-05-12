import com.twitter.finatra.http._
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter

class NoDownerServer extends HttpServer {
  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[MoviesController]
  }
}


object ANoDownerServer extends NoDownerServer