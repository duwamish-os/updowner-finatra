downers universe finatra
------------------------

```
curl -v --request GET http://localhost:8888/movies
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8888 (#0)
> GET /movies HTTP/1.1
> Host: localhost:8888
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Type: text/plain; charset=utf-8
< Server: Finatra
< Date: Sat, 12 May 2018 19:16:49 +00:00
< Content-Length: 153
<

    {
     "movies":
     [
      {
        "name": "The Machinist",
        "imdbURL": "https://www.imdb.com/title/tt0361862"
      }
     ]
    }
* Connection #0 to host localhost left intact
```

"Connection #0 to host (nil) left intact" means that although the transfer is over, the TCP session itself is still open (i.e no FIN/ACK exchanges have been made), allowing you to keep reusing the same TCP connection for multiple transfers (which could be useful if you don't want to sacrifice time on opening a new TCP connection).