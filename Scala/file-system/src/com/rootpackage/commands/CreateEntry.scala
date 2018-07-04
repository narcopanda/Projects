package com.rootpackage.commands

import com.rootpackage.files.{DirEntry, Directory}
import com.rootpackage.filesystem.State

abstract class CreateEntry(name: String) extends Command {

  override def apply(state: State): State = {
    val workingDirec = state.workingDirec
    if(workingDirec.hasEntry(name)){
      state.setMessage("Entry " + name + " already exists")
    } else if (name.contains(Directory.SEPARATOR)){
      state.setMessage(name + "can't have separators")
    }else if(checkIllegal(name)){
      state.setMessage(name + ": illegal entry name")
    } else {
      doCreate(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }
  def doCreate(state: State, name: String): State = {
    def update(current: Directory, path: List[String], newDir: DirEntry):Directory = {
      if(path.isEmpty) current.addEntry(newDir)
      else {
        val old = current.findEntry(path.head).asDirectory
        current.replace(old.name, update(old, path.tail, newDir))
      }
    }
    val workingDirec = state.workingDirec

    //  all directories
    val allPaths = workingDirec.getAll

    //    create new directory
    val newEntry: DirEntry = CreateEntry(state)


    //  create a new root
    val newRoot = update(state.root, allPaths, newEntry)

    //  find new working directory
    val newWorkingDirec = newRoot.findDescendant(allPaths)

    State(newRoot, newWorkingDirec)

  }

  def CreateEntry(state: State): DirEntry

}
