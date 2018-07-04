package com.rootpackage.commands

import com.rootpackage.files.{DirEntry, Directory}
import com.rootpackage.filesystem.State

class Mkdir(name: String)extends CreateEntry(name) {
  override def CreateEntry(state: State): DirEntry = Directory.empty(state.workingDirec.path, name)
}
