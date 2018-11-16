package com.github.alexichlol.riot.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.alexichlol.riot.api.dto.champion.ChampionInfo
import com.github.alexichlol.riot.api.dto.summoner.Summoner
import khttp.get

class RiotApi(val config: RiotApiConfig) {
    private val objectMapper = ObjectMapper().registerKotlinModule()

    fun getChampionInfo(): ChampionInfo {
        val r = get("https://na1.api.riotgames.com/lol/platform/v3/champion-rotations?api_key="+config.apiKey)
        return objectMapper.readValue(r.text)
    }

    fun getSummonerByName(name: String): Summoner {
        val r = get("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"
                + name + "?api_key=" + config.apiKey)
        return objectMapper.readValue(r.text)
    }

    fun getSummonerByAccountId(accountId: Long): Summoner {
        val r = get("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-account/"
                + accountId + "?api_key=" + config.apiKey)
        return objectMapper.readValue(r.text)
    }

    fun getSummonerBySummonerId(summonerId: Long): Summoner {
        val r = get("https://na1.api.riotgames.com/lol/summoner/v3/summoners/"
                + summonerId + "?api_key=" + config.apiKey)
        return objectMapper.readValue(r.text)
    }
}