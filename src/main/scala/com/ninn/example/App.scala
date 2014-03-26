package com.ninn.example

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

object App extends FinatraServer {

  register(new VehicleApp())
}
