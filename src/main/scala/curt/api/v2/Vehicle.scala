package curt.api.v2

import com.twitter.finagle.http.{RequestBuilder, Http}
import com.twitter.util.Future
import org.jboss.netty.handler.codec.http._
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.util.TimeConversions._

/**
 * Created by ninnemana on 3/25/14.
 */


  class Vehicle {

    val client = ClientBuilder.get()
      .codec(Http())
      .hosts("curtapi.curtmfg.com:80")
      .hostConnectionLimit(5)
      .tcpConnectTimeout(500.milliseconds)
      .timeout(2.seconds)
      .build()

    def getYears : Future[HttpResponse] = {

        val req = RequestBuilder().url("http://curtapi.curtmfg.com/v2/GetYear?dataType=json").buildGet
        val respFuture: Future[HttpResponse] = client(req)
        respFuture
    }

  }