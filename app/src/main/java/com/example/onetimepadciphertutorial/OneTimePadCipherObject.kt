package com.example.onetimepadciphertutorial

object OneTimePadCipherObject {

    private const val alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun oneTimePadRandomGenerator(plainText: String):List<Int>{
        val randomKeyList = mutableListOf<Int>()
        for(letter in plainText){
            randomKeyList.add((0..alphabet.length-1).shuffled().last())
        }
        return randomKeyList
    }

    fun oneTimePadCipherEncryption(plainText:String , cipherKey:List<Int>):String{

        val plainTextUpper = plainText.uppercase()
        var cipherText = ""
        for((indx,char) in plainTextUpper.withIndex()){
            val keyIndex = cipherKey[indx]
            val charIndex = alphabet.indexOf(char)
            cipherText += alphabet[(charIndex + keyIndex).mod(alphabet.length)]
        }
        return cipherText
    }

    fun oneTimePadCipherDecryption(cipherText:String , cipherKey: List<Int>):String{
        val cipherTextUpper = cipherText.uppercase()
        var plainText = ""
        for((indx,char) in cipherTextUpper.withIndex()){
            val keyIndex = cipherKey[indx]
            val charIndex = alphabet.indexOf(char)
            plainText += alphabet[(charIndex - keyIndex).mod(alphabet.length)]
        }
        return plainText
    }

}






















