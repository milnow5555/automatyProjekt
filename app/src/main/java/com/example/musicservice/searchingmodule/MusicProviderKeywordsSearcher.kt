package com.example.musicservice.searchingmodule

import com.example.musicservice.MusicApp
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import java.lang.StringBuilder
import javax.inject.Inject

class MusicProviderKeywordsSearcher @Inject constructor(private val musicDao : MusicProviderDao ) {

    private val keywordsBank : KeywordsBank = MusicApp.component.keywordsBank()

    fun search(toString: String, findByNameLambda : (String) -> Unit, filterByFeaturesLambda : (MutableMap<String,String>) -> Unit) {

        var searcher : () -> Unit = {
            performSearching(toString,findByNameLambda, filterByFeaturesLambda)
        }
        keywordsBank.instantiateAllBanks(searcher = searcher)
    }

    private fun performSearching(wholeText : String, indByNameLambda : (String) -> Unit, filterByFeaturesLambda : (MutableMap<String,String>) -> Unit) {
        println("PERFORMING SEARCHING------------------------")
        if(wholeText.isEmpty()) return

        var mapOfFeatures : MutableMap<String,String> = mutableMapOf()
        val firstLoopSplit = wholeText.split(" ")
        var sequenceOfWordsBuilder  = StringBuilder()
        var firstLoopIterator  = 1

        for(firstLoopWord in firstLoopSplit) {
            if(firstLoopIterator==1) sequenceOfWordsBuilder.append(firstLoopWord)
            else sequenceOfWordsBuilder.append(" ${firstLoopWord}")

            var reversedSequenceOfWords = reverseSequenceOfWords(sequenceOfWordsBuilder.toString())

            val secondLoopSplit = reversedSequenceOfWords.split(" ")
            var subSequenceOfWordsBuilder = StringBuilder()
            println("OUTER LOOP ${sequenceOfWordsBuilder}")
            var secondLoopIterator  = 1
            for(secondLoopWord in secondLoopSplit) {
                if(secondLoopIterator == 1) subSequenceOfWordsBuilder.append(secondLoopWord)
                else  subSequenceOfWordsBuilder.append(" ${secondLoopWord}")
                val subSequence = subSequenceOfWordsBuilder.toString()
                val wordsInAppropriateOrder = reverseSequenceOfWords(subSequence)

                if(keywordsBank.nameMutableSet.any { it.toLowerCase() == wordsInAppropriateOrder.toLowerCase() }) {
                    println("NAME HAS BEEN FOUND ${firstLoopIterator}")
                    indByNameLambda.invoke(wordsInAppropriateOrder)
                    return
                }
                if(keywordsBank.rateMutableSet.any { it.toLowerCase() == wordsInAppropriateOrder.toLowerCase() }) {
                    println("RATE HAS BEEN FOUND ${firstLoopIterator}")
                    mapOfFeatures.put("rate", wordsInAppropriateOrder)
                }

                if(keywordsBank.typeMutableSet.any { it.toLowerCase() == wordsInAppropriateOrder.toLowerCase() }) {
                    println("TYPE HAS BEEN FOUND ${firstLoopIterator}")
                    mapOfFeatures.put("type", wordsInAppropriateOrder)
                }

                if(keywordsBank.preferencesMutableSet.any { it.toLowerCase() == wordsInAppropriateOrder.toLowerCase() }) {
                    println("PREFERENCES HAS BEEN FOUND ${firstLoopIterator}")
                    mapOfFeatures.put("pref",wordsInAppropriateOrder)
                }

                if(keywordsBank.cityMutableSet.any { it.toLowerCase() == wordsInAppropriateOrder.toLowerCase() }) {
                    println("CITY HAS BEEN FOUND ${firstLoopIterator}")
                    mapOfFeatures.put("city",wordsInAppropriateOrder)
                }
                secondLoopIterator++
            }
            firstLoopIterator++
        }
        filterByFeaturesLambda.invoke(mapOfFeatures)
        println("LEFT SEARCHING METHOD")
    }

    private fun reverseSequenceOfWords(sequenceOfWords : String) : String{
        val secondLoopSplit = sequenceOfWords.split(" ")
        val reversedSequenceOfWords  = StringBuilder()

        var reversingLimit = secondLoopSplit.size-1
        for (i in reversingLimit downTo 0){
            if(i==0) reversedSequenceOfWords.append(secondLoopSplit[i])
            else reversedSequenceOfWords.append("${secondLoopSplit[i]} ")
        }
        return reversedSequenceOfWords.toString()
    }
}