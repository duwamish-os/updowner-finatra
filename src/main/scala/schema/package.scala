package schema

final case class UpDownerResponse(movies: Seq[Movie])

final case class Movie(name: String, imdbURL: String)