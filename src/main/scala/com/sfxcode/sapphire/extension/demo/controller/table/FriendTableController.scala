package com.sfxcode.sapphire.extension.demo.controller.table

import com.sfxcode.sapphire.extension.demo.model.{Friend, PersonDatabase}

import scala.reflect._

class FriendTableController extends AbstractTableViewController {

   type R = Friend

   def ct =  classTag[R]

   def items = PersonDatabase.friends



 }


