package com.reonsoftware.awarder.json

import java.net.URI
import java.nio.charset.StandardCharsets
import com.reonsoftware.awarder.models.Activity
import com.reonsoftware.awarder.utilities.FileUtils
import spray.json._
import DefaultJsonProtocol._
import MyJsonProtocol.activityFormat

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
object JsonUtils {

  def readActivityFromFile(fileUri: URI): Activity = {
    val fileContentsString = FileUtils.readFileAsString(fileUri, StandardCharsets.UTF_8)
    val jsonAst = fileContentsString.parseJson
    jsonAst.convertTo[Activity]
  }

}
