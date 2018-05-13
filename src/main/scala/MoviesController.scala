import com.github.xiaodongw.swagger.finatra.SwaggerSupport
import com.twitter.finagle.http.Request
import com.twitter.finatra.http._
import com.twitter.util.Future
import doc.UpDownerDocument
import schema.{Movie, UpDownerResponse}

class MoviesController extends Controller with SwaggerSupport {

  implicit val swagger = UpDownerDocument

  get("/movies", swagger { o =>
    o.summary("get movies")
      .tag("up down movies")
      .responseWith[UpDownerResponse](200, "The Machinist")
  }) { request: Request =>

    val movie = UpDownerResponse(Seq(Movie("The Machinist", "https://www.imdb.com/title/tt0361862")))
    Future.value(movie)
  }

}
