package controllers

import play.mvc.Controller

/**
  * @author seyi
  */

object StaticAssets extends Controller {

  def getUrl(file: String): String = controllers.routes.Assets.versioned(file).toString
}
