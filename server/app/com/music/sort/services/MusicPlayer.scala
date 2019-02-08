//package com.music.sort.services
//
//import java.io.File
//
//import javax.sound.sampled._
//
//
//class MusicPlayer {
//
//  val url = new File("server/public/js/15-tet_scale_on_C.mid")
//  val audioIn: AudioInputStream = AudioSystem.getAudioInputStream(url)
//  val clip: Clip = AudioSystem.getClip
//
//  def play(): Unit = {
//    clip.open(audioIn)
//    clip.start()
//  }
//
//}
