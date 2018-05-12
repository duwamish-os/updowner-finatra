import com.github.xiaodongw.swagger.finatra.SwaggerSupport
import com.twitter.finagle.http.Request
import com.twitter.finatra.http._
import com.twitter.util.Future
import doc.UpDownerDocument

final case class Movie(name: String, imdbURL: String)

class MoviesController extends Controller /*with SwaggerSupport*/ {

  //implicit val swagger = MovieDocument

  get("/movies") { request: Request =>

    val movie = Movie("The Machinist", "https://www.imdb.com/title/tt0361862")
    Future.value(movie)
  }

}
