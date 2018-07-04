package com.rootpackage.commands
import com.rootpackage.files.Directory
import com.rootpackage.filesystem.State

class Rm(name:String) extends Command {
  override def apply(state: State): State = {
//    working direc
    val workingDirec = state.workingDirec

//    abs path
    val absPath =
      if(name.startsWith(Directory.SEPARATOR)) name
      else if (workingDirec.isRoot) workingDirec.path + name
      else workingDirec.path + Directory.SEPARATOR + name


//    checks
    if(Directory.ROOT_PATH.equals(absPath)) state.setMessage("Don't. Just don't")
    else doRm(state, absPath)
  }


  def doRm(state: State, path: String): State = {
    def rmHelper(currentDirectory: Directory, path: List[String]): Directory = {
      if (path.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.remove(path.head)
      else {
        val nextDirectory = currentDirectory.findEntry(path.head)
        if (!nextDirectory.isDirec) currentDirectory
        else {
          val newNextDirectory = rmHelper(nextDirectory.asDirectory, path.tail)
          if (newNextDirectory == nextDirectory) currentDirectory
          else currentDirectory.replace(path.head, newNextDirectory)
        }
      }
    }
    val tokens = path.substring(1).split(Directory.SEPARATOR).toList
    val newRoot: Directory = rmHelper(state.root, tokens)

    if(newRoot == state.root)
      state.setMessage(path + ": no such file or directory")

    else
      State(newRoot, newRoot.findDescendant(state.workingDirec.path.substring(1)))

  }


}
