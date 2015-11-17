package com.reonsoftware.awarder.achievements

import com.reonsoftware.awarder.models.Activity

/**
  * @author Jon Onstott
  * @since 11/17/2015
  */
trait Achievement {

  def doesActivityQualify(activity: Activity): Boolean

  def presentAward(activity: Activity)

}
