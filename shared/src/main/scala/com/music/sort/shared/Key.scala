//package com.music.sort.shared
//
//import java.io.File
//
//import javax.sound.sampled.{AudioInputStream, AudioSystem, Clip}
//
//object Key {
//  val url = new File("15-tet_scale_on_c.mid")
//  val audioIn: AudioInputStream = AudioSystem.getAudioInputStream(url)
//  val clip: Clip = AudioSystem.getClip
//
//  def compare(n1: Note, n2: Note): Unit = {
//    clip.open(audioIn)
//    clip.start()
//    Thread.sleep(1000)
//  }
//}
