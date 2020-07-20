package com.pharbers.models.entity.max

import com.pharbers.macros.api.commonEntity
import com.pharbers.macros.common.connecting.{One2ManyConn, ToStringMacro}

@ToStringMacro
@One2ManyConn[SaleShareCard]("SaleShareCard")
class ProvinceMarketSale extends commonEntity {
    var title = "provinceMarketSale"
}
