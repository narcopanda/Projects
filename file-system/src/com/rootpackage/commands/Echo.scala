package com.rootpackage.commands
import com.rootpackage.files.{Directory, File}
import com.rootpackage.filesystem.State

class Echo(args: Array[String]) extends Command {
  override def apply(state: State): State = {

    if(args.isEmpty) state
    else if(args.length == 1) state.setMessage(args(0))
    else {
      val operator = args(args.length - 2)
      val filename = args(args.length - 1)
      val contents = create(args, args.length - 2)

      if(">>".equals(operator)) doEcho(state, contents, filename, append = true)
      else if(">".equals(operator)) doEcho(state, contents, filename, append = false)
      else state.setMessage(create(args, args.length))

    }
  }

  def getRootAfterEcho(directory: Directory, path: List[String], contents: String, append: Boolean): Directory = {
    if (path.isEmpty) directory
    else if (path.tail.isEmpty) {
      val dirEntry = directory.findEntry(path.head)

      if (dirEntry == null)
        directory.addEntry(new File(directory.path, path.head, contents))
      else if (dirEntry.isDirec) directory
      else
      if (append) directory.replace(path.head, dirEntry.asFile.appendContents(contents))
      else directory.replace(path.head, dirEntry.asFile.setContents(contents))
    } else {
      val nextDirectory = directory.findEntry(path.head).asDirectory
      val newNextDirectory = getRootAfterEcho(nextDirectory, path.tail, contents, append)

      if (newNextDirectory == nextDirectory) directory
      else directory.replace(path.head, newNextDirectory)
    }
  }

  def doEcho(state: State, contents: String, filename: String, append: Boolean): State = {
    if(filename.contains(Directory.SEPARATOR)) state.setMessage("Echo: filename can't contain separators")
    else {
      val newRoot: Directory =  getRootAfterEcho(state.root, state.workingDirec.getAll :+ filename, contents, append)
      if (newRoot == state.root)
        state.setMessage(filename + ": no such file")
      else
        State(newRoot, newRoot.findDescendant(state.workingDirec.getAll))
    }
  }

  def create(args: Array[String], topIndex: Int): String = {
    def createHelper(currentIndex: Int, acc: String): String = {
      if (currentIndex >= topIndex) acc
      else createHelper(currentIndex + 1, acc + " " + args(currentIndex))

    }
    createHelper(0, "")
  }

}
