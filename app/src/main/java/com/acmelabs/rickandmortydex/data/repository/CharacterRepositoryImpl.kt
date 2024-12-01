package com.acmelabs.rickandmortydex.data.repository

import com.acmelabs.rickandmortydex.data.database.dao.CharacterDao
import com.acmelabs.rickandmortydex.data.database.dao.EpisodeDao
import com.acmelabs.rickandmortydex.data.database.dao.LocationDao
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.episode_service.EpisodeService
import com.acmelabs.rickandmortydex.data.network.location_service.LocationService
import com.acmelabs.rickandmortydex.data.mapper.toEntity
import com.acmelabs.rickandmortydex.data.mapper.toModel
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.repository.safeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val episodeDao: EpisodeDao,
    private val locationDao: LocationDao,
    private val characterService: CharacterService,
    private val episodeService: EpisodeService,
    private val locationService: LocationService
): CharacterRepository {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override suspend fun loadTheWorld() {
        doPagination { page ->
            val resEpisodes = safeCall { episodeService.getAllEpisodes(page) }
            val episodes = resEpisodes.body?.results.orEmpty()
            episodeDao.upsert(episodes.map { it.toEntity() })
            resEpisodes.body?.info?.next
        }

        doPagination { page ->
            val resLocation = safeCall { locationService.getAllLocations(page) }
            val locations = resLocation.body?.results.orEmpty()
            locationDao.upsert(locations.map { it.toEntity() })
            resLocation.body?.info?.next
        }

        doPagination { page ->
            val resCharacters = safeCall { characterService.getAllCharacters(page) }
            val characters = resCharacters.body?.results.orEmpty()
            characterDao.upsert(characters.map { it.toEntity() })
            resCharacters.body?.info?.next
        }
    }

    private suspend fun doPagination(callback: suspend (Int) -> String?) {
        coroutineScope.launch {
            var pageCounter = 1
            do {
                val response = callback(pageCounter)
                pageCounter += 1
            } while (response != null)
        }
    }

    override fun getAllCharacters(): Flow<List<CharacterModel>> {
        return characterDao.getAllCharacters().map { it.map { it.toModel() } }
    }

}