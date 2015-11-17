package com.reonsoftware.awarder

import java.net.URI
import java.nio.charset.Charset
import java.nio.file.{Paths, Files}

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
object FileUtils {

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
