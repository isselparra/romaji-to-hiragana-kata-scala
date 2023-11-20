package transcription

import scala.annotation.tailrec
import scala.collection.immutable.HashMap

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

  private val VOWELS = Set('a', 'i', 'u', 'e', 'o')
  private val VALID_CONSONANTS_WITHOUT_N = Set('k', 's', 'h', 't', 'c', 'f', 'm', 'y', 'r', 'w')
  private val VALID_CONSONANTS = VALID_CONSONANTS_WITHOUT_N + 'n'

  def transcript(romaji: String): String =
    fromTokenisedRomajiToHiragana(tokenise(romaji))

  private def fromTokenisedRomajiToHiragana(tokenisedRomaji: List[String]): String =
    tokenisedRomaji.map(syllable => ROMAJI_TO_HIRAGANA.getOrElse(syllable, syllable)).mkString("")

  private def tokenise(romaji: String): List[String] = {
    @tailrec
    def tokeniseWithAccumulator(romajiAsChars: List[Char], currentSyllables: List[String]): List[String] =
      romajiAsChars match {
        case Nil => currentSyllables
        case Nil :+ lastChar if isValidConsonant(lastChar) && currentSyllables.nonEmpty =>
          tokeniseWithAccumulator(
            List.empty,
            prependInSyllablesLastCharWithFirstSyllable(currentSyllables, lastChar),
          )
        case Nil :+ lastChar =>
          tokeniseWithAccumulator(
            List.empty,
            prependInSyllablesLastCharAsSyllable(currentSyllables, lastChar),
          )
        case previousChars :+ penultimateChar :+ lastChar if isValidConsonant(penultimateChar) && isVowel(lastChar) =>
          tokeniseWithAccumulator(
            previousChars,
            prependInSyllablesNewSyllable(currentSyllables, penultimateChar, lastChar),
          )
        case previousChars :+ lastChar if isValidConsonantWithoutN(lastChar) && currentSyllables.nonEmpty =>
          tokeniseWithAccumulator(
            previousChars,
            prependInSyllablesLastCharWithFirstSyllable(currentSyllables, lastChar),
          )
        case previousChars :+ lastChar =>
          tokeniseWithAccumulator(
            previousChars,
            prependInSyllablesLastCharAsSyllable(currentSyllables, lastChar),
          )
      }
    tokeniseWithAccumulator(romaji.toLowerCase.toList, List.empty)
  }

  private def isValidConsonant(char: Char): Boolean = VALID_CONSONANTS.contains(char)

  private def isValidConsonantWithoutN(char: Char): Boolean = VALID_CONSONANTS_WITHOUT_N.contains(char)

  private def isVowel(char: Char): Boolean = VOWELS.contains(char)

  private def prependInSyllablesLastCharWithFirstSyllable(
      currentSyllables: List[String],
      lastChar: Char,
  ): List[String] =
    lastChar.toString + currentSyllables.head :: currentSyllables.tail

  private def prependInSyllablesLastCharAsSyllable(currentSyllables: List[String], lastChar: Char): List[String] =
    lastChar.toString :: currentSyllables

  private def prependInSyllablesNewSyllable(
      currentSyllables: List[String],
      penultimateChar: Char,
      lastChar: Char,
  ): List[String] =
    penultimateChar.toString + lastChar.toString :: currentSyllables
}
