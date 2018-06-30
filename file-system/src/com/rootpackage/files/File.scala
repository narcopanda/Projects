package com.rootpackage.files

import com.rootpackage.filesystem.FileSystemException


class File(override val parentPath: String, override val name: String, val contents: String)
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory = throw new FileSystemException("File can't be directory")

  override def getType: String = "File"

  override def asFile: File = this

  override def isDirec: Boolean = false

  override def isFile: Boolean = true

  def setContents(newContents: String): File = new File(parentPath, name, newContents)

  def appendContents(newContents: String): File = setContents(contents + "\n" + newContents)
}

object File {

  def empty(parent:String, name:String): File = new File(parent, name, "")
}
