package com.acmelabs.rickandmortydex

import com.acmelabs.rickandmortydex.data.network.CharacterService
import com.acmelabs.rickandmortydex.data.network.rickAndMortyClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class CharacterServiceTest {
    @Test
    fun `Deve obter 1 personagem com id igual a 1`() = runBlocking {
        val client = rickAndMortyClient(CharacterService::class.java)
        val response = client.getCharacterById(1).body()
        assertEquals(1, response?.id)
    }
}