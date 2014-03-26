package com.ninn.example

import com.twitter.finatra.{View, Controller}
import curt.api.v2._
import com.twitter.util.{Await, Future}
import org.jboss.netty.util.CharsetUtil

/**
 * Created by ninnemana on 3/25/14.
 */
class VehicleApp extends Controller {

   get("/years") { request =>
      var v = new Vehicle

      val response = v.getYears
      response map { resp =>
        val yearView = new YearView
        yearView.years = resp.getContent.toString(CharsetUtil.UTF_8)
        render.view(yearView)
      }


   }
}

class YearView extends View{
  val template = "year_view.mustache"
  var Years = ""
}
