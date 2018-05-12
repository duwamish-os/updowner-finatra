import com.twitter.finagle.http.Request
import com.twitter.finatra.http._

class MoviesController extends Controller {

  get("/movies") { request: Request =>
    """
    {
     "movies":
     [
      {
        "name": "The Machinist",
        "imdbURL": "https://www.imdb.com/title/tt0361862"
      }
     ]
    }
    """.stripMargin
  }

}
