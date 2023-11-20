package transcription

import scala.collection.immutable.HashMap
import scala.util.matching.Regex

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

  private val CAPTURE_VOWEL_AND_PREVIOUS_CONSONANTS = "(?<=[aeiou])"
  private val CAPTURE_N_LETTER_BETWEEN_VOWEL_AND_CONSONANT = "(?<=[aeiou]n(?![aeiou]))"
  private val REGEX_TO_TOKENISE_SYLLABLES: Regex =
    s"$CAPTURE_VOWEL_AND_PREVIOUS_CONSONANTS|$CAPTURE_N_LETTER_BETWEEN_VOWEL_AND_CONSONANT".r

  def transcript(romaji: String): String = fromTokenisedRomajiToHiragana(tokenise(romaji))

  private def fromTokenisedRomajiToHiragana(tokenisedRomaji: List[String]): String =
    tokenisedRomaji.map(syllable => ROMAJI_TO_HIRAGANA.getOrElse(syllable, syllable)).mkString("")

  private def tokenise(romaji: String): List[String] = REGEX_TO_TOKENISE_SYLLABLES.split(romaji.toLowerCase()).toList
}
