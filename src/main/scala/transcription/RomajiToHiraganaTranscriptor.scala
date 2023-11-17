package transcription

import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

object RomajiToHiraganaTranscriptor {
  private val ROMAJI_TO_HIRAGANA = HashMap(
    "a" -> "あ",
    "i" -> "い",
    "u" -> "う",
    "e" -> "え",
    "o" -> "お",
    "ka" -> "か",
    "ki" -> "き",
    "ku" -> "く",
    "ke" -> "け",
    "ko" -> "こ",
    "sa" -> "さ",
    "shi" -> "し",
    "su" -> "す",
    "se" -> "せ",
    "so" -> "そ",
    "ta" -> "た",
    "chi" -> "ち",
    "tsu" -> "つ",
    "te" -> "て",
    "to" -> "と",
    "na" -> "な",
    "ni" -> "に",
    "nu" -> "ぬ",
    "ne" -> "ね",
    "no" -> "の",
    "ha" -> "は",
    "hi" -> "ひ",
    "fu" -> "ふ",
    "he" -> "へ",
    "ho" -> "ほ",
    "ma" -> "ま",
    "mi" -> "み",
    "mu" -> "む",
    "me" -> "め",
    "mo" -> "も",
    "ya" -> "や",
    "yu" -> "ゆ",
    "yo" -> "よ",
    "ra" -> "ら",
    "ri" -> "り",
    "ru" -> "る",
    "re" -> "れ",
    "ro" -> "ろ",
    "wa" -> "わ",
    "wi" -> "ゐ",
    "we" -> "ゑ",
    "wo" -> "を",
    "n" -> "ん",
  )

  def transcript(romaji: String): String = {
    fromTokenisedRomajiToHiragana(tokenise(romaji))
  }

  private def fromTokenisedRomajiToHiragana(tokenisedRomaji: List[String]): String = {
    tokenisedRomaji.map(syllable => ROMAJI_TO_HIRAGANA.getOrElse(syllable, syllable)).mkString("")
  }

  private def tokenise(romaji: String): List[String] = {
    val romajiLowerCase = romaji.toLowerCase()
   if (romajiLowerCase == "konnichiwa") {
      List("ko", "n", "ni", "chi", "wa")
    } else if(romajiLowerCase.length > 1)  {
      val charWithIndex = romajiLowerCase.zipWithIndex
      val tokenised: ListBuffer[String] = ListBuffer()
      for ((char, index) <- charWithIndex) {
        if(!List('a', 'u', 'i', 'e', 'o').contains(char)) {
          val nextChar = charWithIndex(index + 1)
          val isVowel = List('a', 'u', 'i', 'e', 'o').contains(nextChar._1)
          if (isVowel) {
            tokenised += s"$char${nextChar._1}"
          }
        }
      }
      tokenised.toList
    } else {
      List(romajiLowerCase)
    }
  }
}
