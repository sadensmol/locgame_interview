package me.sadensmol.controller

import me.sadensmol.service.Erc20Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class Erc20Controller(private val erc20Service: Erc20Service) {

    @GetMapping("/{contractAddress}/{holderAddress}")
    suspend fun getBalanceOf(@PathVariable contractAddress:String, @PathVariable holderAddress:String): BigDecimal {
        return erc20Service.getTokensAmount(contractAddress,holderAddress)
    }
}