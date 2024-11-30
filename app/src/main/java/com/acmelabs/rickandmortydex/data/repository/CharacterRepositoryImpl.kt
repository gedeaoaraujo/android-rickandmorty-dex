package com.acmelabs.rickandmortydex.data.repository

import com.acmelabs.rickandmortydex.data.database.CharacterDao
import com.acmelabs.rickandmortydex.data.database.EpisodeDao
import com.acmelabs.rickandmortydex.data.database.LocationDao
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.episode_service.EpisodeService
import com.acmelabs.rickandmortydex.data.network.location_service.LocationService
import com.acmelabs.rickandmortydex.data.toEntity
import com.acmelabs.rickandmortydex.data.toModel
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.repository.Status
import com.acmelabs.rickandmortydex.domain.repository.safeCall
import com.acmelabs.rickandmortydex.domain.repository.wrapHttpStatus

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val episodeDao: EpisodeDao,
    private val locationDao: LocationDao,
    private val characterService: CharacterService,
    private val episodeService: EpisodeService,
    private val locationService: LocationService
): CharacterRepository {

    override suspend fun loadTheWorld() {
        val resEpisodes = safeCall { episodeService.getAllEpisodes() }
        val episodes = resEpisodes.body?.results.orEmpty()
        episodeDao.upsert(episodes.map { it.toEntity() })

        val resLocation = safeCall { locationService.getAllEpisodes() }
        val locations = resLocation.body?.results.orEmpty()
        locationDao.upsert(locations.map { it.toEntity() })

        val resCharacters = safeCall { characterService.getAllCharacters() }
        val characters = resCharacters.body?.results.orEmpty()
        characterDao.upsert(characters.map { it.toEntity() })
    }

    override suspend fun getAllCharacters(): Status<List<CharacterModel>> {
        val result = safeCall { characterService.getAllCharacters() }
        val list = result.body?.results.orEmpty()
        val models = list.map { it.toModel() }
        return wrapHttpStatus(models, result.code)
    }

}