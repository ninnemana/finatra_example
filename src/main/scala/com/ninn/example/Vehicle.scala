package com.ninn.example

import com.twitter.finatra.{View, Controller}
import curt.api.v2._
import org.jboss.netty.util.CharsetUtil
import scala.util.parsing.json.JSON

/**
 * Created by ninnemana on 3/25/14.
 */
class VehicleApp extends Controller {

   get("/years") { request =>
      var v = new Vehicle

      val response = v.getYears
      response map { resp =>
        val yearView = new YearView
        val js = JSON.parseFull(resp.getContent.toString(CharsetUtil.UTF_8))
        js match{
          case Some(e) => {
            yearView.Years = e.asInstanceOf[List[Int]]

          }
          case _ => {
            yearView.Years = List[Int]()
          }
        }
        render.view(yearView)
      }


   }
}

class YearView extends View{
  val template = "year_view.mustache"
  var Years: List[Int] = List()
}
