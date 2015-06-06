package com.sfxcode.sapphire.extension.demo.controller.form

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.ComboBox

import com.sfxcode.sapphire.core.Includes._
import com.sfxcode.sapphire.core.control.FXListCellFactory
import com.sfxcode.sapphire.core.value.FXBean
import com.sfxcode.sapphire.extension.control.DataListView
import com.sfxcode.sapphire.extension.demo.controller.AbstractBaseController
import com.sfxcode.sapphire.extension.demo.model.{Friend, PersonDatabase}
import com.typesafe.scalalogging.LazyLogging

import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.input.MouseEvent

class ListFormController extends AbstractBaseController with LazyLogging {
  
  
  implicit def listToProperty(list: Seq[R]): ObjectProperty[ObservableBuffer[FXBean[R]]] = {
    ObjectProperty(this, "dataTableItems", list)
  }

  type R = Friend


  @FXML
  var comboBox: ComboBox[String] = _

  @FXML
  var listView: DataListView[R] = _

  @FXML
  var dataList: DataListView[R] = _


  val personsMap = PersonDatabase.smallPersonList.map(value => (value.bean.name, value)).toMap
  val buffer = ObservableBuffer(personsMap.keySet.toList)

  override def didGainVisibilityFirstTime(): Unit = {
    comboBox.getSelectionModel.selectedItemProperty.onChange((_, _, newValue) => comboBoxDidChange(newValue))
    comboBox.setItems(buffer)
    comboBox.getSelectionModel.selectFirst()

    listView.showFooter.set(true)
    listView.listView.setCellFactory(FXListCellFactory[R]("Name: ${_self.name()} ID: ${_self.id()}"))

    // update data list values
    dataList.showFooter.set(true)
    dataList.cellProperty.set("Name: ${_self.name()} ID: ${_self.id()}")
    dataList.footerTextProperty.set("found %s values")


    // add filter field
    // val filter = new DataListFilter[R](dataList, "name")
    dataList.addFilter("name")

    dataList.setItems(PersonDatabase.friends)

    dataList.listView.onMouseClicked = (e: MouseEvent) => if (e.clickCount == 2) deleteSelected()
  }

  def deleteSelected() {
    val selected = dataList.listView.getSelectionModel.getSelectedItems
    selected.foreach(v => {
      dataList.remove(v)
    })
  }

  override def willGainVisibility(): Unit = {
    super.willGainVisibility()
    comboBox.getSelectionModel.selectFirst()
  }

  def comboBoxDidChange(newValue: String) {
    logger.debug(personsMap(newValue).bean.friends.toString())
    listView.setItems(personsMap(newValue).bean.friends)

  }

  def actionResetList(event: ActionEvent) {
    dataList.setItems(PersonDatabase.friends)
  }


}
