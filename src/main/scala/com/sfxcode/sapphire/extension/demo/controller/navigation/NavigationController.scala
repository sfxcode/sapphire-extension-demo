package com.sfxcode.sapphire.extension.demo.controller.navigation

import javafx.event.ActionEvent

import com.sfxcode.sapphire.extension.demo.controller.AbstractBaseController
import com.sfxcode.sapphire.extension.demo.controller.form.{DualListFormController, FormController, ListFormController, PropertiesFormController}
import com.sfxcode.sapphire.extension.demo.controller.table.{FriendTableController, PersonTableController}

class DefaultNavigationController extends AbstractBaseController {
  lazy val formController = getController[FormController]()
  lazy val propertiesFormController = getController[PropertiesFormController]()
  lazy val listFormController = getController[ListFormController]()
  lazy val dualListFormController = getController[DualListFormController]()


  def actionShowForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(formController)
  }
  def actionShowListForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(listFormController)
  }

  def actionShowDualListForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(dualListFormController)
  }

  def actionShowPropertiesForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(propertiesFormController)
  }



}


class TableNavigationController extends AbstractBaseController {
  lazy val personTableController = getController[PersonTableController]()
  lazy val friendTableController = getController[FriendTableController]()


  def actionShowPersonTable(event: ActionEvent) {
    workspaceManager.updatePaneContent(personTableController)
  }

  def actionShowFriendTable(event: ActionEvent) {
    workspaceManager.updatePaneContent(friendTableController)
  }
}

