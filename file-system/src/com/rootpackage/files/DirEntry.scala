package com.rootpackage.files

abstract class DirEntry(val parentPath: String, val name: String) {

  def path:String ={
    val sepIfNecesary =
      if(Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR
    parentPath + sepIfNecesary + name
  }
  def asDirectory: Directory

  def asFile: File

  def getType: String

  def isDirec: Boolean
  def isFile: Boolean
}
