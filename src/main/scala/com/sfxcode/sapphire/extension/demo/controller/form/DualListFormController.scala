package com.sfxcode.sapphire.extension.demo.controller.form

import javafx.fxml.FXML

import com.sfxcode.sapphire.core.Includes._
import com.sfxcode.sapphire.core.value.FXBean
import com.sfxcode.sapphire.extension.control.DualDataListView
import com.sfxcode.sapphire.extension.demo.controller.AbstractBaseController
import com.sfxcode.sapphire.extension.demo.model.{PersonDatabase, Friend}
import com.typesafe.scalalogging.LazyLogging

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

class DualListFormController extends AbstractBaseController with LazyLogging {
  
  
  implicit def listToProperty(list: Seq[R]): ObjectProperty[ObservableBuffer[FXBean[R]]] = {
    ObjectProperty(this, "dataTableItems", list)
  }

  type R = Friend

  @FXML
  var dualDataList: DualDataListView[R] = _

  override def didGainVisibilityFirstTime(): Unit = {
    dualDataList.setItems(PersonDatabase.friends)
  }

  override def willGainVisibility(): Unit = {
    super.willGainVisibility()
  }



}
