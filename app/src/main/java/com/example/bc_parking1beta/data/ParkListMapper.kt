package com.example.bc_parking1beta.data

import com.example.bc_parking1beta.domain.ParkItem

class ParkListMapper {

    fun mapEntityToDbModel(parkItem: ParkItem): ParkItemDbModel{
        return ParkItemDbModel(
            id = parkItem.id,
            name = parkItem.name,
            firm = parkItem.firm,
            dateFrom = parkItem.dateFrom,
            dateTo = parkItem.dateTo,
            about = parkItem.about,
            enabled = parkItem.enabled
        )
    }
    fun mapDbModelToEntity(parkItemDbModel: ParkItemDbModel): ParkItem{
        return ParkItem(
            id =parkItemDbModel.id,
            name = parkItemDbModel.name,
            firm = parkItemDbModel.firm,
            dateFrom = parkItemDbModel.dateFrom,
            dateTo = parkItemDbModel.dateTo,
            about = parkItemDbModel.about,
            enabled = parkItemDbModel.enabled
        )
    }

    fun mapListDbModelToListEntity(list: List<ParkItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}
