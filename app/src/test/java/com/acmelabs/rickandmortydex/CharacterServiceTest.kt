package com.acmelabs.rickandmortydex

import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.rickAndMortyClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class CharacterServiceTest {

    private lateinit var client: CharacterService

    @Before
    fun setUp(){
        client = rickAndMortyClient(CharacterService::class.java)
    }

    @Test
    fun `Deve obter 1 personagem com id igual a 1`() = runBlocking {
        val response = client.getCharacterById(1).body()
        assertEquals(1, response?.id)
    }

    @Test
    fun `Deve retornar mais de 1 personagem`() = runBlocking {
        val response = client.getAllCharacters().body()
        val charactersCount = response?.info?.count ?: 0
        assert(charactersCount > 1)
    }
}