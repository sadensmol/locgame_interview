package me.sadensmol.utils

import org.web3j.utils.Convert
import java.math.BigDecimal
import java.math.BigInteger

fun toDecimal(integer: BigInteger): BigDecimal {
    return Convert.fromWei(BigDecimal(integer),Convert.Unit.ETHER)
}

