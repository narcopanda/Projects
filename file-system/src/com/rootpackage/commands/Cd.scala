package com.rootpackage.commands
import com.rootpackage.files.{DirEntry, Directory}
import com.rootpackage.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {
  override def apply(state: State): State = {

    val root = state.root
    val workingDirec = state.workingDirec

    val absPath =
      if(dir.startsWith(Directory.SEPARATOR)) dir
      else if(workingDirec.isRoot) workingDirec.path + dir
      else workingDirec.path + Directory.SEPARATOR + dir

    val destinationDirec = doFind(root, absPath)

    if(destinationDirec == null || !destinationDirec.isDirec) state.setMessage(dir + ": no such directory")
    else State(root, destinationDirec.asDirectory)
  }

  def doFind(root: Directory, path: String):DirEntry = {

    @tailrec
    def findHelper(current: Directory, path: List[String]):DirEntry =
      if(path.isEmpty || path.head.isEmpty) current
      else if(path.tail.isEmpty) current.findEntry(path.head)
      else {
        val nextDir = current.findEntry(path.head)
        if(nextDir == null || !nextDir.isDirec) null
        else findHelper(nextDir.asDirectory, path.tail)
      }

    @tailrec
    def collapseTokens(path: List[String], result: List[String]): List[String] = {
      if(path.isEmpty) result
      else if(".".equals(path.head)) collapseTokens(path.tail, result)
      else if ("..".equals(path.head)) {
        if (result.isEmpty) null
        else collapseTokens(path.tail, result.init)
      }else collapseTokens(path.tail, result :+ path.head)
      }


//    tokens
    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

    val newTokens = collapseTokens(tokens, List())

//    check for correct entries
    if(newTokens == null) null
    else findHelper(root, newTokens)
  }
}
