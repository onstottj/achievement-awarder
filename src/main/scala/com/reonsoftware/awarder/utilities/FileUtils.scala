package com.reonsoftware.awarder.utilities

import java.net.URI
import java.nio.charset.Charset
import java.nio.file.{Files, Paths}

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
object FileUtils {

  /**
    * Looks up the given resource on the classpath
    */
  def getResourceUri(resourcePath: String): URI = {
    val url = getClass.getClassLoader.getResource(resourcePath)
    if (url == null)
      throw new IllegalArgumentException(s"The resource '$resourcePath' couldn't be found")
    url.toURI
  }

  /**
    * Adapted from http://stackoverflow.com/a/326440/132374
    * @param fileUri the location of the file
    * @param encoding the file's encoding; you can use StandardCharsets.UTF_8, for example
    * @return the file's contents as a String
    */
  def readFileAsString(fileUri: URI, encoding: Charset): String = {
    val encodedBytes = Files.readAllBytes(Paths.get(fileUri))
    new String(encodedBytes, encoding)
  }

}
