package com.simprints.supermatcher

import com.simprints.supermatcher.data.Candidate
import com.simprints.supermatcher.matcher.SimMatcherImpl
import org.junit.Test
import org.junit.Assert.*
import java.security.InvalidParameterException


class SimMatcherTest {
    @Test
    fun normalInputTest() {
        val simMatcher = SimMatcherImpl()
        //Mohammad= 68     Bahadori= 58
        //Lil= 33          Wayne=68
        val actual = simMatcher.compareCandidates(
            Candidate(0, "Mohammad", "Bahadori"),
            Candidate(1, "Lil", "Wayne")
        )
        assertEquals(25, actual)
    }

    @Test
    fun caseSensitiveTest() {
        val simMatcher = SimMatcherImpl()
        //MOHAMMAD= 68      Bahadori= 58
        //mohammad= 68      BAHADORI= 58
        val actual = simMatcher.compareCandidates(
            Candidate(0, "MOHAMMAD", "bahadori"),
            Candidate(1, "mohammad", "BAHADORI")
        )
        assertEquals(0, actual)
    }

    @Test
    fun blankInputTest() {
        val simMatcher = SimMatcherImpl()
        // = 0      = 0
        // = 0      = 0 
        val actual = simMatcher.compareCandidates(
            Candidate(0, "", ""),
            Candidate(1, "", "")
        )
        assertEquals(0, actual)
    }

    @Test
    fun blankNameTest() {
        val simMatcher = SimMatcherImpl()
        // = 0     Bahadori= 58
        // = 0          Wayne=68
        val actual = simMatcher.compareCandidates(
            Candidate(0, "", "Bahadori"),
            Candidate(1, "", "Wayne")
        )
        assertEquals(10, actual)
    }

    @Test
    fun blankSurnameTest() {
        val simMatcher = SimMatcherImpl()
        // Mohammad= 68      = 0
        // Lil= 33           = 0
        val actual = simMatcher.compareCandidates(
            Candidate(0, "Mohammad", ""),
            Candidate(1, "Lil", "")
        )
        assertEquals(35, actual)
    }

    @Test(expected = InvalidParameterException::class)
    fun invalidParameterExceptionTest() {
        val simMatcher = SimMatcherImpl()
        // Mohammad= 68      B@hadori= should throw exception because of using @
        // Lil= 33           Wayne= 68
        simMatcher.compareCandidates(
            Candidate(0, "Mohammad", "B@hadori"),
            Candidate(1, "Lil", "Wayne")
        )
    }

    @Test
    fun positiveResultTest() {
        val simMatcher = SimMatcherImpl()
        //Mohammad= 68     Bahadori= 58
        //Lil= 33          Wayne=68
        val actual = simMatcher.compareCandidates(
            Candidate(1, "Lil", "Wayne"),
            Candidate(0, "Mohammad", "Bahadori")
        )
        assertEquals(25, actual)
    }


    @Test
    fun equalCandidateTest() {
        val simMatcher = SimMatcherImpl()
        //Mohammad= 68     Bahadori= 58
        //Mohammad= 68     Bahadori= 58
        val actual = simMatcher.compareCandidates(
            Candidate(0, "Mohammad", "Bahadori"),
            Candidate(1, "Mohammad", "Bahadori")
        )
        assertEquals(0, actual)
    }
}