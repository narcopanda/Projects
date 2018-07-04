package com.rootpackage.commands
import com.rootpackage.files.{DirEntry, File}
import com.rootpackage.filesystem.State

class Touch(name: String) extends CreateEntry(name) {
  override def CreateEntry(state: State): DirEntry = File.empty(state.workingDirec.path, name)
}
