package com.example.bc_parking1beta



object SampleData {

    private val movieModel= listOf(
        ItemModel(Images.imageUrl0),
        ItemModel(Images.imageUrl1),
        ItemModel(Images.imageUrl2),
        ItemModel(Images.imageUrl4),
        ItemModel(Images.imageUrl5),
        ItemModel(Images.imageUrl6),
        ItemModel(Images.imageUrl7),
        ItemModel(Images.imageUrl8),
        ItemModel(Images.imageUrl9)
    )

    val collections = listOf(
        MainModel("All Movie" , movieModel),
        MainModel("Want to see" , movieModel.reversed()),
        MainModel("Popular Movie" , movieModel.shuffled()),
        MainModel("Top Rated Movie" , movieModel)

    )
}