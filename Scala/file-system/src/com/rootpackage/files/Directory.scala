package com.rootpackage.files

import com.rootpackage.filesystem.FileSystemException

import scala.annotation.tailrec

class Directory( override val parentPath:String, override val name:String, val con: List[DirEntry])
  extends DirEntry(parentPath, name) {


  def hasEntry(name: String): Boolean =
    findEntry(name) != null

  def getAll:List[String] =
    path.substring(1).split(Directory.SEPARATOR).toList.filter(x => !x.isEmpty)

  def findDescendant(path: List[String]): Directory =
    if(path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)

  def findDescendant(relativePath: String): Directory =
    if(relativePath.isEmpty) this
    else findDescendant(relativePath.split(Directory.SEPARATOR).toList)

  def remove(name:String): Directory =
    if(!hasEntry(name)) this
    else new Directory(parentPath, name, con.filter(x => !x.name.equals(name)))


//  :+ appends a collections
  def addEntry(newEntry: DirEntry): Directory =
    new Directory(parentPath, name, con :+ newEntry)

  def findEntry(name: String): DirEntry = {
    @tailrec
    def findHelper(name: String, contentList: List[DirEntry]): DirEntry =
      if (contentList.isEmpty) null
      else if (contentList.head.name.equals(name)) contentList.head
      else findHelper(name, contentList.tail)

    findHelper(name, con)
  }

  def replace(name:String, newEntry:DirEntry):Directory =
    new Directory(parentPath, name, con.filter(e => !e.name.equals(name)) :+ newEntry)
  //for every e !e.name.equals(name) has to return true

   def asDirectory: Directory = this

   def getType: String = "Directory"

  override def asFile: File = throw new FileSystemException("can't be converted to a file")

  def isRoot: Boolean = parentPath.isEmpty()

  override def isDirec: Boolean = true

  override def isFile: Boolean = false
}


object Directory{
  val SEPARATOR = "/"
  val ROOT_PATH = "/"


  def empty(parentPath: String, name: String):Directory = new Directory(parentPath, name, List())
  def Root: Directory = Directory.empty("", "")
}
