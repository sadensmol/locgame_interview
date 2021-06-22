package me.sadensmol.service

import me.sadensmol.utils.toDecimal
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.web3j.contracts.eip20.generated.ERC20
import org.web3j.protocol.admin.Admin
import org.web3j.protocol.http.HttpService
import org.web3j.tx.ReadonlyTransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import java.math.BigDecimal


@Service
class Erc20Service(@Value("\${infura.url}") private val serviceUrl:String) {
    fun getTokensAmount(contractAddress:String, address:String) :BigDecimal{
        val web3j:Admin  = Admin.build(HttpService(serviceUrl))
        val txManager = ReadonlyTransactionManager(web3j, address)
        val contract = ERC20.load(contractAddress,web3j,txManager, DefaultGasProvider())

        return toDecimal( contract.balanceOf(address).send())
    }
}